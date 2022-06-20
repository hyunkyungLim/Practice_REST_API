package com.example.demo.mapper;

import com.example.demo.dto.Bookmark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookmarkMapper {

    int bookmark(Bookmark bookmark);
    int delete(Bookmark bookmark);
    List<Bookmark> select(String m_id);
}
