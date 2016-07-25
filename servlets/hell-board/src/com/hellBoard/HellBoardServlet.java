package com.hellBoard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hkkang on 2016. 7. 21..
 */
public class HellBoardServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp)
            throws ServletException, IOException {

        /*
         1. 로그인 상태 체크
         1-1. 로그인했으면 게시판
         1-2. 아니면 기본 메인
         */
        RequestDispatcher view = req.getRequestDispatcher("resources/index.jsp");
        view.forward(req,resp);
    }
}