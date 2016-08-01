package main.java.com.hellBoard.web;

import main.java.com.hellBoard.action.Action;
import main.java.com.hellBoard.entity.Get;
import main.java.com.hellBoard.entity.HttpMethod;
import main.java.com.hellBoard.entity.Post;

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
import java.util.stream.IntStream;

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
        HttpMethod httpMethod = this.getHttpMethod(req, resp);
        List<String> segments = this.getSegments(requestUri);

        // 호출할 action 클래스명
        String actionClassName = this.getActionName(segments);
        // action 클래스에서 호출할 메소드명
        String actionMethodName = this.getActionMethod(segments);
        // action 객체 가져오기
        Action action = this.getAction(actionClassName);
        // action 객체 내 메소드 실행
        String path = this.getPathFromActionMethod(action, actionMethodName, httpMethod);

        RequestDispatcher view = req.getRequestDispatcher(uri + path);
        view.forward(req, resp);
    }

    private HttpMethod getHttpMethod(HttpServletRequest req,
                                     HttpServletResponse resp) {
        String httpMethod = req.getMethod();

        if ("GET".equals(httpMethod)) {
            return new Get(req, resp);
        } else if ("POST".equals(httpMethod)) {
            return new Post(req, resp);
        }

        // default
        return new Get(req, resp);
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
        return segments
                .stream()
                .findFirst()
                .orElse("main");
    }

    private String getActionMethod(List<String> segments) {
        int lastIndex = segments.size() - 1;

        if(!segments.isEmpty() && lastIndex > 0) {
            return segments.get(lastIndex);
        } else {
            return "index";
        }
    }

    private String capitalize(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    private Action getAction(String actionClassName) {

        Action action = null;

        try {
            if(actionMap.containsKey(actionClassName)) {
                action = actionMap.get(actionClassName);
            } else {
                String actualClassName = this.capitalize(actionClassName) + "Action";
                Class actionClass = Class.forName("main.java.com.hellBoard.action." + actualClassName);
                action = (Action) actionClass.newInstance();

                actionMap.put(actionClassName, action);
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

    private String getPathFromActionMethod(Action action,
                                           String actionMethodName,
                                           HttpMethod httpMethod) {
        String path = null;

        try {
            Method method = action.getClass().getMethod(actionMethodName, httpMethod.getClass());

            if (method.isAccessible()) {
                path = (String) method.invoke(action, httpMethod);
            } else {
                path = "index.jsp";
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return path;
    }
}
