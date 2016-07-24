package com.hellBoard.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by woollymn on 16. 7. 24.
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("resources/list/index.jsp");
        view.forward(req, resp);
    }
}
