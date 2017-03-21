package cn.edu.xiyou.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.Comment;
import cn.edu.xiyou.entity.User;

@Transactional
public interface UserDao extends JpaRepository<User, String>{
	public abstract List<User> findByEmail(String email);
	public abstract List<User> findByEmailAndPassword(String email,String password);
	public User findById(String id);
	
}
