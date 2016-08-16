package com.hell_board.action;

import main.java.com.hellBoard.util.http.Get;
import main.java.com.hellBoard.util.http.Post;

import java.sql.SQLException;

/**
 * Created by woollymn on 16. 7. 31.
 */
public abstract class Action {
    public abstract String index(Get get) throws SQLException;

    public String create(Get get) { return ""; }
    public String update(Get get) { return ""; }
    public String delete(Get get) { return ""; }

    public String  index(Post post) throws SQLException { return ""; }
    public String create(Post post) { return ""; }
    public String update(Post post) { return ""; }
    public String delete(Post post) { return ""; }
}
