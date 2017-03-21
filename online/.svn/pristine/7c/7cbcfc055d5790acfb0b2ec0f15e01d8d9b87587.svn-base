package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.edu.xiyou.entity.CourseVideo;
import cn.edu.xiyou.entity.Section;

public interface SectionDao extends JpaRepository<Section, String>{

	public abstract List<Section> findByCourseVideo(CourseVideo courseVideo);
	
	public abstract List<Section> findByCourseVideoOrderBySectionNumAsc(CourseVideo courseVideo);

}
