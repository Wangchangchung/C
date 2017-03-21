package cn.edu.xiyou.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.edu.xiyou.base.BaseEntity;
/**
 * 用户
 * @author sony
 *
 */
@Entity
public class User extends BaseEntity {
	/**
	 * 账号 / 邮箱
	 */
	private String email;
	/**
	 * 昵称
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 高中学校
	 */
	private String school;
	/**
	 * 大学
	 */
	private String university;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 公司
	 */
	private String company;
	/**
	 * 职位
	 */
	private String position;
	
	/**
	 * 目标职位
	 */
	private String tPosition;
	
	/**
	 * 目标行业
	 */
	private String tJobType;
	
	/**
	 * 工作类型(0：全职  1：实习 2：兼职)
	 */
	private Integer workType;
	
	/**
	 * 薪资水平
	 */
	private String salary;
	
	/**
	 * 目标工作地点
	 */
	private String tPlace;
	
	/**
	 * 用户类别
	 */
	@ManyToOne
	private UserType userType;
	
	/**
	 * 分享圈
	 *//*
	@Deprecated
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<Share> shares;*/
	
	/**
	 * 头像
	 */
	private String head;
	
	/**
	 * 个性签名
	 */
	private String introduction;
	
	/**
	 * 性别
	 */
	private String sex;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	/*public List<Share> getShares() {
		return shares;
	}
	public void setShares(List<Share> shares) {
		this.shares = shares;
	}*/
	public String gettPosition() {
		return tPosition;
	}
	public void settPosition(String tPosition) {
		this.tPosition = tPosition;
	}
	public String gettJobType() {
		return tJobType;
	}
	public void settJobType(String tJobType) {
		this.tJobType = tJobType;
	}
	public Integer getWorkType() {
		return workType;
	}
	public void setWorkType(Integer workType) {
		this.workType = workType;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String gettPlace() {
		return tPlace;
	}
	public void settPlace(String tPlace) {
		this.tPlace = tPlace;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
