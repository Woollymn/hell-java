package com.hellBoard;

import com.hellBoard.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hkkang on 2016. 7. 21..
 */
public class HellBoardServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp)
            throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        // Map<String, String> messages = new HashMap();

        if (user == null) {
            RequestDispatcher view = req.getRequestDispatcher("resources/index.jsp");
            view.forward(req,resp);
        } else {
            String mainURI = req.getContextPath() + "/list";
            resp.sendRedirect(mainURI);
        }
    }
}