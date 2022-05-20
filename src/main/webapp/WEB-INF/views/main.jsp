<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-18
  Time: 오후 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>main.jsp</h2>
    로그인 화원 정보 : ${loginResult} <br>
    세션에 담은 memberId:${sessionScope.loginMemberId}<br>
    세션에 담은 id:${sessionScope.loginId}<br>
    <a href="/">index로 이동</a><br>
    <button class="btn btn-primary" onclick="location.href='/update-form'">수정</button><br>
    <button class="btn btn-danger" onclick="updateForm()">수정(함수호출)</button><br>
    <a href="/logout"> 로그아웃</a>

</body>
<script>
/*    function updateForm(){

    }*/
    const updateForm = () => {
       location.href = "/update-form";
    }
</script>
</html>
