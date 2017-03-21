package cn.edu.xiyou.entity;

import java.util.Date;

import javax.persistence.Entity;

import cn.edu.xiyou.base.BaseEntity;
/**
 * 评价内容
 * @author ZXR
 *
 */
@Entity
public class Comment extends BaseEntity{
	
	private String jobid;
	private String text;
	private Date date;
	
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
