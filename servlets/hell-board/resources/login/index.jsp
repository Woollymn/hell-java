<%@ page import="com.hellBoard.entity.User" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../template/header.jsp" />

<div class="container-fluid">
    <div class="row">
        <div>
            <%
                /*
                out.println(User.getInstance().iterator().next().getUserName());
                */
            %>
            암호가 틀린듯?
            message 객체를 뱉어내자
        </div>
    </div>
</div>

<c:import url="../template/footer.jsp" />