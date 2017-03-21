package cn.edu.xiyou.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import cn.edu.xiyou.base.BaseEntity;

/**
 * 课程
 * @author zhengxiangrui
 *
 */
@Entity
public class Course extends BaseEntity{
	/**
	 * 课程名称
	 */
	private String name;
	/**
	 * 短描述
	 */
	private String shortDesc;
	/**
	 * 长描述
	 */
	private String longDesc;
	/**
	 * 适用人群
	 */
	private String people;
	/**
	 * 图片路径
	 */
	private String imageUrl;
	/**
	 * 二级课程类别ID
	 */
	private String courseTypeTwoId;	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCourseTypeTwoId() {
		return courseTypeTwoId;
	}
	public void setCourseTypeTwoId(String courseTypeTwoId) {
		this.courseTypeTwoId = courseTypeTwoId;
	}



	
}
