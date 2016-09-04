package com.hell_board.controller;

import com.hell_board.domain.Content;
import com.hell_board.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ListController {
    ContentService contentService;

    @RequestMapping(value = "/", method = GET)
    public String index(Model model) {
        List<Content> contents = contentService.findAll();
        model.addAttribute("contents", contents);

        return "list/index";
    }
}
