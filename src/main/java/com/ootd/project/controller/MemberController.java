package com.ootd.project.controller;

import com.ootd.project.dao.MemberDao;
import com.ootd.project.domain.member.CookieInfo;
import com.ootd.project.domain.member.LoginInfo;
import com.ootd.project.domain.member.Member;
import com.ootd.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String loginView() {
        return "login";
    }

    @GetMapping("/register/view")
    public String registerView() {
        return "register";
    }

    @PostMapping("/register/add")
    public String registerAdd(Member member, Model model) {
        if(memberService.registerMember(member).equals("회원가입 완료")) {
            return "login";
        } else {
            model.addAttribute("fail_msg", "이미 존재하는 아이디입니다.");
            model.addAttribute("nickname", member.getMemberNickname());
            return "register";
        }
    }

    @PostMapping("/login")
    public String loginMember(LoginInfo loginInfo, HttpSession session, Model model) {
        CookieInfo cookieInfo = memberService.loginMember(loginInfo);
        if(cookieInfo != null && cookieInfo.getMemberIdx() != null) {
            // 로그인 성공
            session.setAttribute("omotemdberiddx", cookieInfo.getMemberIdx());
            session.setAttribute("omemonicktnadme", cookieInfo.getMemberNickname());
            return "loading";
        }
        model.addAttribute("msg_fail", "회원정보가 일치하지 않습니다.");
        return "login";
    }

    @GetMapping("/logout")
    public String logoutMember(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}

