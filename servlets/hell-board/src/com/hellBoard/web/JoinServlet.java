package com.hellBoard.web;

import com.hellBoard.entity.User;
import com.hellBoard.model.UserDao;
import com.hellBoard.service.JoinService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hkkang on 2016. 7. 22..
 */
public class JoinServlet extends HttpServlet {
    JoinService joinService = new JoinService();

    @Override
    protected void doPost(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        String signUpId = req.getParameter("signUpId");
        String signUpPassword = req.getParameter("signUpPassword");
        String signUpPasswordConfirmation = req.getParameter("signUpPasswordConfirmation");
        String signUpName = req.getParameter("signUpName");

        Map<String, String> messages = new HashMap();

        // id, password, passwordconfirmation, name
        if (signUpId == null || signUpId.isEmpty()) {
            messages.put("username", "Please enter username");
        }

        if(!signUpPassword.equals(signUpPasswordConfirmation)) {
            // 잘못된 에러 처리
            messages.put("signUpPassword", "비밀번호가 다릅니다.");
        }

        if (messages.isEmpty()) {
            User signUpUser = joinService.addUser(signUpId, signUpPassword, signUpName);

            // 세션 저장할 것
            req.getSession().setAttribute("user", signUpUser);
        }

        req.setAttribute("messages", messages);
        RequestDispatcher view = req.getRequestDispatcher("resources/join/index.jsp");
        view.forward(req, resp);
    }
}
