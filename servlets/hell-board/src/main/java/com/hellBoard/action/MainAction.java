package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Get;
import main.java.com.hellBoard.entity.Post;
import main.java.com.hellBoard.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class MainAction extends Action {

    @Override
    public String index(Get get) {
        HttpServletRequest req = get.getReq();

        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            return "index.jsp";
        } else {
            return "list/redirect.jsp";
        }
    }
}
