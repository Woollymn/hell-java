package main.java.com.hellBoard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class CommonAction extends Action {
    @Override
    public String read(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        return "common/index.jsp";
    }
}
