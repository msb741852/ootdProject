package com.ootd.project.dao;

import com.ootd.project.domain.HomeRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class HomeDaoTest {

    @Autowired
    HomeDao homeDao;

    @Test
    public void recommendOotd() {
        HomeRequest hr = new HomeRequest();
        hr.setMemberIdx(1);
        hr.setPastLowTemp(2);
        hr.setPastHighTemp(8);
        System.out.println(homeDao.recommendOotd(hr));
    }
}