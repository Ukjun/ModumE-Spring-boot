package com.amolrang.modume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.amolrang.modume.repository.MemberModel;

@Mapper
public interface MemberMapper {
	
	@Select("select * from member")
	List<MemberModel> getMember();
}
