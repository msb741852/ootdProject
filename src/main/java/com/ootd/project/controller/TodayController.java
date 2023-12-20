package com.ootd.project.controller;

import com.ootd.project.domain.clothes.Clothes;
import com.ootd.project.domain.past.Past;
import com.ootd.project.service.PastService;
import com.ootd.project.service.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class TodayController {

    @Autowired
    TodayService todayService;
    @Autowired
    PastService pastService;

    @GetMapping("/today")
    public String todayView(Model model, HttpSession session) {
        if(session.getAttribute("omotemdberiddx") != null) {
            Map<String, List<Clothes>> map = todayService.clothesListView(Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
            model.addAttribute("cloth_top", map.get("cloth_top"));
            model.addAttribute("cloth_bottom", map.get("cloth_bottom"));
            model.addAttribute("cloth_outer", map.get("cloth_outer"));
            return "today";
        }
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping(value = "/today/add", produces = "application/text; charset=utf8")
    public String todayAdd(@RequestBody Past past, HttpSession session) {
        past.setMemberIdx(Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
        return pastService.memberPastAdd(past);
    }
}
