<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-18
  Time: 오후 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>index.jsp</h2>
    <a href="/save-form">회원가입</a> <br>
    <a href="/login-form">로그인</a> <br>
    <a href="/findAll">목록출력</a> <br>
    <a href="/response-test">ResponseBody Test</a><br>
    <a href="/response-test2">ResponseBody Test2</a>
    로그인 화원 정보 : ${loginResult} <br>
    세션에 담은 memberId:${sessionScope.loginMemberId}<br>
    세션에 담은 id:${sessionScope.loginId}<br>

</body>
</html>
