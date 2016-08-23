package com.hell_board.controller;

import com.hell_board.data.request.ContentRequest;
import com.hell_board.domain.Content;
import com.hell_board.domain.Member;
import com.hell_board.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class ContentController {

    @Autowired
    ContentService contentService;

    @RequestMapping(value = "/", method = {GET, POST})
    public String index(@RequestParam(value = "contentNo") long contentNo,
                        Model model) {

        Content content = this.contentService.viewContentByContentNo(contentNo);

        if (!isNull(content)) {
            model.addAttribute("content", content);

            return "content/index";
        } else {
            return "redirect:/list/index";
        }
    }

    @RequestMapping(value = "/create", method = GET)
    public String create() {
        return "content/create";
    }

    @RequestMapping(value = "/create", method = POST)
    public String create(@SessionAttribute(name = "member", required = false) Member member,
                         ContentRequest contentRequest) {

        if (!isNull(member)) {
            String email = contentRequest.getEmail();
            String subject = contentRequest.getSubject();
            String text = contentRequest.getText();
            LocalDateTime registerDateTime = contentRequest.getRegisterDateTime();

            this.contentService.createContent(new Content(email, subject, text, registerDateTime));
        }

        return "redirect:/list/index";
    }

    @RequestMapping(value = "/update", method = GET)
    public String update(@RequestParam(value = "contentNo") long contentNo,
                         Model model) {

        Content content = this.contentService.findContentByContentNo(contentNo);

        if (!isNull(content)) {
            model.addAttribute("content", content);

            return "content/update";
        } else {
            return "redirect:/list/index";
        }
    }

    @RequestMapping(value = "/update", method = POST)
    public String update(ContentRequest contentRequest,
                         Model model) {

        long contentNo = contentRequest.getContentNo();
        String subject = contentRequest.getSubject();
        String text = contentRequest.getText();

        Content content = this.contentService.findContentByContentNo(contentNo);
        content.setSubject(subject);
        content.setText(text);

        this.contentService.update(content);

        return "redirect:/list";
    }

    @RequestMapping(value = "/delete", method = {GET, POST})
    public String delete(@RequestParam(value = "contentNo") long contentNo) {

        int result = this.contentService.delete(contentNo);

        if (result == 0) {
            // 삭제된 게시물이 없다고 표시
        }

        return "redirect:/list/index";
    }
}
