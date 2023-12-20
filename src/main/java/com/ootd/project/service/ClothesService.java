package com.ootd.project.service;

import com.ootd.project.dao.ClothesDao;
import com.ootd.project.domain.clothes.ClothDel;
import com.ootd.project.domain.clothes.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService {
    @Autowired
    ClothesDao clothesDao;

    public String memberClothesAdd(Clothes clothes) {
        if(clothesDao.validClothes(clothes) == 0) {
            clothesDao.clothesAdd(clothes);
            return "등록 성공!";
        } else {
            return "이미 존재하는 별칭입니다.";
        }
    }
    public List<Clothes> memberClothesList(Clothes clothes) {
        return clothesDao.showClothesList(clothes);
    }
    public String memberClothesEdit(Clothes clothes) {
        if(clothesDao.editClothes(clothes) == 1) {
            return "수정하였습니다.";
        }
        return "수정하지 못했습니다.";
    }
    public String memberClothesDelete(ClothDel clothDel) {
        if(clothesDao.deleteClothes(clothDel) == 1) {
            return "삭제하였습니다.";
        }
        return "삭제하지 못했습니다.";
    }
}
