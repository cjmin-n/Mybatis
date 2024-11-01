package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSession;

public class MenuService {

    private DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        // 마이바티스에서 기본 자료형만 넘기면 비교가 안되기 때문에 Map 이나 getter 가 있는 DTO 에 담아야 한다.
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = mapper.selectMenuByPrice(map);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }


    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void selectMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }


    public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> codeList = new HashMap<>();
        codeList.put("randomMenuCodeList", randomMenuCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(codeList);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList) {
                System.out.println(menu);
            }
        }else {
            System.out.println("검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {

        SqlSession sqlSession = getSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        String categoryCode = (String) criteria.get("categoryCode");
        if(categoryCode.isEmpty() || categoryCode == null){
            categoryCode = "0";
        }
        int categoryCodeInteger = Integer.parseInt(categoryCode);

        criteria.put("categoryCode", categoryCodeInteger);

        int result = mapper.modifyMenu(criteria);

        if(result > 0) {
            System.out.println("수정에 성공했습니다.");
            sqlSession.commit();
        }else {
            System.out.println("수정에 실패했습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
