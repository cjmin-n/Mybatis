package com.ohgiraffers.common;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;

// 결과값을 출력해줄 클래스 - html 대체
public class PrintResult {


    public void printMenuList(List<MenuDTO> menuList) {

        for (MenuDTO menu : menuList) {
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String code) {
        String message = null;
        switch(code){
            case "selectList" : message = "메뉴 전체 조회 실패"; break;
            case "selectOne" : message = "메뉴 조회 실패"; break;

            default: message = "잘못된 처리"; break;
        }
        System.out.println(message);
    }

    public void printMenu(MenuDTO menu) {
        System.out.println(menu);
    }
}
