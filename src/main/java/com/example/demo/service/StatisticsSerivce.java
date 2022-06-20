package com.example.demo.service;

import com.example.demo.dto.Statistics;
import com.example.demo.mapper.StatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsSerivce {

    @Autowired
    private StatisticsMapper statisticsMapper;

    public List<Statistics>  statistics() {
        return statisticsMapper.statistics();
    }
}
