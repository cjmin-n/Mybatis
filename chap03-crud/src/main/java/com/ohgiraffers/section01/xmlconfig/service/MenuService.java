package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.MenuDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {


    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }


    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();
        List<MenuDTO> menuList = menuDAO.selectAllMenu(sqlSession);
        sqlSession.close();
        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {

        SqlSession sqlSession = getSqlSession();
        MenuDTO menu = menuDAO.selectMenuByCode(sqlSession, code);

        sqlSession.close();
        return menu;
    }
}
