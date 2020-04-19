<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">   
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>   
<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script> 
<style type="text/css">
.myicon-login{
	background:url('images/login.png') no-repeat center center;
}
</style>
<script type="text/javascript">
$(function(){
	$("#login_submit").click(function(){
		$('#login_form').form('submit', {    
		    url:'login',    
		    onSubmit: function(){    
		        //非空验证等   
		        if($(":text:eq(0)").val()==""){
		        	$.messager.alert('系统信息','用户名不能为空');
		        	return false;
		        }
		        else if($(":password:eq(0)").val()==""){
		        	$.messager.alert('系统信息','密码不能为空');
		        	return false;
		        }
		    },    
		    success:function(data){    
		       	if(data=="1"){
		       		location.href="page/main.jsp";
		       	}else{
		       		$.messager.alert('系统信息','登录失败');  
		       	}
		    }    
		});
	})
})
</script>
</head>
<body style="background-color:#E9F1FF;">
	<div style="margin:100px auto;width:400px;">
		<div id="p" class="easyui-panel" title="登录"     
	        style="width:400px;height:200px;padding:10px;background:#fafafa;"   
	        data-options="iconCls:'myicon-login'">   
		        <form action="login" method="post" id="login_form">
		        	 <table width="225" align="center">
		        	 	<tr>
		        	 		<td colspan="2" style="text-align:center;font-size:20px; font-weight:bold">至尊管理系统</td>
		        	 	</tr>
		        	 	<tr style="height:40px;">
		        	 		<td>登录名</td>
		        	 		<td><input type="text" name="username"/> </td>
		        	 	</tr>
		        	 	<tr style="height:40px;">
		        	 		<td>
		        	 			密码
		        	 		</td>
		        	 		<td><input type="password" name="password"/> </td>
		        	 	</tr>
		        	 	<tr>
		        	 		<td colspan="2" align="right">
		        	 			<a id="login_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'">登录</a> 
		        	 		</td>
		        	 	</tr>
		        	 </table>
		        </form>
		</div>
	</div>
</body>
</html>