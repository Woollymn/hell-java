package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Get;
import main.java.com.hellBoard.entity.Post;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by woollymn on 16. 7. 31.
 */
public abstract class Action {
    public abstract String index(Get get);

    public String create(Get get) { return ""; }
    public String update(Get get) { return ""; }
    public String delete(Get get) { return ""; }

    public String  index(Post post) { return ""; }
    public String create(Post post) { return ""; }
    public String update(Post post) { return ""; }
    public String delete(Post post) { return ""; }
}
