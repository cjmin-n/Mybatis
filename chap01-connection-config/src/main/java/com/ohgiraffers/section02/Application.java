package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Application {


    public static void main(String[] args) {

        // mybatis 는 기본적으로 resources 폴더를 기준으로 xml 파일을 찾을 수 있다.
        String resource = "mybatis-config.xml";

        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource); // InputStream : 정보를 읽기위한 객체
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false);

            Date date = session.selectOne("mapper.selectSysDate"); // selectOne 결과값이 한줄일 때 사용하는 메소드 / 여러줄일때는 selectList 로 받아야함
            System.out.println(date); // Mon Oct 28 00:00:00 KST 2024

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }
}
