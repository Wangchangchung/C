package cn.edu.xiyou.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import cn.edu.xiyou.base.BaseEntity;

/**
 * 
 * 单个课程
 * 
 * @author zhangpan
 *
 */
@Entity
public class SectionVideo extends BaseEntity {
	/**
	 * 视频的编号
	 */
	private int svNum;

	/**
	 * 章节视频名称
	 */
	private String name;
	/**
	 * 链接
	 */
	private String sectionVideoUrl;
	/**
	 * 视频时长
	 */
	private String sectionVideoTime;

	/**
	 * 描述
	 */
	private String sectionVideoDesc;
	/**
	 * 是否能看状态
	 */
	private boolean sectionVideoState;
	/**
	 * 章节（外键）
	 */

	@ManyToOne(fetch=FetchType.LAZY)
	private Section section;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSectionVideoUrl() {
		return sectionVideoUrl;
	}

	public void setSectionVideoUrl(String sectionVideoUrl) {
		this.sectionVideoUrl = sectionVideoUrl;
	}

	public String getSectionVideoTime() {
		return sectionVideoTime;
	}

	public void setSectionVideoTime(String sectionVideoTime) {
		this.sectionVideoTime = sectionVideoTime;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getSectionVideoDesc() {
		return sectionVideoDesc;
	}

	public void setSectionVideoDesc(String sectionVideoDesc) {
		this.sectionVideoDesc = sectionVideoDesc;
	}

	public int getSvNum() {
		return svNum;
	}

	public void setSvNum(int svNum) {
		this.svNum = svNum;
	}

	public boolean isSectionVideoState() {
		return sectionVideoState;
	}

	public void setSectionVideoState(boolean sectionVideoState) {
		this.sectionVideoState = sectionVideoState;
	}
	

}
