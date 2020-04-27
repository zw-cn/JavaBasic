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
    <title>新增花卉</title>
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script>
      $(function () {
        $("form").submit(function () {
          $(":text").each(function () {
              if($(this).val() == null){
                return false;
              }
          })
        })
      })

    </script>
  </head>
  <body>
  <h3>新增花卉信息</h3>
  <form action="add" method="post">
    <table>
      <tr>
        <td>花卉名称</td><td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>价格（元）</td><td><input type="text" name="price"></td>
      </tr>
      <tr>
        <td>原产地</td><td><input type="text" name="production"></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="提交"><input type="reset" value="重置"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
