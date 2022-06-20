package com.example.demo.service;

import com.example.demo.dto.Member;
import com.example.demo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberSerivce {

    @Autowired
    private MemberMapper memberMapper;

    public int checkEmail(String email) {
        return memberMapper.checkEmail(email);
    }

    public int checkNickname(String nickname) {
        return memberMapper.checkNickname(nickname);
    }

    public int signUp(Member member) {
        return memberMapper.signUp(member);
    }
}
