package com.amolrang.modume.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amolrang.modume.mapper.UserMapper;
import com.amolrang.modume.model.UserModel;

@Repository
public class UserDAO {
	@Autowired
	UserMapper userMapper;

	public UserModel findById(String username) {
		return userMapper.readUser(username);
	}

	public UserModel save(UserModel userModel, String role) {
		System.out.println(role);
		System.out.println(userModel.getId());
		System.out.println(userModel.getPassword());
		System.out.println(userModel.isAccountNonExpired());
		System.out.println(userModel.isAccountNonLocked());
		System.out.println(userModel.isCredentialsNonExpired());
		System.out.println(userModel.isEnabled());
		userMapper.insertUser(userModel);
		userMapper.insertUserAutority(userModel.getId(), role);
		return userModel;
	}

	public List<String> findAuthoritiesByID(String username) {
		return userMapper.readautorities(username);
	}
}
