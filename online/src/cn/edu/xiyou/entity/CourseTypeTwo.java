package cn.edu.xiyou.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import cn.edu.xiyou.base.BaseEntity;

/**
 * 二级课程类别
 * @author zhengxiangrui
 *
 */
@Entity
public class CourseTypeTwo extends BaseEntity{
	/**
	 * 课程类别名称
	 */
	private String name;
	/**
	 * 一级课程类别
	 */
	@ManyToOne
	private CourseTypeOne courseTypeOne;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CourseTypeOne getCourseTypeOne() {
		return courseTypeOne;
	}
	public void setCourseTypeOne(CourseTypeOne courseTypeOne) {
		this.courseTypeOne = courseTypeOne;
	}

	
}
