package com.example.demo.controller;

import com.example.demo.dto.Bookmark;
import com.example.demo.service.BookmarkService;
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
@RequestMapping(value = "/bookmark")
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<?> bookmark(@RequestHeader("memberId") int m_id,
                         @RequestParam("contentId") String uid) {

        int cnt = bookmarkService.bookmark(new Bookmark(uid, m_id));;
        boolean checkResult = (cnt == 1);

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", 200);
        response.put("message", "성공");
        response.put("data", checkResult);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("")
    @ResponseBody
    public ResponseEntity<?> delete(@RequestHeader("memberId") int m_id,
                       @RequestParam("contentId") String uid) {

        int cnt = bookmarkService.delete(new Bookmark(uid, m_id));
        boolean checkResult =  (cnt == 1);

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", 200);
        response.put("message", "성공");
        response.put("data", checkResult);

        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<?> selectAll(@RequestHeader("memberId") String m_id) {
        List<Bookmark> bookmarkList = bookmarkService.select(m_id);
        return ResponseEntity.ok(bookmarkList);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exeption(Exception e) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        response.put("message", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return ResponseEntity.ok(response);
    }
}
