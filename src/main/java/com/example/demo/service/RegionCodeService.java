package com.example.demo.service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.mapper.RegionCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionCodeService {

    @Autowired
    private RegionCodeMapper regionCodeMapper;

    public List<String> sido() {
        return regionCodeMapper.sido();
    }

    public List<String> sigungu(String sido) {
        return regionCodeMapper.sigungu(sido);
    }

    public List<String> umd(String sigungu) {
        return regionCodeMapper.umd(sigungu);
    }
}
