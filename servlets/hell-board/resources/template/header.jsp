<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>HellBoard</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="shortcut icon" href="#" />

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#hell-content-navbar" aria-expanded="false">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <a class="navbar-brand" href="/">Hell Board</a>

        <div class="collapse navbar-collapse" id="hell-board-navbar">
            <c:choose>
                <c:when test="${sessionScope.user == null}">
                    <form class="form-inline navbar-form navbar-right" role="form" method="POST" action="/login">
                        <div class="form-group">
                            <label class="sr-only" for="signInId">아이디</label>
                            <input type="text" class="form-control" name="signInId" id="signInId" placeholder="아이디">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="signInPassword">비밀번호</label>
                            <input type="password" class="form-control" name="signInPassword" id="signInPassword" placeholder="비밀번호">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 로그인 유지
                            </label>
                        </div>
                        <button type="submit" class="btn btn-default">로그인</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="navbar-right">
                        <span>안녕하세요 ${sessionScope.user.userName}님!</span>
                        <a href="/logout">로그아웃</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>