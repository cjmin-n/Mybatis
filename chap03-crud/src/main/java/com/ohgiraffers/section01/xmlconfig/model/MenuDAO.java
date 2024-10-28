package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MenuDAO {

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }
}
