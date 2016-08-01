package main.java.com.hellBoard.entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by woollymn on 16. 8. 1.
 */
public class Post implements HttpMethod {
    private HttpServletRequest req;
    private HttpServletResponse resp;

    private Post() {}

    public Post(HttpServletRequest req,
               HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    @Override
    public HttpServletRequest getReq() {
        return req;
    }

    @Override
    public HttpServletResponse getResp() {
        return resp;
    }
}
