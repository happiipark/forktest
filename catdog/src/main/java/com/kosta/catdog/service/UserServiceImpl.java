package com.kosta.catdog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.catdog.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;



}
