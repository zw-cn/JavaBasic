<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/18/2020
  Time: 1:54 PM
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
        $('#role_dataGrip').datagrid({
            url:'showRole',
            columns:[[
                {field:'id',hidden:true,title:'id',width:100},
                {field:'name',title:'角色名称',width:100},
                {field:'sort',title:'排序',width:100,align:'right'},
                {field:'remark',title:'备注',width:100,align:'right'},
                {field:'edit',title:'操作',width:100,align:'right',formatter:function () {
                        return "<a href='' class='myRole_assign_privilege_a' onclick='assign(this);'>分配权限</a>&emsp;<a href='' id='myRole_check_privilege_a'>查看权限</a>";
                    }}
            ]],
            pagination:true,
            pageList:[2,4,6,8],
            fitColumns:true,
            striped:true,
            rownumbers:true,
            onLoadSuccess:function(){
                $('.myRole_assign_privilege_a').linkbutton({
                    iconCls: 'icon-search'
                });
            },
            toolbar: [{
                iconCls: 'icon-edit',
                text:'增加',
                handler: function(){alert('编辑按钮')}
            },'-',{
                iconCls: 'icon-cancel',
                text:'删除',
                handler: function(){alert('帮助按钮')}
            },'-',{
                iconCls: 'icon-tip',
                text:'分配权限',
                handler: function(){alert('帮助按钮')}
            },'-',{
                iconCls: 'icon-search',
                text:'修改',
                handler: function(){
                    if($("#role_dataGrip").datagrid("getSelections").length == 1){
                        $('#role_dialog').dialog({
                            title: 'My Dialog',
                            width: 400,
                            height: 200,
                            closed: false,
                            cache: false,
                            href: 'sys/myRole_edit.jsp',
                            modal: true,
                            onLoad:function () {
                                $("#role_edit_form :text:eq(0)").val($("#role_dataGrip").datagrid("getSelected").name);
                                $("#role_edit_form :text:eq(1)").val($("#role_dataGrip").datagrid("getSelected").sort);
                                $("#role_edit_form :text:eq(2)").val($("#role_dataGrip").datagrid("getSelected").remark);
                                $("#role_edit_form :hidden:eq(0)").val($("#role_dataGrip").datagrid("getSelected").id);
                            }

                        });
                    }else{
                        $.messager.alert("系统信息","<b>请选择要修改的行！</b>");
                    }

                }
            }]

        });
    })


    function assign(btn){
        //alert($(btn).parents("td").siblings("[field=\"id\"]").text());
        $('#privilege_dialog').dialog({
            title: 'My Dialog',
            width: 400,
            height: 200,
            closed: false,
            cache: false,
            href: 'sys/myPrivilege.jsp',
            modal: true,
            onLoad:function () {
                var id = $("#privilege_form :hidden:eq(0)").val($(btn).parents("td").siblings("[field=\"id\"]").children("div").html());
                $('#privilege_tree').tree({
                    url:'showPrivilege?id='+id.val(),
                    checkbox:true
                });
            }

        });
    }

</script>
    <table id="role_dataGrip"></table>
    <div id="role_dialog"></div>
    <div id="privilege_dialog"></div>
</body>
</html>
