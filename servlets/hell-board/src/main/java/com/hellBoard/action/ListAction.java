package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Content;
import main.java.com.hellBoard.service.ContentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class ListAction extends Action {

    ContentService contentService = new ContentService();

    @Override
    public String read(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        List<Content> contents = contentService.findAll();

        req.setAttribute("contents", contents);

        return "list/index.jsp";
    }
}
