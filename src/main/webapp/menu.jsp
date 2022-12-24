<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17.12.2022
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
  <div class="vertical-menu">
   <form action="enter" method="get">
       <a class="active"> Menu </a>
        <a href="http://localhost:8086/JavaTask4_war_exploded/"> Logout </a>
         <a href="enter?a=Login"> List accounts </a>
   </form>
  </div>
</body>
</html>
