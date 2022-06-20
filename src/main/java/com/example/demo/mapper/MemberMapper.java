package com.example.demo.mapper;

import com.example.demo.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    /*이메일 중복 체크*/
    int checkEmail(String email);
    /*닉네임 중복 체크*/
    int checkNickname(String nickname);
    /*회원 등록*/
    int signUp(Member member);

}
