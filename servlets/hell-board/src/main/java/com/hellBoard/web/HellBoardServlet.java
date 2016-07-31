package main.java.com.hellBoard.web;

import main.java.com.hellBoard.action.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by woollymn on 16. 7. 31.
 */
public class HellBoardServlet extends HttpServlet {
    private static Map<String, Action> actionMap = new HashMap<>();

    @Override
    public void service(HttpServletRequest req,
                        HttpServletResponse resp)
            throws ServletException, IOException {

        final String uri = req.getContextPath() + "/WEB-INF/resources/";
        String requestUri = req.getRequestURI();
        List<String> segments = this.getSegments(requestUri);

        // action 클래스 호출에 사용
        String actionName = this.getActionName(segments);
        // 호출한 action 클래스 내의 메소드 호출에 사용
        String actionMethod = this.getActionMethod(segments);

        Action action = this.getAction(actionName);
        String path = null;

        try {
            Method method = action.getClass().getMethod(actionMethod, HttpServletRequest.class, HttpServletResponse.class);
            path = (String) method.invoke(action, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        RequestDispatcher view = req.getRequestDispatcher(uri + path);
        view.forward(req, resp);
    }

    private List<String> getSegments(String requestUri) {
        StringTokenizer segmentTokens = new StringTokenizer(requestUri, "/");
        List<String> segments = new ArrayList();

        while (segmentTokens.hasMoreTokens()) {
            segments.add(segmentTokens.nextToken());
        }

        return segments;
    }

    private String getActionName(List<String> segments) {
        if(segments.size() > 0) {
            return segments.get(0);
        } else {
            return "main";
        }
    }

    private String getActionMethod(List<String> segments) {
        if(segments.size() > 1) {
            return segments.get(1);
        } else {
            return "read";
        }
    }

    private String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private Action getAction(String actionName) {

        Action action = null;

        try {
            if(actionMap.containsKey(actionName)) {
                action = actionMap.get(actionName);
            } else {
                String className = this.capitalize(actionName) + "Action";
                Class actionClass = Class.forName("main.java.com.hellBoard.action." + className);
                action = (Action) actionClass.newInstance();

                actionMap.put(actionName, action);
            }

        } catch (Exception e) {
            // 에러 핸들링 클래스를 만들자..
            if (e instanceof ClassNotFoundException) {
                // 처리 필요
            } else if (e instanceof InstantiationException) {
                // 처리 필요
            } else if (e instanceof IllegalAccessException) {
                // 처리 필요
            }

            e.printStackTrace();
        }

        return action;
    }
}
