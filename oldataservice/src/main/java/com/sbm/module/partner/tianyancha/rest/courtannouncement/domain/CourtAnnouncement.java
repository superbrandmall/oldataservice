package com.sbm.module.partner.tianyancha.rest.courtannouncement.domain;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.partner.tianyancha.rest.courtannouncement.domain<br/>
 * File Name:CourtAnnouncement.java<br/>
 * 
 * 作成日 ：2017-10-18 下午2:37:20 <br/>
 * 
 * @author ：junkai.zhang
 */
public class CourtAnnouncement {

	private Long id;

	/**
	 * 公告id
	 */
	private Long announce_id;

	/**
	 * 公告号
	 */
	private String bltnno;

	/**
	 * 公告状态号
	 */
	private String bltnstate;

	/**
	 * 公告类型
	 */
	private String bltntype;

	/**
	 * 公告类型名称
	 */
	private String bltntypename;

	/**
	 * 案件号
	 */
	private String caseno;

	/**
	 * 案件内容
	 */
	private String content;

	/**
	 * 法院名
	 */
	private String courtcode;

	/**
	 * 处理等级
	 */
	private String dealgrade;

	/**
	 * 处理等级名称
	 */
	private String dealgradename;

	/**
	 * 法官
	 */
	private String judge;

	/**
	 * 法官电话
	 */
	private String judgephone;

	/**
	 * 手机号
	 */
	private String mobilephone;

	/**
	 * 原告
	 */
	private String party1;

	/**
	 * 当事人
	 */
	private String party2;

	/**
	 * 省份
	 */
	private String province;

	/**
	 * 刊登日期
	 */
	private String publishdate;

	/**
	 * 刊登版面
	 */
	private String publishpage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnnounce_id() {
		return announce_id;
	}

	public void setAnnounce_id(Long announce_id) {
		this.announce_id = announce_id;
	}

	public String getBltnno() {
		return bltnno;
	}

	public void setBltnno(String bltnno) {
		this.bltnno = bltnno;
	}

	public String getBltnstate() {
		return bltnstate;
	}

	public void setBltnstate(String bltnstate) {
		this.bltnstate = bltnstate;
	}

	public String getBltntype() {
		return bltntype;
	}

	public void setBltntype(String bltntype) {
		this.bltntype = bltntype;
	}

	public String getBltntypename() {
		return bltntypename;
	}

	public void setBltntypename(String bltntypename) {
		this.bltntypename = bltntypename;
	}

	public String getCaseno() {
		return caseno;
	}

	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCourtcode() {
		return courtcode;
	}

	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}

	public String getDealgrade() {
		return dealgrade;
	}

	public void setDealgrade(String dealgrade) {
		this.dealgrade = dealgrade;
	}

	public String getDealgradename() {
		return dealgradename;
	}

	public void setDealgradename(String dealgradename) {
		this.dealgradename = dealgradename;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getJudgephone() {
		return judgephone;
	}

	public void setJudgephone(String judgephone) {
		this.judgephone = judgephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getParty1() {
		return party1;
	}

	public void setParty1(String party1) {
		this.party1 = party1;
	}

	public String getParty2() {
		return party2;
	}

	public void setParty2(String party2) {
		this.party2 = party2;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getPublishpage() {
		return publishpage;
	}

	public void setPublishpage(String publishpage) {
		this.publishpage = publishpage;
	}

}
