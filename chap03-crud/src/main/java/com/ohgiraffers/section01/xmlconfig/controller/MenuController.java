package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.service.MenuService;

import java.util.List;
import java.util.Map;


// 매핑/뷰
public class MenuController {

    // view 대신 사용할 객체
    private final PrintResult printResult;
    // 컨트롤러의 명령을 받을 객체
    private final MenuService menuService;
    // 컨트롤러가 생성될 때 한번에 다 생성해줌. (ex. Spring 의 AutoWired)
    public MenuController(){
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    // 매핑(ex. SpringBoot 의 getMapping())
    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if(menuList != null){
            printResult.printMenuList(menuList);
        }else {
            printResult.printErrorMessage("selectList");
        }
    }

    public void selectMenuByCode(Map<String, String> inputMenuCode) {

        int code = Integer.parseInt(inputMenuCode.get("code"));
        MenuDTO menu = menuService.selectMenuByCode(code);
        if(menu != null){
            printResult.printMenu(menu);
        }else {
            printResult.printErrorMessage("selectOne");
        }
    }
}
