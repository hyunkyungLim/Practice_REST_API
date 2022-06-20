package com.example.demo.service;

import com.example.demo.dto.Content;
import com.example.demo.mapper.ContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private ContentMapper contentMapper;

    public List<Content> selectAll() {
        return contentMapper.selectAll();
    }

    public List<Content> detail(String uid) {
        return contentMapper.detail(uid);
    }
}
