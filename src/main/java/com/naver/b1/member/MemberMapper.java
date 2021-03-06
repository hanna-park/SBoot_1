package com.naver.b1.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
	public int memberJoin(MemberVO memberVO) throws Exception;
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;

	public MemberVO idCheck(MemberVO memberVO) throws Exception;

}

