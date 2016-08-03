package main.java.com.hellBoard.action;

import main.java.com.hellBoard.util.http.Get;
import main.java.com.hellBoard.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class MainAction extends Action {

    @Override
    public String index(Get get) throws SQLException {
        HttpServletRequest req = get.getReq();

        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            return "index.jsp";
        } else {
            return "list/redirect.jsp";
        }
    }
}
