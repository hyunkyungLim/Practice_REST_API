package com.example.demo.mapper;

import com.example.demo.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    int comment(Comment comment);
    int update(Comment comment);
    int delete(String commentId);
    List<Comment> select(String cid);
}
