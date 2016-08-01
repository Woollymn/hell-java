package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Content;
import main.java.com.hellBoard.entity.Get;
import main.java.com.hellBoard.entity.Post;
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
    public String index(Get get) {
        return this.indexProcess(get.getReq());
    }

    @Override
    public String index(Post post) {
        return this.indexProcess(post.getReq());
    }

    private String indexProcess(HttpServletRequest req) {
        String contentNo = req.getParameter("contentNo");
        Content content = null;

        if (contentNo != null) {
            content = contentService.viewContentByContentNo(Long.parseLong(contentNo));
        }

        if (content != null) {
            req.setAttribute("content", content);

            return "content/index.jsp";
        } else {
            return "list/redirect.jsp";
        }
    }

    @Override
    public String create(Get get) {
        return "content/create.jsp";
    }

    @Override
    public String create(Post post) {
        HttpServletRequest req = post.getReq();

        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getUserId();
        String subject = req.getParameter("subject");
        String text = req.getParameter("text");
        LocalDateTime registrationDateTime = LocalDateTime.now();

        contentService.createContent(new Content(userId, subject, text, registrationDateTime));

        return "list/redirect.jsp";
    }

    @Override
    public String update(Get get) {
        HttpServletRequest req = get.getReq();

        String contentNo = req.getParameter("contentNo");
        Content content = null;

        // 본인 확인도 필요!
        if (contentNo != null) {
            content = contentService.findContentByContentNo(Long.parseLong(contentNo));
        }

        if (content != null) {
            req.setAttribute("content", content);

            return "content/update.jsp";
        } else {
            return "list/redirect.jsp";
        }
    }

    @Override
    public String update(Post post) {
        HttpServletRequest req = post.getReq();

        String contentNo = req.getParameter("contentNo");
        String subject = req.getParameter("subject");
        String text = req.getParameter("text");

        // 본인 확인도 필요!
        if (contentNo != null) {
            Content content = contentService.findContentByContentNo(Long.parseLong(contentNo));
            content.setSubject(subject);
            content.setText(text);

            contentService.updateContent(content);
        }

        return "list/redirect.jsp";
    }

    @Override
    public String delete(Get get) {
        return this.deleteProcess(get.getReq());
    }

    @Override
    public String delete(Post post) {
        return this.deleteProcess(post.getReq());
    }

    private String deleteProcess(HttpServletRequest req) {
        String contentNo = req.getParameter("contentNo");
        boolean isDeleted = false;

        if (contentNo != null) {
            isDeleted = contentService.deleteContentByContentNo(Long.parseLong(contentNo));
        }

        if (!isDeleted) {
            // 에러처리 메시지
        }

        return "list/redirect.jsp";
    }
}