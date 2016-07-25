<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>HellBoard</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#hell-board-navbar" aria-expanded="false">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <a class="navbar-brand" href="/">Hell Board</a>

        <div class="collapse navbar-collapse" id="hell-board-navbar">
            <form class="form-inline navbar-form navbar-right" role="form">
                <div class="form-group">
                    <label class="sr-only" for="signInId">아이디</label>
                    <input type="email" class="form-control" id="signInId" placeholder="아이디">
                </div>
                <div class="form-group">
                    <label class="sr-only" for="signInPassword">비밀번호</label>
                    <input type="password" class="form-control" id="signInPassword" placeholder="비밀번호">
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 로그인 유지
                    </label>
                </div>
                <button type="submit" class="btn btn-default">로그인</button>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="text-center">
            <h1>
                <span class="glyphicon glyphicon-ok-circle text-success" aria-hidden="true"></span>
                <div>가입 완료</div>
            </h1>
            <p>게시판으로 이동</p>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</body>

</html>