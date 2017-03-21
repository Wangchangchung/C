package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.Section;
import cn.edu.xiyou.entity.SectionVideo;

@Transactional
public interface SectionVideoDao extends JpaRepository<SectionVideo, String>{

	public abstract List<SectionVideo> findBySection(Section section);
	
	public abstract List<SectionVideo> findBySectionOrderBySvNumAsc(Section section);
	
}