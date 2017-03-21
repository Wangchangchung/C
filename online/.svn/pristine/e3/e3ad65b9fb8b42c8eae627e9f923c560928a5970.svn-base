package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.Course;

@Transactional
public interface CourseDao extends JpaRepository<Course, String>{

	public abstract List<Course> findByCourseTypeTwoId(String courseTypeTwoId);
	
	public abstract Page<Course> findAll(Pageable paramPageable);
	
	public abstract List<Course> findAll();
	
	public abstract Page<Course> findByCourseTypeTwoId(String courseTypeTwoId, Pageable paramPageable);
	
}
