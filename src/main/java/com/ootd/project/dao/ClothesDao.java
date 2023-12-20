package com.ootd.project.dao;

import com.ootd.project.domain.clothes.ClothDel;
import com.ootd.project.domain.clothes.Clothes;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClothesDao {

    @Autowired
    SqlSession session;

    String namespace="com.ootd.project.dao.clothesMapper.";

    public int clothesAdd(Clothes clothes) {
        return session.insert(namespace + "clothesAdd", clothes);
    }

    public int validClothes(Clothes clothes) {
        return session.selectOne(namespace + "validClothes", clothes);
    }

    public List<Clothes> showClothesList(Clothes clothes) {
        return session.selectList(namespace + "showClothesList", clothes);
    }

    public int editClothes(Clothes clothes) {
        return session.update(namespace + "editClothes", clothes);
    }

    public int deleteClothes(ClothDel clothDel) {
        return session.delete(namespace + "deleteClothes", clothDel);
    }

}
