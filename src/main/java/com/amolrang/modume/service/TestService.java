package com.amolrang.modume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amolrang.modume.mapper.TestMapper;

@Service
public class TestService {
	@Autowired
	private TestMapper mapper;

	public String getMembers() {
		return null;
	}
}
