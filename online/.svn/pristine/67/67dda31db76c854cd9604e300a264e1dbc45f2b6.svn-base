package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.CourseTypeTwo;

@Transactional
public interface CourseTypeTwoDao extends JpaRepository<CourseTypeTwo, String>{

	public CourseTypeTwo findById(String id);
	
	public abstract List<CourseTypeTwo> findAll();
	
}
