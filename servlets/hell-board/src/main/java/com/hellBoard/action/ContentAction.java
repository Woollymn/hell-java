package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Content;
import main.java.com.hellBoard.service.ContentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class ContentAction extends Action {

    ContentService contentService = new ContentService();

    @Override
    public String read(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = "resources/content/";
        String pathInfo = req.getPathInfo();
        pathInfo = pathInfo == null ? "" : pathInfo;

        long contentNo = Long.valueOf(req.getParameter("contentNo"));

        Content content = null;

        switch(pathInfo) {
            case "/create" :
                // 추가&수정화면
                content = contentService.findContentByContentNo(contentNo);
                uri += "update.jsp";
                break;
            case "/updateo" :
                // 수정처리
                break;
            case "/insert" :
                // 생성처리
                break;
            case "/delete" :
                // 삭제처리
                break;
            default:
                content = contentService.viewContentByContentNo(contentNo);
                uri += "/index.jsp";
                break;
        }

        req.setAttribute("/content", content);

        return "content/method";
    }
}
