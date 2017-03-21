package cn.edu.xiyou.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import cn.edu.xiyou.base.BaseEntity;

@Entity
public class Share extends BaseEntity{

	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 更新时间
	 */
	private Date modified;
	
	/**
	 * 用户
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	/**
	 * 图片
	 */
	private String picUrl;
	
	/**
	 * 发表时间
	 */
	private String time;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	
}
