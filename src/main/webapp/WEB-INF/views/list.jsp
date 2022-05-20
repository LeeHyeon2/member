<%--
  Created by IntelliJ IDEA.
  User: GRAM
  Date: 2022-05-18
  Time: 오후 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/resources/js/jquery.js"></script>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
    <h2>list.jsp</h2>
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
            <th>ajax 조회</th>
        </tr>
            <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>${member.memberId}</td>
                <td>${member.memberPassword}</td>
                <td>${member.memberName}</td>
                <td>${member.memberAge}</td>
                <td>${member.memberPhone}</td>
                <td><a href="/detail?id=${member.id}">조회</a></td>
                <td><a href="/delete?id=${member.id}">삭제</a></td>
                <td><button onclick="ajaxCheck('${member.id}')">조회</button></td>
            </tr>
            </c:forEach>
    </table>
    <div id="ajaxResult">

    </div>
</body>
<script>
    const ajaxCheck = (id) => {
        console.log(id);
        const ajaxResult = document.getElementById("ajaxResult");
        $.ajax({
            type: "post", // http request method
            url: "ajax1", // 요청주소(컨트롤러 주소값)
            data: {"id": id}, // 전송하는 파라미터
            dataType: "json", // 리턴받을 데이터 형식
            success: function (result) {
                let output = "<table class='table'>";
                output += "<tr>" +
                    "<th>id</th> <th>memberId</th> <th>memberPassword</th> <th>memberName</th>" +
                    "<th>memberAge</th> <th>memberPhone</th> " +
                    "</tr>";
                output += "<tr>";
                output += "<td>" + result.id                  + "</td>";
                output += "<td>" + result.memberId            + "</td>";
                output += "<td>" + result.memberPassowrd      + "</td>";
                output += "<td>" + result.memberName          + "</td>";
                output += "<td>" + result.memberAge           + "</td>";
                output += "<td>" + result.memberPhone         + "</td>";
                output += "</tr>";
                output += "</table>";

                ajaxResult.innerHTML = output;
            },
            error: function () {
                alert("오타체크");
            }
        });
    }
</script>
</html>
