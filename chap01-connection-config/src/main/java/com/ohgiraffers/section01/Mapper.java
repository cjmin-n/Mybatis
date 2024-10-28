package com.ohgiraffers.section01;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {

    @Select("SELECT CURDATE() FROM DUAL") // 현재 날짜 출력해줄 쿼리문(MySQL)
    Date selectSysDate();
}
