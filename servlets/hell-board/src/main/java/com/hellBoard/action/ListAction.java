package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Content;
import main.java.com.hellBoard.util.http.Get;
import main.java.com.hellBoard.service.ContentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class ListAction extends Action {

    ContentService contentService = new ContentService();

    @Override
    public String index(Get get) {
        HttpServletRequest req = get.getReq();
        List<Content> contents = contentService.findAll();

        req.setAttribute("contents", contents);

        return "list/index.jsp";
    }
}
