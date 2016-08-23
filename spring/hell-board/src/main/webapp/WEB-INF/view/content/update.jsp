<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../template/header.jsp" />

<c:set var="content" value="${requestScope.content}" />

<div class="container-fluid">
    <div class="row">
        <div class="table-responsive col-xs-10 col-md-10 col-sm-10 col-xs-offset-1 col-md-offset-1 col-sm-offset-1">
            <form method="POST" action="content/update?contentNo=${content.contentNo}">
                <table class="table table-bordered table-hover table-condensed">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th class="active">글제목</th>
                            <td colspan="3">
                                <input type="text" class="form-control" name="subject" placeholder="글제목" value="${content.subject}" />
                            </td>
                        </tr>
                        <tr>
                            <th class="active">글번호</th>
                            <td>${content.contentNo}</td>
                            <th class="active">조회수</th>
                            <td>${content.viewCount}</td>
                        </tr>
                        <tr>
                            <th class="active">내용</th>
                            <td colspan="3">
                                <textarea class="form-control" name="text" rows="5">${content.text}</textarea>
                            </td>
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
                <br />
                <div class="text-right">
                    <button type="submit" class="btn btn-info btn-sm">저장</button>
                    &nbsp;
                    <a class="btn btn-danger btn-sm" href="/list" role="button">취소</a>
                </div>
            </form>
        </div>
    </div>
</div>

<c:import url="../template/footer.jsp" />