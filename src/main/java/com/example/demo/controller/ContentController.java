package com.example.demo.controller;

import com.example.demo.dto.Content;
import com.example.demo.service.ContentService;
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
@RequestMapping(value = "content")
public class ContentController {

    private final ContentService contentService;

    @GetMapping(value = "")
    @ResponseBody
    public ResponseEntity<?> content(){
        List<Content> contentList = contentService.selectAll();
        return ResponseEntity.ok(contentList);
    }

    @GetMapping(value = "/{contentId}")
    @ResponseBody
    public ResponseEntity<?> detail(@RequestParam("contentId") String uid) {
        List<Content> contentList = contentService.detail(uid);
        return ResponseEntity.ok(contentList);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exeption(Exception e) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        response.put("message", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return ResponseEntity.ok(response);
    }
}
