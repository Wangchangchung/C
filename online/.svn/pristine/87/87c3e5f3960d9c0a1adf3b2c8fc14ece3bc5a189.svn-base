package cn.edu.xiyou.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.edu.xiyou.entity.Share;

public interface ShareDao extends JpaRepository<Share, String>{

	public abstract Page<Share> findAll(Pageable paramPageable);
	
}
