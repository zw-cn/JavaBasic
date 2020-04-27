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
  </head>
  <body>
  <h3>人员信息</h3>
  <table>
    <tr>
      <td>编号</td>
      <td>名称</td>
      <td>年龄</td>
    </tr>
    <c:forEach items="${pl}" var="people">
      <tr>
        <td>${people.id}</td>
        <td>${people.name}</td>
        <td>${people.age}</td>
      </tr>
    </c:forEach>
  </table>
  </body>
</html>
