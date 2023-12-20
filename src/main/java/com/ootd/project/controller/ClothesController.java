package com.ootd.project.controller;

import com.ootd.project.domain.clothes.ClothDel;
import com.ootd.project.domain.clothes.Clothes;
import com.ootd.project.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ClothesController {

    @Autowired
    ClothesService clothesService;

    @GetMapping(value = "/clothes")
    public String clothesView(HttpSession session) {
        if(session.getAttribute("omotemdberiddx") != null) {
            return "clothes";
        }
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping(value = "/clothes/add", produces = "application/text; charset=utf8")
    public String clothesTopAdd(Clothes clothes, HttpSession session) {
        clothes.setMemberIdx(Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
        return clothesService.memberClothesAdd(clothes);
    }

    @ResponseBody
    @PostMapping("/clothes/read/list")
    public ResponseEntity<List<Clothes>> clothesListShow(Clothes clothes, HttpSession session) {
        clothes.setMemberIdx(Integer.parseInt(session.getAttribute("omotemdberiddx").toString()));
        return new ResponseEntity<List<Clothes>>(clothesService.memberClothesList(clothes), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/clothes/edit", produces = "application/text; charset=utf8")
    public String clothEdit(Clothes clothes) {
        return clothesService.memberClothesEdit(clothes);
    }

    @ResponseBody
    @PostMapping(value="/clothes/del", produces = "application/text; charset=utf8")
    public String clothDelete(ClothDel clothDel) {
        return clothesService.memberClothesDelete(clothDel);
    }
}
