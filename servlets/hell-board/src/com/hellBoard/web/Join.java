package com.hellBoard.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hkkang on 2016. 7. 22..
 */
public class Join extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("resources/join/index.jsp");
        view.forward(req, resp);
    }
}
