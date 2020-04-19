<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/18/2020
  Time: 7:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
    <style type="text/css">
        .myIcon-login{
            background: url("images/login.png") no-repeat center;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $('#login_submit').bind('click', function(){
                $('#login_form').form('submit', {
                    url:'login',
                    onSubmit: function(){
                        if ($(":text:eq(0)").val()=="") {
                            $.messager.alert('系统信息','用户名不能为空','info');
                            return false;
                        }
                        if ($(":password:eq(0)").val()=="") {
                            $.messager.alert('系统信息','密码不能为空','info');
                            return false;
                        }
                    },
                    success:function(data){
                        if(data=="1"){
                            location.href="page/myMain.jsp";
                        }else{
                            $.messager.alert('系统信息','登录失败');
                        }
                    }
                });
            });
        });
    </script>
</head>
<body style="background-color:#E9F1FF;">
<div style="margin:100px auto;width:400px;">
    <div id="p" class="easyui-panel" title="登录"
         style="width:400px;height:200px;padding:10px;background:#fafafa;"
         data-options="iconCls:'myIcon-login'">
        <form id="login_form" action="/login" method="post">
            <table style="text-align: center;margin: 0 auto;width: 240px">
                <tr>
                    <td colspan="2" style="font-size: 20px;font-weight: bolder">至尊宝管理系统</td>
                </tr>
                <tr style="height: 40px">
                    <td style="font-size: 14px">登录名</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr style="height: 30px">
                    <td style="font-size: 14px">密码</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr style="text-align: right">
                    <td colspan="2">
                        <a id="login_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登录</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
