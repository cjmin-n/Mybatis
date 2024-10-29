package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

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
}
