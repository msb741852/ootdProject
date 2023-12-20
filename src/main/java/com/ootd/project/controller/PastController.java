package com.ootd.project.controller;

import com.ootd.project.domain.clothes.Clothes;
import com.ootd.project.domain.past.PastUpdateItem;
import com.ootd.project.domain.past.PastItem;
import com.ootd.project.service.PastService;
import com.ootd.project.service.TodayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class PastController {
    @Autowired
    PastService pastService;
    @Autowired
    TodayService todayService;

    @GetMapping("/past")
    public String pastView(HttpSession session) {
        if(session.getAttribute("omotemdberiddx") != null) {
//            Map<String, List<Clothes>> map = todayService.clothesListView(Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
//            model.addAttribute("cloth_top", map.get("cloth_top"));
//            model.addAttribute("cloth_bottom", map.get("cloth_bottom"));
//            model.addAttribute("cloth_outer", map.get("cloth_outer"));
            return "past";
        }
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/past/read/list")
    public List<PastItem> pastListShow(@RequestBody Map<String, Integer> map, HttpSession session) {
        map.put("memberIdx", Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
        return pastService.memberPastListShow(map);
    }

    @ResponseBody
    @PostMapping(value = "/past/delete/item", produces = "application/text; charset=utf8")
    public String memberPastItemDelete(int pastIdx) {
        return pastService.memberPastItemDelete(pastIdx);
    }

    @ResponseBody
    @PostMapping("/past/read/clothes")
    public Map<String, List<Clothes>> memberClothesListRead(HttpSession session) {
        Map<String, List<Clothes>> map = todayService.clothesListView(Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
        return map;
    }

    @ResponseBody
    @PostMapping(value = "/past/update", produces = "application/text; charset=utf8")
    public String memberPastFeedbackEdit(PastUpdateItem pastUpdateItem) {
        return pastService.memberPastEdit(pastUpdateItem);
    }



}
