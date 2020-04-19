<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/18/2020
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    $(function () {
        $('#privilege_submit').click(function () {
            var nodes = $('#privilege_tree').tree('getChecked', ['checked','indeterminate']);
            for (var i = 0; i < nodes.length; i++) {
                alert(nodes[i].text);
            }
        })
    })
</script>
<div  style="padding:10px;">
    系统设置 >> 角色管理
    <hr/>
    <form id="privilege_form" method="post">
        <input type="hidden" name="id"/>
        角色名称:<input type="text" name="name"/> 角色排序ID:<input type="text" name="sort"/><br/>
        菜单导航：<ul id="privilege_tree"></ul>
        <a id="privilege_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">提交</a>
    </form>
</div>
</body>
</html>
