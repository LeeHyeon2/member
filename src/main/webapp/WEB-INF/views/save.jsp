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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
    <style>
        input{
            display: block;
        }
    </style>
</head>
<body>
  <div class="container">
      <h2>save.jsp</h2>
      <form action="/save" method="post">
          ID 입력 : <input type="text" onblur="duplicateCheck()" id="memberId" name="memberId">
          <span id="dup-check-result"></span><br>
          Password 입력 : <input type="text" name="memberPassword"> <br>
          이름 입력 : <input type="text" name="memberName"> <br>
          나이 입력 : <input type="text" name="memberAge"> <br>
          전화번호 입력 : <input type="text" name="memberPhone"> <br>
          <input type="submit" value="수정">
          <input type="button" value="button타입">
      </form>
  </div>
</body>
<script>
    const duplicateCheck = () => {
        const memberId = document.getElementById("memberId").value;
        const checkResult = document.getElementById("dup-check-result");
        $.ajax({
            type: "post", // http request method
            url: "duplicate-check", // 요청주소(컨트롤러 주소값)
            data: {"memberId": memberId}, // 전송하는 파라미터
            dataType: "text", // 리턴받을 데이터 형식
            success: function (result){
                if(result=="ok"){
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "성공";
                }else{
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "실패";
                }
            },
            error: function (){
                alert("오타체크")
            }
        })
    }
</script>
</html>
