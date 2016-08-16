<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/header.jsp" />

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-6 col-md-6 col-sm-6 col-xs-offset-6 col-md-offset-6 col-sm-offset-6">

            <!-- right view -->
            <h1 class="col-xs-offset-3 col-md-offset-3 col-sm-offset-3">Hell Board 가입하기!</h1>
            <form class="form-horizontal" method="post" action="/join">
                <div class="form-group">
                    <label for="signUpId" class="col-xs-3 col-md-3 col-sm-3 control-label">아이디</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <input type="text" class="form-control" name="signUpId" id="signUpId" placeholder="아이디" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="signUpPassword" class="col-xs-3 col-md-3 col-sm-3 control-label">비밀번호</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <input type="password" class="form-control" name="signUpPassword" id="signUpPassword" placeholder="비밀번호" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="signUpPasswordConfirmation" class="col-xs-3 col-md-3 col-sm-3 control-label">비밀번호 재입력</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <input type="password" class="form-control" name="signUpPasswordConfirmation" id="signUpPasswordConfirmation" placeholder="비밀번호 재입력" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="signUpName" class="col-xs-3 col-md-3 col-sm-3 control-label">이름</label>
                    <div class="col-xs-4 col-md-4 col-sm-4">
                        <input type="text" class="form-control" name="signUpName" id="signUpName" placeholder="이름" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-offset-3 col-md-offset-3 col-sm-offset-3 col-xs-9 col-md-9 col-sm-9">
                        <button type="submit" class="btn btn-lg btn-success">가입하기</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<c:import url="template/footer.jsp" />