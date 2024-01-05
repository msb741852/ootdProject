package com.ootd.project.dao;

import com.ootd.project.domain.past.Past;
import com.ootd.project.domain.past.PastUpdateItem;
import com.ootd.project.domain.past.PastItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PastDao {
    @Autowired
    SqlSession session;

    String namespace = "com.ootd.project.dao.pastMapper.";

    public int pastAdd(Past past) {
        return session.insert(namespace + "pastAdd", past);
    }
    public List<PastItem> showPastList(Map<String, Integer> map) {
        System.out.println(map.get("pastDate"));
        return session.selectList(namespace + "showPastList", map);
    }
    public int deletePastItem(int pastIdx) {
        return session.delete(namespace + "deletePastItem", pastIdx);
    }
    public int updatePast(PastUpdateItem pastUpdateItem) {
        return session.update(namespace + "updatePast", pastUpdateItem);
    }
}
