<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-20
  Time: 오전 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
    <h2>delete.jsp</h2>
    <table class="table">
        <tr>
            <th>id</th>
            <th>memberId</th>
            <th>memberPassword</th>
            <th>memberName</th>
            <th>memberAge</th>
            <th>memberPhone</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>${member.memberId}</td>
                <td>${member.memberName}</td>
                <td>${member.memberPassword}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberPhone}</td>
                <td><a href="/detail?id=${member.id}">조회</a></td>
                <td><a href="/delete?id=${member.id}">삭제</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
