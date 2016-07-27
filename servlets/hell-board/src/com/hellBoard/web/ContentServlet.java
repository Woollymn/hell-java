package com.hellBoard.web;

import com.hellBoard.entity.Content;
import com.hellBoard.service.ContentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class ContentServlet extends HttpServlet {
    ContentService contentService = new ContentService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        this.process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        this.process(req, resp);
    }

    public void process(HttpServletRequest req,
                        HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = "resources/content/";
        String pathInfo = req.getPathInfo();
        pathInfo = pathInfo == null ? "" : pathInfo;

        long contentNo = Long.valueOf(req.getParameter("contentNo"));

        Content content = null;

        switch(pathInfo) {
            case "/modify.do" :
                // 추가&수정화면
                content = contentService.findContentByContentNo(contentNo);
                uri += "modify.jsp";
            break;
            case "/update.do" :
                // 수정처리
            break;
            case "/insert.do" :
                // 생성처리
                break;
            case "/delete.do" :
                // 삭제처리
            break;
            default:
                content = contentService.viewContentByContentNo(contentNo);
                uri += "index.jsp";
            break;
        }

        req.setAttribute("content", content);

        RequestDispatcher view = req.getRequestDispatcher(uri);
        view.forward(req, resp);
    }
}