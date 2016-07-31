<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../template/header.jsp" />

<div class="container-fluid">
    <div class="row">
        <div class="table-responsive col-xs-10 col-md-10 col-sm-10 col-xs-offset-1 col-md-offset-1 col-sm-offset-1">
            <div class="text-right">
                <!-- method put으로 변경해야됨 -->
                <a class="btn btn-primary btn-sm" href="/content" role="button">글쓰기</a>
            </div>
            <br />
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                    <tr class="active">
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성시간</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:choose>
                        <c:when test="${empty contents}">
                            <tr>
                                <td colspan="5" class="text-center">
                                    글이 없습니다.
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach var="content" items="${contents}">
                                <tr onclick="javascript:location.href='/content'">
                                    <td>${content.contentNo}</td>
                                    <td>${content.subject}</td>
                                    <td>${content.userId}</td>
                                    <td>${content.registrationDateTime}</td>
                                    <td>${content.viewCount}</td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
    </div>
</div>

<c:import url="../template/footer.jsp" />