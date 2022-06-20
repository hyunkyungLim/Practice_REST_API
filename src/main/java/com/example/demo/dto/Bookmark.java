package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bookmark {
    private int bid;
    private String uid;
    private int m_id;

    @Builder
    public Bookmark(String uid, int m_id) {
        this.uid = uid;
        this.m_id = m_id;
    }
}
