package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment<commentBuilder> {
    private String cm_id;
    private String uid;
    private String m_id;
    private String cm_content;

    @Builder
    public Comment(String cm_id, String uid, String cm_content) {
        this.cm_id = cm_id;
        this.uid = uid;
        this.cm_content = cm_content;
    };

}
