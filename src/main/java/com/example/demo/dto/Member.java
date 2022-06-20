package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String nickname;
    private String email;
    private String cod_id;
    private String password;
    private String gender;

}
