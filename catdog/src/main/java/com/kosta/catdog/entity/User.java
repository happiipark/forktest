package com.kosta.catdog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Builder
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num; // 회원 번호 
	
	private String name;  // 회원 이름 
	
	@Column(unique=true)
	private String id ;  // 로그인시 필요한 Id
	
	@Column(unique=true)
	private String nickname ;  // 닉네임 
	
	private String password ;  // 비밀번호
	
	private String tel;
	
	@Column(unique=true)
	private String emali ;  // 이메일
	
	private String kid; // 카카오 연동시 사용될 컬럼 
	
	private Boolean state; // 회원 상태 사용 유저 - true , 탈퇴 - false
	
//	@CreationTimestamp
//	private java.sql.Timestamp createDate;
	
//	public List<String> getRoleList(){
//		if(this.roles.length()>0) {
//			return Arrays.asList(this.roles.split(","));
//		}
//		return new ArrayList<>();
//	}
	
	
}
