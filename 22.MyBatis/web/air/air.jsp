<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/25/2020
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
  <head>
    <title>查询航班</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script>

    </script>
  </head>
  <body>
  <h3>查询航班信息</h3>
  <form action="air" method="post">
  <select name="takeId" id="takePort">
    <option value="0">-请选择-</option>
    <c:forEach var="port" items="${airports}">
      <option value="${port.id}">${port.portName}</option>
    </c:forEach>
  </select><select name="landId" id="landPort">
    <option value="0">-请选择-</option>
    <c:forEach var="port" items="${airports}">
      <option value="${port.id}">${port.portName}</option>
    </c:forEach>
  </select>
  <input type="submit" value="查询">
  <br>
    <table>
      <tr>
        <th>飞机编号</th>
        <th>起飞机场</th>
        <th>起飞城市</th>
        <th>降落机场</th>
        <th>降落城市</th>
        <th>航行时间</th>
        <th>票价（元）</th>
      </tr>
      <c:forEach items="${airplanes}" var="plane">
        <tr>
          <td>${plane.airNo}</td>
          <td>${plane.takePort.portName}</td>
          <td>${plane.takePort.cityName}</td>
          <td>${plane.landPort.portName}</td>
          <td>${plane.landPort.cityName}</td>
          <td>${plane.time}
            <c:if test="${plane.time%60>0}">${plane.time%60}分钟</c:if>
          </td>
          <td>${plane.price}</td>
        </tr>
      </c:forEach>
    </table>
  </form>
  </body>
</html>
