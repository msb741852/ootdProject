package com.ootd.project.dao;

import com.ootd.project.domain.HomeRequest;
import com.ootd.project.domain.past.PastItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HomeDao {
    @Autowired
    SqlSession session;

    String namespace="com.ootd.project.dao.homeMapper.";

    public List<PastItem> recommendOotd(HomeRequest homeRequest) {
        return session.selectList(namespace + "recommendOotd", homeRequest);
    }
}
