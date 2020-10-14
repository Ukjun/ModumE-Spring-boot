package com.amolrang.modume.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amolrang.modume.mapper.UserMapper;
import com.amolrang.modume.model.UserModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDAO {
	@Autowired
	UserMapper userMapper;

	public UserModel findById(String id) {
		return userMapper.readUser(id);
	}

	public UserModel save(UserModel userModel, String role) {
		userMapper.insertUser(userModel);
		userMapper.insertUserAutority(userModel.getUser_id(), role);
		return userModel;
	}

	public List<String> findAuthoritiesByID(String username) {
		return userMapper.readautorities(username);
	}
}
