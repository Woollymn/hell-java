package com.hell_board.util.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by woollymn on 16. 8. 1.
 */
public interface HttpMethod {
    public HttpServletRequest getReq();
    public HttpServletResponse getResp();
}
