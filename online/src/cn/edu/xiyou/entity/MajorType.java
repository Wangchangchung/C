package cn.edu.xiyou.entity;

import javax.persistence.Entity;

import cn.edu.xiyou.base.BaseEntity;
/**
 * 专业类别
 * @author zhengxiangrui
 *
 */
@Entity
public class MajorType extends BaseEntity {
	/**
	 * 专业类别名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
