package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {
            System.out.println("===== 메뉴 관리 =====");
            System.out.println("1. 메뉴 전체 조회");
            System.out.println("2. 메뉴 코드로 메뉴 조회");
            System.out.println("3. 신규 메뉴 추가");
            System.out.println("4. 메뉴 수정");
            System.out.println("5. 메뉴 삭제");
            System.out.println("번호를 입력하세요 : ");
            int no = scr.nextInt();

            switch (no) {
                case 1 : menuController.selectAllMenu(); break;
                case 2 : menuController.selectMenuByCode(inputMenuCode()); break;
                case 3 : break;
                case 4 : break;
                case 5 : break;
                default:
                    System.out.println("잘못된 메뉴 선택"); break;
            }
        } while(true);
    }

    // html 에서 넘겨줬다고 가정해서 String 으로 만듦
    private static Map<String, String> inputMenuCode(){
        Scanner scr = new Scanner(System.in);
        System.out.println("메뉴 코드를 입력 해주세요 : ");
        String code = scr.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        return parameter;
    }
}