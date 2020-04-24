<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/23/2020
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<head>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <title>欢迎登录后台管理系统</title>
  <link href="css/style.css" rel="stylesheet" type="text/css"/>
  <script language="JavaScript" src="js/jquery.js"></script>
  <script src="js/cloud.js" type="text/javascript"></script>

  <script language="javascript">
    $(function () {
      $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
      $(window).resize(function () {
        $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
      })
    });
  </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
  <div id="cloud1" class="cloud"></div>
  <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
  <span>欢迎登录后台管理界面平台</span>
  <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
  </ul>
</div>

<div class="loginbody">

  <span class="systemlogo"></span>

  <div class="loginbox">
    <form action="/JavaEEInAction/userService" method="post">
        <input type="hidden" name="oper" value="login">
      <ul>
        <div>
          <span style="color: #f0580c;font-weight: bolder;font-size: 15px;text-align: center">
            <%=request.getAttribute("flag")!=null?"用户名或密码错误！":""%>
            <%=session.getAttribute("pwd")!=null?"密码修改成功！":""%>
            <%=session.getAttribute("reg")!=null?"注册成功！":""%>
            <%
              session.removeAttribute("pwd");
              session.removeAttribute("reg");
            %>
          </span>
        </div>
        <li><input name="uname" type="text" class="loginuser" placeholder="用户名"/></li>
        <li><input name="pwd" type="password" class="loginpwd" placeholder="密码"/></li>
        <li><input name="" type="submit" class="loginbtn" value="登录"/>
          <label><a href="#">忘记密码？</a></label>
          <label><a href="user/reg.jsp">注册</a></label>
        </li>
      </ul>
    </form>



  </div>

</div>


<div class="loginbm">版权所有 2020 <a href="http://www.zw.com">www.zw.com</a> 仅供学习交流，勿用于任何商业用途 </div>


</body>

</html>

