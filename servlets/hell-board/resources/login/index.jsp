<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../template/header.jsp" />

<div class="container-fluid">
    <div class="row">
        <div class="text-center">
            <h1><span class="glyphicon glyphicon glyphicon-ban-circle text-danger" aria-hidden="true"></span></h1>
            <ul class="list-unstyled">
                <c:forEach var="message" items="${messages}">
                    <li><c:out value="${message.value}" /></li>
                </c:forEach>
            </ul>
            <a href="/">메인으로 이동</a>
        </div>
    </div>
</div>

<c:import url="../template/footer.jsp" />