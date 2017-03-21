package cn.edu.xiyou.entity;

import javax.persistence.Entity;

import cn.edu.xiyou.base.BaseEntity;

/**
 * 一级课程类别
 * @author zhengxiangrui
 *
 */
@Entity
public class CourseTypeOne extends BaseEntity{
	
	/**
	 * 课程名称
	 */
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
