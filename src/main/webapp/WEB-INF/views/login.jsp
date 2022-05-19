<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-18
  Time: 오후 4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h2>login-form.jsp</h2>
  <form action="/login" method="post">
      ID 입력 :<input type="text" name="memberId"> <br>
      Password 입력 : <input type="password" name="memberPassword"> <br>
      <input type="submit" value="로그인">
  </form>
</body>
</html>
