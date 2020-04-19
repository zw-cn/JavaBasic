<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#privilege_submi").click(function(){
		var arr =$('#privilege_tree').tree('getChecked', ['checked','indeterminate']);
		var result = "";
		for(var i = 0;i<arr.length;i++){
			result+=arr[i].text+"  ";
		}
		alert(result);
	});
})
</script>
<form id="privilege_form" method="post"> 
<input type="hidden" name="id"/>
角色名称:<input type="text" name="name"/> 角色排序ID:<input type="text" name="sort"/><br/>
菜单导航：<ul id="privilege_tree"></ul>
<a id="privilege_submi" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a>  
</form>
</body>
</html>