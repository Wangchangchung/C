package cn.edu.xiyou.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.edu.xiyou.base.BaseEntity;

/**
 * 章节
 * 
 * @author zhangpan
 */
@Entity
public class Section extends BaseEntity {
	/**
	 * 章节编号
	 */
	private int sectionNum;

	/**
	 * 章节名称
	 */
	private String name;
	/**
	 * 短描述
	 */
	private String shortDesc;
	/**
	 * 全套视频_外键
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private CourseVideo courseVideo;

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

	public CourseVideo getCourseVideo() {
		return courseVideo;
	}

	public void setCourseVideo(CourseVideo courseVideo) {
		this.courseVideo = courseVideo;
	}

	public int getSectionNum() {
		return sectionNum;
	}

	public void setSectionNum(int sectionNum) {
		this.sectionNum = sectionNum;
	}

}
