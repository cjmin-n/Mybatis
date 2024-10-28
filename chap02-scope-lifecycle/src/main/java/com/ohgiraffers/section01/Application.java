package com.ohgiraffers.section01;

import static com.ohgiraffers.section01.Template.getSqlSession;

public class Application {

    public static void main(String[] args) {

        // 싱글톤 확인
        System.out.println("session 1번 : " + getSqlSession().hashCode());
        System.out.println("session 2번 : " + getSqlSession().hashCode());
        /*sqlSessionFactory 의 hashCode : 1864350231
        session 1번 : 727001376
        sqlSessionFactory 의 hashCode : 1864350231
        session 2번 : 660143728*/


    }
}
