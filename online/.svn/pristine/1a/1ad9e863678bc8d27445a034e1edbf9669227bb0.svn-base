package cn.edu.xiyou.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import cn.edu.xiyou.base.BaseEntity;

/**
 * 职业
 * 
 * @author zhengxiangrui
 *
 */
@Entity
public class Job extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8211275887985882918L;

	/**
	 * 更新时间
	 */
	private Date modified;
	
	/**
	 * 职位名称
	 */
	private String jobName;

	/**
	 * 职位标签
	 */
	@OneToOne
	@JoinColumn(name="jobTag_id",insertable=true,unique=true) 
	private JobTag jobTag;
	
	/**
	 * 公司名称
	 */
	private String company;
	
	/**
	 * 行业
	 */
	@ManyToOne
	private JobType jobType;

	/**
	 * 联系方式
	 */
	private String phone;
	
	/**
	 * 工作类型(0：全职  1：实习 2：兼职)
	 */
	private Integer workType;

	/**
	 * 薪资水平
	 */
	private String salary;
	
	/**
	 * 工作地点
	 */
	private String place;
	
	/**
	 * 职业长描述
	 */

	private String longDesc;
	
	/**
	 * 资源集合（单向多对多：只在课程类存有资源类的集合，资源类并不知道自己属于哪个课程）
	 */
	@ManyToMany
	@JoinTable(name = "job_course", // 给中间表命名
			joinColumns = { @JoinColumn(name = "jobId") }, // 设置中间表的外键字段，该字段指向当前类(Job)的Id字段
			inverseJoinColumns = { @JoinColumn(name = "courseId") } // 设置中间表的另一个外键字段，该字段指向另一个类(Course)的Id字段
	)
	private Set<Course> courses = new HashSet<Course>();
	
	/**
	 * 工作经验
	 */
	private String experience;
	
	/**
	 * 学历
	 */
	private String education;
	
	/**
	 * 详细地址
	 */
	private String detailPlace;
	
	/**
	 * 职业类型名称(废弃)
	 */
	@Deprecated
	private String name;
	
	/**
	 * 职业图片路径(废弃)
	 */
	@Deprecated
	private String imageUrl;
	
	/**
	 * 职位需求(废弃)
	 */
	@Deprecated
	private String req;

	/**
	 * 职业短描述(废弃)
	 */
	@Deprecated
	private String shortDesc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

    @Lob   
    @Basic(fetch = FetchType.LAZY)   
    @Type(type="text")  
    @Column(name="longDesc", nullable=true)   
	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getWorkType() {
		return workType;
	}

	public void setWorkType(Integer workType) {
		this.workType = workType;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public JobTag getJobTag() {
		return jobTag;
	}

	public void setJobTag(JobTag jobTag) {
		this.jobTag = jobTag;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDetailPlace() {
		return detailPlace;
	}

	public void setDetailPlace(String detailPlace) {
		this.detailPlace = detailPlace;
	}
	
}
