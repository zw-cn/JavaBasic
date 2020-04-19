<%--
  Created by IntelliJ IDEA.
  User: zw-cn
  Date: 4/18/2020
  Time: 8:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#main_menu').tree({
                url:'showMenu',
                onClick: function(node){
                    if($('#main_tabs').tabs('getTab',node.text) == null){
                        // 添加一个未选中状态的选项卡面板
                        $('#main_tabs').tabs('add',{
                            title: node.text,
                            href:node.attributes.filename,
                            selected: true,
                            closable:true
                        });
                    } else {
                        $('#main_tabs').tabs('select',node.text);
                    }

                }

            });
        })
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'至尊宝管理系统'" style="height:101px;">
        <div style="width: 400px;height:70px;border: dashed #ffa8a8 1px;float: left;line-height: 70px;text-align: center">
            至尊宝管理系统的logo
        </div>
        <div style="width: 400px;height:70px;border: dashed #ffa8a8 1px;float: right;line-height: 70px;font-size: 20px;font-weight: bolder;color: cornflowerblue;text-align: center">
            你好${user.username}！欢迎登录至尊宝管理系统！
        </div>
    </div>
    <div data-options="region:'west',title:'菜单'" style="width:200px;">
        <ul id="main_menu"></ul>
    </div>
    <div data-options="region:'center',title:'内容'" style="padding:5px;background:#eee;">
        <div id="main_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">
            <div title="首页" style="padding:20px;">
                tab1
            </div>
            <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;">
                tab2
            </div>
            <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;">
                tab3
            </div>
        </div>
    </div>
    <div data-options="region:'south',title:'底部声明'" style="height:80px;">
        <div style="height:40px;color: grey;text-align: center;line-height: 40px">Copyright&copy;zw.co,</div>
    </div>
</body>
</html>
