package com.example.demo.mapper;

import com.example.demo.dto.Statistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StatisticsMapper {

    List<Statistics> statistics();
}
