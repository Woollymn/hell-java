package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Content;
import main.java.com.hellBoard.entity.User;
import main.java.com.hellBoard.service.ContentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class ContentAction extends Action {

    ContentService contentService = new ContentService();

    @Override
    public String read(HttpServletRequest req,
                       HttpServletResponse resp)
            throws ServletException, IOException {

        long contentNo = Long.valueOf(req.getParameter("contentNo"));

        Content content = null;

        return "content/method";
    }

    @Override
    public String create(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        String httpMethod = req.getMethod();
        String path = null;

        switch (httpMethod) {
            case "GET" :
                // 게시물 추가 화면
                path = "content/create.jsp";
                break;
            case "POST" :
                // 게시물 등록
                User user = (User) req.getSession().getAttribute("user");
                String userId = user.getUserId();
                String subject = req.getParameter("subject");
                String text = req.getParameter("text");
                LocalDateTime registrationDateTime = LocalDateTime.now();

                contentService.createContent(new Content(userId, subject, text, registrationDateTime));

                path = "list/redirect.jsp";
                break;
            default :
                break;
        }

        return path;
    }

    @Override
    public String update(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        return super.update(req, resp);
    }

    @Override
    public String delete(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        return super.delete(req, resp);
    }
}