package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.dto.Statistics;
import com.example.demo.service.StatisticsSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping(value = "/statistics")
public class StatisticsController {

    private final StatisticsSerivce statisticsSerivce;

    @GetMapping(value = "/content")
    @ResponseBody
    public ResponseEntity<List<Statistics>> statistis() {
        List<Statistics> statisticsList = statisticsSerivce.statistics();
        return ResponseEntity.ok(statisticsList);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exeption(Exception e) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        response.put("message", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return ResponseEntity.ok(response);
    }
}
