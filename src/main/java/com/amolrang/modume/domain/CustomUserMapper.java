package com.amolrang.modume.domain;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.amolrang.modume.repository.MemberDTO;

@Mapper
public interface CustomUserMapper {
	@Select("select * from t_user where id = #{user_email}")
	MemberDTO chkLogin(String user_email);

}
