package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.Course;
import cn.edu.xiyou.entity.CourseVideo;


@Transactional
public interface CourseVideoDao extends JpaRepository<CourseVideo, String>{

	public abstract List<CourseVideo> findByCourse(Course course);
	
}