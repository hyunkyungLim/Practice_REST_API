package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionCodeMapper {

    /*거주지 코드(cod_id) 찾기 3단계*/
    List<String> sido();
    List<String> sigungu(String sido);
    List<String> umd(String sigungu);

}
