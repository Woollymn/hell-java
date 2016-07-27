package com.hellBoard.web;

import com.hellBoard.entity.User;
import com.hellBoard.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by woollymn on 16. 7. 25.
 */
public class LoginServlet extends HttpServlet {
    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String signInId = req.getParameter("signInId");
        String signInPassword = req.getParameter("signInPassword");
        Map<String, String> messages = new HashMap();

        if (signInId == null || signInId.isEmpty()) {
            messages.put("userId", "아이디를 입력하세요.");
        }

        if (signInPassword == null || signInPassword.isEmpty()) {
            messages.put("password", "암호를 입력하세요.");
        }

        if (messages.isEmpty()) {
           User user = loginService.findByPassword(signInId, signInPassword);

            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/list");
                return;
            } else {
                messages.put("login", "요청하신 아이디로 로그인할 수 없습니다.");
            }
        }

        req.setAttribute("messages", messages);
        RequestDispatcher view = req.getRequestDispatcher("resources/login/index.jsp");
        view.forward(req, resp);
    }
}
