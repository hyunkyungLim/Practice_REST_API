package com.example.demo.mapper;

import com.example.demo.dto.Content;
import com.example.demo.dto.Statistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContentMapper {

    List<Content> selectAll();
    List<Content> detail(String uid);
    Statistics statistics();
}
