<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/25/2020
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      a{text-decoration: none}
      a:hover{
        color: red;
      }
    </style>
  </head>
  <body>
  <h3>花卉信息</h3>
  <table>
    <tr>
      <td>花卉编号</td>
      <td>花卉名称</td>
      <td>价格（元）</td>
      <td>原产地</td>
    </tr>
    <c:forEach items="${flowers}" var="flower">
      <tr>
        <td>${flower.id}</td>
        <td>${flower.name}</td>
        <td>${flower.price}</td>
        <td>${flower.production}</td>
      </tr>
    </c:forEach>
    <a href="add.jsp">添加花卉信息</a>
  </table>
  </body>
</html>
