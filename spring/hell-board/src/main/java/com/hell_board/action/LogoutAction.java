package com.hell_board.action;

import main.java.com.hellBoard.entity.User;
import main.java.com.hellBoard.util.http.Get;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class LogoutAction extends Action {

    @Override
    public String index(Get get) {
        HttpServletRequest req = get.getReq();

        User user = (User) req.getSession().getAttribute("user");

        if (user != null) {
            req.getSession().invalidate();
        }

        return "redirect.jsp";
    }
}