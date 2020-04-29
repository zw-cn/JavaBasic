<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/28/2020
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Spring+MyBatis机场信息</title>
  </head>
  <body>
  <c:forEach items="${airports}" var="airport">
    ${airport.id}-${airport.name}-${airport.city}<br>
  </c:forEach>

  </body>
</html>
