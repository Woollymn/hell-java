package com.hell_board.controller;

import com.hell_board.data.request.SignInRequest;
import com.hell_board.data.request.SignUpRequest;
import com.hell_board.domain.Member;
import com.hell_board.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

import static java.util.Objects.isNull;
import static java.util.logging.Level.WARNING;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class SignController {

    @Autowired
    Logger logger;

    @Autowired
    private SignService signService;

    @RequestMapping(value = {"/signup", "/signin"}, method = GET)
    public String redirect() {
        return "redirect:/";
    }

    @RequestMapping(value = "/signup", method = POST)
    public String signup(SignUpRequest signUpRequest,
                         Model model) {

        int resultCount = 0;

        try {
            // validator를 통해서 검증하자
            resultCount = this.signService.signUp(signUpRequest);
        } catch (Exception e) {
            // logger
            logger.log(WARNING, e.getMessage());
        }

        if (resultCount == 0) {
            return "redirect:/";
        } else {
            return "signup/index";
        }
    }

    @RequestMapping(value = "/signin", method = POST)
    public String signin(SignInRequest signInRequest,
                         Model model) {

        Member member = null;

        try {
            // validator 사용
            member = this.signService.signIn(signInRequest);
        } catch (Exception e) {
            // logger
            logger.log(WARNING, e.getMessage());
        }

        if (!isNull(member)) {
            return "list/index";
        } else {
            return "redirect:/";
        }

    }

    public String signout(@SessionAttribute(name = "member") Member member,
                          Model model,
                          HttpSession httpSession) {

        if (!isNull(member)) {
            // 세션 처리는 어떻게 하지?
            httpSession.invalidate();
        }

        return "redirect:/";

    }
}
