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
        $("#role_edit_submit").click(function () {
            $("#role_edit_form").form('submit', {
                url:"update",
                onSubmit: function(){
                    // do some check
                    // return false to prevent submit;
                },
                success:function(data){
                    if(data == 1){
                        $.messager.show({
                            title:'系统消息',
                            msg:'修改成功！',
                            timeout:3000,
                            showType:'slide'
                        });

                        $("#role_dialog").dialog("close");
                        $("#role_dataGrip").datagrid("reload");
                    }else {
                        $.messager.alert('警告','修改失败！');
                    }
                }
            });
        })
    })

</script>
    <div  style="padding:10px;">
        系统设置 >> 角色管理
        <hr/>
        <form action="" method="post" id="role_edit_form">
            <input type="hidden" name="id"/>
            <table>
                <tr>
                    <td>角色名称:</td>
                    <td><input type="text" name="name"/> </td>
                </tr>
                <tr>
                    <td>角色排序:</td>
                    <td><input type="text" name="sort"/> </td>
                </tr>
                <tr>
                    <td>角色备注:</td>
                    <td><input type="text" name="remark"/> </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a id="role_edit_submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">修改</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
