package com.hellBoard.web;

import com.hellBoard.entity.User;
import com.hellBoard.service.UserService;

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
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("resources/login/index.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String signInId = req.getParameter("signInId");
        String signInPassword = req.getParameter("signInPassword");
        Map<String, String> messages = new HashMap();

        if (signInId == null || signInId.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if (signInPassword == null || signInPassword.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {
            User user = userService.find(signInId, signInPassword);

            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect(req.getContextPath() + "/board");
                return;
            } else {
                messages.put("login", "Unknown login, please try agina");
            }
        }

        req.setAttribute("messages", messages);
        RequestDispatcher view = req.getRequestDispatcher("resources/login/index.jsp");
        view.forward(req, resp);
    }
}
