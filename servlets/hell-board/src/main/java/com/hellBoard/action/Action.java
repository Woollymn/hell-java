package main.java.com.hellBoard.action;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by woollymn on 16. 7. 31.
 */
public abstract class Action {
    public abstract String read(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public String create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "";
    }

    public String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "";
    }

    public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "";
    }
}
