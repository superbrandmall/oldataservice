package com.sbm.module.onlineleasing.base.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbm.module.common.base.util.ListUtil;
import com.sbm.module.common.business.dao.impl.BaseHibernateDaoImpl;
import com.sbm.module.common.business.domain.BaseEntity;
import com.sbm.module.common.business.domain.HqlData;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.api.searchshop.domain.SearchShopVo;
import com.sbm.module.onlineleasing.base.shop.dao.ITOLShopDao;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;

/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.dao.impl<br/>
 * File Name:EdiInteractiveDetailDaoImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午4:41:35 <br/>
 * 
 * @author ：junkai.zhang
 * @preserve public
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
@Repository
public class TOLShopDaoImpl extends BaseHibernateDaoImpl<TOLShop> implements ITOLShopDao {

	public List<TOLShop> findAll() {
		String hql = "from TOLShop";
		List<TOLShop> list = find(hql);
		return list;
	}

	public TOLShop findByCode(String code) {
		StringBuffer sb = new StringBuffer("from TOLShop where 1=1 ");
		sb.append(" and code = ? ");
		List<TOLShop> list = find(sb.toString(), code);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLShop findByHdUuid(String hdUuid) {
		StringBuffer sb = new StringBuffer("from TOLShop where 1=1 ");
		sb.append(" and hdUuid = ?");
		List<TOLShop> list = find(sb.toString(), hdUuid);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public TOLShop findByCondition(TOLShop obj) {
		StringBuffer sb = new StringBuffer("from TOLShop where 1=1 ");
		sb.append(" and unit = ? ");
		sb.append(" and buildingCode = ? ");
		sb.append(" and mallCode = ? ");
		sb.append(" and hdState = 'using' ");
		List<TOLShop> list = find(sb.toString(),
				new Object[] { obj.getUnit(), obj.getBuildingCode(), obj.getMallCode() });
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public List<TOLShop> findAllBySearchShop(SearchShopVo vo) {
		StringBuffer sb = new StringBuffer("from TOLShop where 1=1 ");
		// TODO 目前只能按照这个条件取
		sb.append(" and mallCode in ").append(ListUtil.strList2HQLStr(vo.getMallCodes()));
		// 取待租空铺
		sb.append(" and shopState in (1, 2)");
		// 取除面积为空（异常数据）
		sb.append(" and area is not null ");
		sb.append(" and hdState = 'using' ");
		// 未锁定
		sb.append(" and state = 1 ");
		List<TOLShop> list = find(sb.toString());
		return list;
	}

	public List<TOLShop> findAllByCondition(TOLShop obj) {
		return find(findAllByConditionHql(obj));
	}

	public Pagination<TOLShop> findAllByConditionPage(TOLShop obj) {
		return pageQuery(findAllByConditionHql(obj));
	}

	private HqlData findAllByConditionHql(TOLShop obj) {
		HqlData data = getHqlData(obj);
		StringBuffer sb = new StringBuffer("from TOLShop where 1=1 ");
		// sb.append(" and userCode = ? ");
		// data.getObjs().add(obj.getUserCode());
		// if (null != obj.getType()) {
		// sb.append(" and type = ? ");
		// data.getObjs().add(obj.getType());
		// }
		sb.append(" and hdState = 'using' ");
		sb.append(" order by id desc ");
		data.setHql(sb.toString());
		return data;
	}

	@Override
	public List<TOLShop> findAllByFloorCode(String floorCode) {
		StringBuffer sb = new StringBuffer("from TOLShop where 1=1 ");
		sb.append(" and floorCode = ? ");
		sb.append(" and hdState = 'using' ");
		// 未锁定
		sb.append(" and state = 1 ");
		List<TOLShop> list = find(sb.toString(), floorCode);
		return list;
	}

	public List<TOLShop> findCountGroupByMall(String mallCode) {
		StringBuffer sb = new StringBuffer(
				"select new TOLShop(mallCode, modality, count(*) as count) from TOLShop where 1=1 ");
		sb.append(" and mallCode = ? ");
		// 取在租铺位
		sb.append(" and shopState = '0' ");
		sb.append(" and hdState = 'using' ");
		sb.append(" group by mallCode, modality");
		sb.append(" order by count(*) desc");
		BaseEntity vo = new BaseEntity();
		return query(sb.toString(), vo, mallCode);
	}

	public List<TOLShop> findCountGroupByFloor(String floorCode) {
		StringBuffer sb = new StringBuffer(
				"select new TOLShop(floorCode, modality, count(*) as count) from TOLShop where 1=1 ");
		sb.append(" and floorCode = ? ");
		// 取在租铺位
		sb.append(" and shopState = '0' ");
		sb.append(" and hdState = 'using' ");
		sb.append(" group by floorCode, modality");
		sb.append(" order by count(*) desc");
		BaseEntity vo = new BaseEntity();
		vo.setPageCount(3);
		return query(sb.toString(), vo, floorCode);
	}

	public List<TOLShop> findCountGroupByMallBuildingFloor(String mallCode, String buildingCode, String floorCode) {
		StringBuffer sb = new StringBuffer(
				"select new TOLShop(mallCode, buildingCode, floorCode, modality, count(*) as count) from TOLShop where 1=1 ");
		sb.append(" and mallCode = ? ");
		sb.append(" and buildingCode = ? ");
		sb.append(" and floorCode = ? ");
		// 取在租铺位
		sb.append(" and shopState = '0' ");
		sb.append(" and hdState = 'using' ");
		sb.append(" group by mallCode, buildingCode, floorCode, modality");
		List<TOLShop> list = find(sb.toString(), mallCode, buildingCode, floorCode);
		return list;
	}


}
