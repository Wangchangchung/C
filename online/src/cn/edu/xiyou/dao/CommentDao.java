package cn.edu.xiyou.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.Comment;

@Transactional
public interface CommentDao extends JpaRepository<Comment, String>{

	public abstract Page<Comment> findByJobid(String jobid, Pageable paramPageable);
	
}
