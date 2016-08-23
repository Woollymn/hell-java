<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/header.jsp" />

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-6 col-sm-6 col-xs-offset-6 col-md-offset-6 col-sm-offset-6">

            <!-- right view -->
            <h1 class="col-xs-offset-3 col-md-offset-3 col-sm-offset-3">Hell Board 가입하기!</h1>
            <form:form action="join" commandName="signUpRequest" cssclass="form-horizontal" method="post">
                <div class="form-group">
                    <label for="email" class="col-xs-3 col-md-3 col-sm-3 control-label">이메일</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <form:input path="email" cssClass="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-xs-3 col-md-3 col-sm-3 control-label">비밀번호</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <form:input path="password" cssClass="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmedPassword" class="col-xs-3 col-md-3 col-sm-3 control-label">비밀번호 재입력</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <form:input path="confirmedPassword" cssClass="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-xs-3 col-md-3 col-sm-3 control-label">이름</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <form:input path="name" cssClass="form-control" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-md-offset-3 col-sm-offset-3 col-xs-9 col-md-9 col-sm-9">
                        <button type="submit" class="btn btn-lg btn-success">가입하기</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<c:import url="template/footer.jsp" />