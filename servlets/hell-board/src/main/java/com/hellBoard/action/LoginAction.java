package main.java.com.hellBoard.action;

import main.java.com.hellBoard.entity.Get;
import main.java.com.hellBoard.entity.User;
import main.java.com.hellBoard.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class LoginAction extends Action {

    private LoginService loginService = new LoginService();

    @Override
    public String index(Get get) {
        HttpServletRequest req = get.getReq();
        String signInId = req.getParameter("signInId");
        String signInPassword = req.getParameter("signInPassword");
        Map<String, String> messages = new HashMap();

        if (signInId == null || signInId.isEmpty()) {
            messages.put("userId", "아이디를 입력하세요.");
        }

        if (signInPassword == null || signInPassword.isEmpty()) {
            messages.put("password", "암호를 입력하세요.");
        }

        if (messages.isEmpty()) {
            User user = loginService.findByPassword(signInId, signInPassword);

            if (user != null) {
                req.getSession().setAttribute("user", user);

                return "list/redirect.jsp";
            } else {
                messages.put("login", "요청하신 아이디로 로그인 할 수 없습니다.");
            }
        }

        req.setAttribute("messages", messages);

        return "login/index.jsp";
    }
}
