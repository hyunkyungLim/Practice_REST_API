package com.example.demo.controller;

import com.example.demo.service.RegionCodeService;
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
@RequestMapping("/region-code")
public class RegionCodeController {

    private final RegionCodeService regionCodeService;

    @GetMapping(value="")
    @ResponseBody
    public ResponseEntity<List<?>> sido() {
        List<String> regionList = regionCodeService.sido();
        return ResponseEntity.ok(regionList);
    }

    @GetMapping(value="/{sido}")
    @ResponseBody
    public ResponseEntity<List<?>> region(@PathVariable("sido") String sido) {
        List<String> sigunguList = regionCodeService.sigungu(sido);
        return ResponseEntity.ok(sigunguList);
    }

    @GetMapping(value="/{sido}/{sigungu}")
    @ResponseBody
    public ResponseEntity<List<?>> umd(@PathVariable("sigungu") String sigungu) {
        List<String> umdList = regionCodeService.umd(sigungu);
        return ResponseEntity.ok(umdList);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exeption(Exception e) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        response.put("message", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return ResponseEntity.ok(response);
    }

}
