package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.JobType;

@Transactional
public interface JobTypeDao extends JpaRepository<JobType, String>{

	public List<JobType> findAll();
	
	public JobType findById(String id);
	
}
