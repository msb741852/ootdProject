package com.ootd.project.service;

import com.ootd.project.dao.HomeDao;
import com.ootd.project.domain.HomeRequest;
import com.ootd.project.domain.past.PastItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    HomeDao homeDao;

    public List<PastItem> memberCommendItemList(HomeRequest homeRequest) {
        return homeDao.recommendOotd(homeRequest);
    }

}
