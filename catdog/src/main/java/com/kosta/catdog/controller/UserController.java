package com.kosta.catdog.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.catdog.entity.User;
import com.kosta.catdog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	// id 중복 체크 
	@GetMapping("/checkuserid")
	String checkUserId(@RequestParam(required=false)String id) {
		System.out.println("checkUserId =========");
		System.out.println("Id : " + id);
		User user = userRepository.findById(id);
			if(user == null) {
				return "success";	
			}else {
				return "err";
			}
		
	}
	
	
	// nickname 중복 체크 
	@GetMapping("/checkusernickname")
	String checkUserNickname(@RequestParam(required=false)String nickname) {
			User user = userRepository.findByNickname(nickname);
			if(user == null) {
				return "success";	
			}else {
				return "err";
			}
		
	}
	
	
	@GetMapping("userjoin")
	public String userjoin() {
		System.out.println("React UserJoin");
		return "userjoin";
	}
	 
	
	@PostMapping("userjoin")
	public String join(@RequestBody User userinfo) {
		userinfo.setPassword(bCryptPasswordEncoder.encode(userinfo.getPassword()));
		userRepository.save(userinfo);
		return "joinsuccess";
	}

}
