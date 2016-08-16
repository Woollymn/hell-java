package com.hell_board.action;

import main.java.com.hellBoard.entity.User;
import main.java.com.hellBoard.service.JoinService;
import main.java.com.hellBoard.util.http.Get;
import main.java.com.hellBoard.util.http.Post;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class JoinAction extends Action {

    private JoinService joinService = new JoinService();

    @Override
    public String index(Get get) {
        return "redirect.jsp";
    }

    @Override
    public String index(Post post) throws SQLException {
        HttpServletRequest req = post.getReq();
        String signUpId = req.getParameter("signUpId");
        String signUpPassword = req.getParameter("signUpPassword");
        String signUpPasswordConfirmation = req.getParameter("signUpPasswordConfirmation");
        String signUpName = req.getParameter("signUpName");

        Map<String, String> messages = new HashMap();

        // id, password, passwordconfirmation, name
        if (signUpId == null || signUpId.isEmpty()) {
            messages.put("username", "이름을 입력하세요.");
        }

        if(signUpPassword == null || !signUpPassword.equals(signUpPasswordConfirmation)) {
            // 잘못된 에러 처리
            messages.put("signUpPassword", "비밀번호가 다릅니다.");
        }

        if (messages.isEmpty()) {
            // 이미 가입했는지 확인 필요
            User signUpUser = joinService.addUser(signUpId, signUpPassword, signUpName);

            // 세션 저장할 것
            req.getSession().setAttribute("user", signUpUser);
        }

        req.setAttribute("messages", messages);

        return "join/index.jsp";
    }
}
