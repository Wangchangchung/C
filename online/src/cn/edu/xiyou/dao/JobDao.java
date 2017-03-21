package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.Job;

@Transactional
public interface JobDao extends JpaRepository<Job, String> {

	public List<Job> findByJobNameContaining(String jobName, Pageable paramPageable);

	public List<Job> findByJobNameContaining(String jobName);

	public Job findById(String id);

	public abstract Page<Job> findAll(Pageable paramPageable);

	public List<Job> findByName(String name);

	public List<Job> findByNameContaining(String name, PageRequest pageRequest);

	public int countByJobNameContaining(String name);
}
