package cn.edu.xiyou.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import cn.edu.xiyou.base.BaseEntity;
/**
 * 视频资源
 * @author  张盼
 *
 */
@Entity
public class CourseVideo extends BaseEntity{
	/**
	 * 资源名称
	 * */
	private String name;
	/**
	 * 资源短描述
	 * */
	private String shortDesc;
	/**
	 * 资源长描述
	 * */
	private String longDesc;
	/**
	 * 资源来源
	 * */
	private String source;
	/**
	 * 教授该视频的老师
	 */
	private String teacher;
	/**
	 *资源 图片路径
	 */
	private String imageUrl;
	/**
	 * 资源赞的数量
	 */
	private int hotCount;
	/**
	 * 归属哪个课程
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	private Course course;
	

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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getHotCount() {
		return hotCount;
	}
	public void setHotCount(int hotCount) {
		this.hotCount = hotCount;
	}	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	

	
}
