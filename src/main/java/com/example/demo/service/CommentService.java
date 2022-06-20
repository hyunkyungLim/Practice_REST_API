package com.example.demo.service;

import com.example.demo.dto.Comment;
import com.example.demo.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommentService {

   @Autowired
   private CommentMapper commentMapper;

   public int comment(Comment comment) {
       return commentMapper.comment(comment);
   }

   public int update(Comment comment) {
       return commentMapper.update(comment);
   }

   public int delete(String commentId) {
       return commentMapper.delete(commentId);
   }

   public List<Comment> select(String cid) {
       return commentMapper.select(cid);
   }
}
