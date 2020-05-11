package com.second.jpaoracle.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.second.jpaoracle.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
