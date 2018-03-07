package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Forum {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int forumId;
	String forumName;
	String forumContent;
	Date forumcreateDate;
	String forumusername;
	String forumstatus;

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}

	public Date getForumcreateDate() {
		return forumcreateDate;
	}

	public void setForumcreateDate(Date forumcreateDate) {
		this.forumcreateDate = forumcreateDate;
	}

	public String getForumusername() {
		return forumusername;
	}

	public void setForumusername(String forumusername) {
		this.forumusername = forumusername;
	}

	public String getForumstatus() {
		return forumstatus;
	}

	public void setForumstatus(String forumstatus) {
		this.forumstatus = forumstatus;
	}

	@Override
	public String toString() {
		return "Forum [forumId=" + forumId + ", forumName=" + forumName + ", forumContent=" + forumContent
				+ ", forumcreateDate=" + forumcreateDate + ", forumusername=" + forumusername + ", forumstatus="
				+ forumstatus + "]";
	}

}
