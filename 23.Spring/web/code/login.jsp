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
    <script type="text/javascript" src="/Spring/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
      $(function () {
        $("a").click(function () {
          $("img").attr("src","/Spring/code?date="+new Date());
          return false;
        })
      })
    </script>

  <style type="text/css">
      table{
          width: 30%;
          margin: 200px auto;
      }
      tr{height: 30px}
  </style>
  </head>
  <body>

      <form action="/Spring/login" method="post">
            ${requestScope.error}
          <table>
              <tr>
                  <td>用户名：</td>
                  <td><input type="text" name="uname"></td>
              </tr>
              <tr>
                  <td>密码：</td>
                  <td><input type="password" name="upassword"></td>
              </tr>
              <tr>
                  <td>验证码：</td>
                  <td><input type="text" name="code" ><img src="/Spring/code" style="height: 30px"><a href="#">刷新</a></td>
              </tr>
              <tr>
                  <td colspan="2" align="center"><input type="submit" value="提交"></td>
              </tr>
          </table>
      </form>
  </body>
</html>
