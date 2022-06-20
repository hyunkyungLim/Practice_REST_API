package com.example.demo.controller;


import com.example.demo.dto.Comment;
import com.example.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping(value = "/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value = "")
    @ResponseBody
    public ResponseEntity<?> comment(@RequestParam("commentId") String commentId,
                                     @RequestParam("contentId") String contentId,
                                     @RequestParam("content") String content,
                                     @RequestHeader("memberId") String m_id) {

        commentService.comment(new Comment(commentId, contentId, m_id, content));

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("commentId", commentId);
        response.put("contentId", contentId);
        response.put("content", content);

        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "")
    @ResponseBody
    public ResponseEntity<?> update(@RequestParam("commentId") String commentId,
                                    @RequestParam("contentId") String contentId,
                                    @RequestParam("content") String content,
                                    @RequestHeader("memberId") String m_id) {

        commentService.update(new Comment(commentId, contentId, m_id, content));

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("commentId", commentId);
        response.put("contentId", contentId);
        response.put("content", content);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value="{commentId}")
    public ResponseEntity<?>  delete(@PathVariable("commentId") String commentId,
                                     @RequestHeader("memberId") String memberId){

        int cnt = commentService.delete(commentId);
        boolean checkResult = (cnt == 1);

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", 200);
        response.put("message", "성공");
        response.put("data", checkResult);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> select(@RequestParam("contentId") String cid) {
        List<Comment> commentList = commentService.select(cid);
        return ResponseEntity.ok(commentList);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exeption(Exception e) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        response.put("message", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return ResponseEntity.ok(response);
    }
}
