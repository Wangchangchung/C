package cn.edu.xiyou.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import cn.edu.xiyou.base.BaseEntity;

/**
 * 职位标签
 * @author GuoLei
 *
 */
@Entity
public class JobTag extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -871069134702737664L;

	/**
	 * 职位标签名称
	 */
	private String name;
	
	/**
	 * 所属行业
	 */
	@ManyToOne
	private JobType jobType;
	
	/**
	 * 所属职位
	 */
	@OneToOne(mappedBy="jobTag",fetch=FetchType.EAGER)
	
	private Job job;

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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
}
