<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../template/header.jsp" />

<c:set var="content" value="${requestScope.content}" scope="request" />

<div class="container-fluid">
    <div class="row">
        <div class="table-responsive col-xs-10 col-md-10 col-sm-10 col-xs-offset-1 col-md-offset-1 col-sm-offset-1">
            <c:if test="${content.email == sessionScope.user.email}">
                <div class="text-right">
                    <a class="btn btn-info btn-sm" href="/content/update?contentNo=${content.contentNo}" role="button">수정</a>
                    &nbsp;
                    <a class="btn btn-danger btn-sm" href="/content/delete?contentNo=${content.contentNo}" role="button">삭제</a>
                </div>
            </c:if>
            <br />
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                </thead>
                <tbody>
                    <tr>
                        <th class="active">글제목</th>
                        <td colspan="3">${content.subject}</td>
                    </tr>
                    <tr>
                        <th class="active">글번호</th>
                        <td>${content.contentNo}</td>
                        <th class="active">조회수</th>
                        <td>${content.viewCount}</td>
                    </tr>
                    <tr>
                        <th class="active">내용</th>
                        <td colspan="3">${content.text}</td>
                    </tr>
                    <tr>
                        <th class="active">작성자</th>
                        <td colspan="3">${content.email}</td>
                    </tr>
                    <tr>
                        <th class="active">작성시간</th>
                        <td colspan="3">${content.registerDateTime}</td>
                    </tr>
                </tbody>
            </table>
            <div class="text-right">
                <a href="/list">목록으로</a>
            </div>
        </div>
    </div>
</div>

<c:import url="../template/footer.jsp" />