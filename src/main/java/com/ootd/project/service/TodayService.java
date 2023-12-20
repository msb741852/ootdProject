package com.ootd.project.service;

import com.ootd.project.dao.ClothesDao;
import com.ootd.project.domain.clothes.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TodayService {

    @Autowired
    ClothesDao clothesDao;

    // 리스트 가져오기
    public Map<String, List<Clothes>> clothesListView(Integer memberIdx) {
        Map<String, List<Clothes>> map = new HashMap<>();
        Clothes clothes = new Clothes();
        clothes.setMemberIdx(memberIdx);
        clothes.setClothType("cloth_top");
        map.put("cloth_top", clothesDao.showClothesList(clothes));
        clothes.setClothType("cloth_bottom");
        map.put("cloth_bottom", clothesDao.showClothesList(clothes));
        clothes.setClothType("cloth_outer");
        map.put("cloth_outer", clothesDao.showClothesList(clothes));
        return map;
    }
}
