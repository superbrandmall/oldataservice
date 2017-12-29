package com.sbm.module.onlineleasing.api.storage.blob.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobContainerPermissions;
import com.microsoft.azure.storage.blob.BlobContainerPublicAccessType;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import com.microsoft.azure.storage.core.Utility;
import com.sbm.module.common.base.constant.BusinessCode;
import com.sbm.module.common.base.exception.BusinessException;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.verificationcode.util<br/>
 * File Name:VerificationCodeUtil.java<br/>
 * 
 * 作成日 ：2017-8-7 上午9:44:04 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class BlobClientUtil {

	@Value("#{propertiesReader['storage.storageConnectionString']}")
	private String storageConnectionString;

	private static Map<String, String> settings = null;

	public static final String DEFAULT_ENDPOINTS_PROTOCOL_NAME = "DefaultEndpointsProtocol";
	public static final String _CONNECT = "://";
	public static final String ACCOUNT_NAME_NAME = "AccountName";
	public static final String DOT = ".";
	public static final String TYPE = "blob";
	public static final String ENDPOINT_SUFFIX_NAME = "EndpointSuffix";
	public static final String SEPARATOR = "/";

	private CloudStorageAccount storageAccount;
	private CloudBlobClient blobClient;
	private CloudBlobContainer container;

	/**
	 * 
	 * initContainer:初始化容器，不创建
	 * 
	 * @author junkai.zhang
	 * @param containerName
	 */
	public void initContainer(String containerName) {
		initContainer(containerName, false);
	}

	/**
	 * 
	 * initContainer:初始化容器
	 * 
	 * @author junkai.zhang
	 * @param containerName
	 * @param createIfNotExists
	 *            不存在是否创建
	 */
	public void initContainer(String containerName, boolean createIfNotExists) {
		try {
			// Retrieve storage account from connection-string.
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
			// Create the blob client.
			blobClient = storageAccount.createCloudBlobClient();
			// Get a reference to a container.
			// The container name must be lower case
			container = blobClient.getContainerReference(containerName);
			// Create the container if it does not exist.
			if (createIfNotExists) {
				container.createIfNotExists();
			}
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C2000, new Object[] { containerName }, e);
		}
	}

	/**
	 * 
	 * setPublicAccessPermissions:设置公开访问权限
	 * 
	 * @author junkai.zhang
	 */
	public void setPublicAccessPermissions() {
		try {
			// Create a permissions object.
			BlobContainerPermissions containerPermissions = new BlobContainerPermissions();
			// Include public access in the permissions object.
			containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);
			// Set the permissions on the container.
			container.uploadPermissions(containerPermissions);
		} catch (StorageException e) {
			throw new BusinessException(BusinessCode.C2001, null, e);
		}
	}

	/**
	 * 
	 * upload:上传
	 * 
	 * @author junkai.zhang
	 * @param blobName
	 *            blob名称
	 * @param sourceStream
	 *            流
	 * @param length
	 *            长度
	 */
	public void upload(String blobName, InputStream sourceStream, long length) {
		try {
			CloudBlockBlob blob = container.getBlockBlobReference(blobName);
			blob.upload(sourceStream, length);
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C2002, new Object[] { container.getName(), blobName }, e);
		}
	}

	/**
	 * 
	 * listBlobs:列出容器内所有blob
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	public List<ListBlobItem> listBlobs() {
		return listBlobs(StringUtils.EMPTY);
	}

	/**
	 * 
	 * listBlobs:根据前缀列出blob
	 * 
	 * @author junkai.zhang
	 * @param prefix
	 *            前缀
	 * @return
	 */
	public List<ListBlobItem> listBlobs(String prefix) {
		List<ListBlobItem> list = IteratorUtils.toList(container.listBlobs(prefix, true).iterator());
		return list;
	}

	/**
	 * 
	 * listBlobItem:获取指定blob
	 * 
	 * @author junkai.zhang
	 * @param blobName
	 * @return
	 */
	public ListBlobItem listBlobItem(String blobName) {
		List<ListBlobItem> list = listBlobs(blobName);
		if (null != list && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 
	 * download:下载
	 * 
	 * @author junkai.zhang
	 * @param blobName
	 *            blob名称
	 * @param outStream
	 *            流
	 */
	public void download(String blobName, OutputStream outStream) {
		try {
			CloudBlockBlob blob = container.getBlockBlobReference(blobName);
			blob.download(outStream);
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C2003, new Object[] { container.getName(), blobName }, e);
		}
	}

	/**
	 * 
	 * delete:删除
	 * 
	 * @author junkai.zhang
	 * @param blobName
	 *            blob名称
	 */
	public void delete(String blobName) {
		try {
			CloudBlockBlob blob = container.getBlockBlobReference(blobName);
			// Delete the blob.
			blob.deleteIfExists();
		} catch (Exception e) {
			throw new BusinessException(BusinessCode.C2004, new Object[] { container.getName(), blobName }, e);
		}
	}

	/**
	 * 
	 * deleteContainer:删除容器
	 * 
	 * @author junkai.zhang
	 */
	public void deleteContainer() {
		try {
			container.deleteIfExists();
		} catch (StorageException e) {
			throw new BusinessException(BusinessCode.C2005, new Object[] { container.getName() }, e);
		}
	}

	/**
	 * 
	 * getBlobName:拼接blobName
	 * 
	 * @author junkai.zhang
	 * @param prefix
	 * @param filename
	 * @return
	 */
	public String getBlobName(String prefix, String filename) {
		return prefix + SEPARATOR + filename;
	}

	/**
	 * 
	 * getURI:获取连接字符串
	 * 
	 * @author junkai.zhang
	 * @param blobName
	 * @return
	 */
	public String getURI(String blobName) {
		if (null == settings) {
			settings = Utility.parseAccountString(storageConnectionString);
		}
		StringBuffer sb = new StringBuffer("");
		sb.append(settings.get(DEFAULT_ENDPOINTS_PROTOCOL_NAME));
		sb.append(_CONNECT);
		sb.append(settings.get(ACCOUNT_NAME_NAME));
		sb.append(DOT);
		sb.append(TYPE);
		sb.append(DOT);
		sb.append(settings.get(ENDPOINT_SUFFIX_NAME));
		sb.append(SEPARATOR);
		sb.append(container.getName());
		sb.append(SEPARATOR);
		sb.append(blobName);
		return sb.toString();
	}

}
