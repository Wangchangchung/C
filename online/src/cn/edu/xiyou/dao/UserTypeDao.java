package cn.edu.xiyou.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xiyou.entity.UserType;

@Transactional
public interface UserTypeDao extends JpaRepository<UserType, String>{

}
