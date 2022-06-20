package com.example.demo.controller;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ControllerAdvice
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberSerivce memberSerivce;

    @GetMapping(value="/sign-up/check-email")
    @ResponseBody
    public ResponseEntity<?> checkEmail(@RequestParam("email") String email) {

        int cnt = memberSerivce.checkEmail(email);
        boolean checkResult =  (cnt == 1) ? false : true;

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", 200);
        response.put("message", "성공");
        response.put("data", checkResult);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value="/sign-up/check-nickname")
    @ResponseBody
    public ResponseEntity<?> checkNickname(@RequestParam("nickname") String nickname) {

        int cnt = memberSerivce.checkNickname(nickname);
        boolean checkResult =  (cnt == 1) ? false : true;

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", 200);
        response.put("message", "성공");
        response.put("data", checkResult);

        return ResponseEntity.ok(response);
    }

    @PostMapping(value= "/sign-up")
    @ResponseBody
    public ResponseEntity<?> signUp(@RequestParam("email") String email,
                                    @RequestParam("nickname") String nickname,
                                    @RequestParam("password") String password,
                                    @RequestParam("gender") String gender,
                                    @RequestParam("regionCode") String regionCode
                                    ) {

        int cnt = memberSerivce.signUp(new Member(nickname, email, regionCode, password, gender));
        boolean insertResult = (cnt == 1);

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", 200);
        response.put("message", "성공");
        response.put("data", insertResult);

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exeption(Exception e) {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
        response.put("message", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

        return ResponseEntity.ok(response);
    }
}
