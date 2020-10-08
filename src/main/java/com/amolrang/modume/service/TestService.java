package com.amolrang.modume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amolrang.modume.mapper.MemberMapper;
import com.amolrang.modume.repository.MemberModel;

@Service
public class TestService {
	@Autowired
	private MemberMapper mapper;

	public List<MemberModel> getMembers() {
		return mapper.getMember();
	}
}
