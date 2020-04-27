<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/26/2020
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页查询</title>
</head>
<body>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>价格</th>
        <th>产地</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="flower">
        <tr>
            <td>${flower.id}</td>
            <td>${flower.name}</td>
            <td>${flower.price}</td>
            <td>${flower.production}</td>
        </tr>
    </c:forEach>
</table>
<a href="page?pageNumber=${pageInfo.pageNumber-1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber<=1}">onclick="return false;"</c:if> >上一页</a>
<a href="page?pageNumber=${pageInfo.pageNumber+1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber>=pageInfo.pageTotal}">onclick="return false;"</c:if> >下一页</a>
</body>
</html>
