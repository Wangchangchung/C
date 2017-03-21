package cn.edu.xiyou.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import cn.edu.xiyou.base.BaseEntity;
/**
 * 行业
 * @author zhengxiangrui
 *
 */

@Entity
public class JobType extends BaseEntity {
	/**
	 * 行业名称
	 */
	private String name;
	
	@OneToMany(mappedBy="jobType")
	@Deprecated
	private List<Job> jobs;
	
	/**
	 * 职位标签
	 */
	@OneToMany(mappedBy="jobType")
	private List<JobTag> jobTags;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<JobTag> getJobTags() {
		return jobTags;
	}

	public void setJobTags(List<JobTag> jobTags) {
		this.jobTags = jobTags;
	}
	
}
