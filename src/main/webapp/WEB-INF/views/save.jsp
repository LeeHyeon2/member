<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-18
  Time: 오후 4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input{
            display: block;
        }
    </style>
</head>
<body>
  <h2>save.jsp</h2>
  <form action="/save" method="post">
      ID 입력 : <input type="text" name="memberId"> <br>
      Password 입력 : <input type="text" name="memberPassword"> <br>
      이름 입력 : <input type="text" name="memberName"> <br>
      나이 입력 : <input type="text" name="memberAge"> <br>
      전화번호 입력 : <input type="text" name="memberPhone"> <br>
      <input type="submit" value="완료">
      <input type="button" value="button타입">
  </form>
</body>
</html>
