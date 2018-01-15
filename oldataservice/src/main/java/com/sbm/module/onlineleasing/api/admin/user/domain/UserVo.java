package com.sbm.module.onlineleasing.api.admin.user.domain;

import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.user.domain.TOLUser;
import com.sbm.module.onlineleasing.base.usercontacts.domain.TOLUserContacts;

public class UserVo {

	private TOLUser user;

	private TOLUserContacts userContacts;

	private Pagination<TOLUser> pagination;

	public TOLUser getUser() {
		return user;
	}

	public void setUser(TOLUser user) {
		this.user = user;
	}

	public TOLUserContacts getUserContacts() {
		return userContacts;
	}

	public void setUserContacts(TOLUserContacts userContacts) {
		this.userContacts = userContacts;
	}

	public Pagination<TOLUser> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TOLUser> pagination) {
		this.pagination = pagination;
	}
}
