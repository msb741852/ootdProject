package com.ootd.project.controller;

import com.ootd.project.domain.HomeRequest;
import com.ootd.project.domain.past.PastItem;
import com.ootd.project.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    @GetMapping("/home")
    public String homeView(HttpSession session) {
        if(session.getAttribute("omotemdberiddx") != null) {
            return "home";
        }
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/home/read/recommend")
    public List<PastItem> commendListView(@CookieValue int pmeTwoLevas,  @CookieValue int pmeThgiHevas,
                                          HttpSession session) {
        HomeRequest homeRequest = new HomeRequest();
        homeRequest.setMemberIdx(Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
        homeRequest.setPastLowTemp(pmeTwoLevas);
        homeRequest.setPastHighTemp(pmeThgiHevas);
        return homeService.memberCommendItemList(homeRequest);
    }
}
