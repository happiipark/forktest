package com.kosta.catdog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.catdog.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);
	
	User findById(String id);
	
	User findByNickname(String nickname);

}
