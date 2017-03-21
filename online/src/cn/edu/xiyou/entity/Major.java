package cn.edu.xiyou.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import cn.edu.xiyou.base.BaseEntity;
/**
 * 专业
 * @author zhengxiangrui
 *
 */

@Entity
public class Major extends BaseEntity{
	/**
	 * 专业名称
	 */
	private String name;
	/**
	 * 专业类别
	 */
	@ManyToOne
	private MajorType majorType;
	/**
	 * 专业短描述
	 */
	private String shortDesc;
	/**
	 * 专业长描述
	 */
	private String longDesc;
	/**
	 * 专业图片路径
	 */
	private String imageUrl;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MajorType getMajorType() {
		return majorType;
	}
	public void setMajorType(MajorType majorType) {
		this.majorType = majorType;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
