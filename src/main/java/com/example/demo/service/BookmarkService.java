package com.example.demo.service;

import com.example.demo.dto.Bookmark;
import com.example.demo.mapper.BookmarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkMapper bookmarkMapper;

    public int bookmark(Bookmark bookmark) {
        return bookmarkMapper.bookmark(bookmark);
    }

    public int delete(Bookmark bookmark) {
        return bookmarkMapper.delete(bookmark);
    }

    public List<Bookmark> select(String m_id) {
        return bookmarkMapper.select(m_id);
    }
}
