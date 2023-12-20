package com.ootd.project.dao;

import com.ootd.project.domain.clothes.ClothDel;
import com.ootd.project.domain.clothes.Clothes;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ClothesDaoTest {
    @Autowired
    ClothesDao clothesDao;

    @Test
    public void editClothes() {
        Clothes clothes = new Clothes();
        clothes.setMemberIdx(1);
        clothes.setClothName("소라색 셔츠 112");
        clothes.setClothType("cloth_top");

        System.out.println(clothes);
        Assertions.assertEquals(1, clothesDao.editClothes(clothes));
    }

    @Test
    public void delCloth() {
        ClothDel clothDel = new ClothDel();
        clothDel.setIdx(1);
        clothDel.setClothType("cloth_top");
        clothesDao.deleteClothes(clothDel);
    }

}