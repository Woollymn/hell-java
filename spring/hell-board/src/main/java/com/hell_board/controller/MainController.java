package com.hell_board.controller;

import com.hell_board.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import static java.util.Objects.isNull;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = GET)
    public String index(@SessionAttribute(name = "member", required = false) Member member) {

        if (isNull(member)) {
            return "index";
        } else {
            return "redirect:/list/index";
        }
    }
}
