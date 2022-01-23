<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap模板</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">显示所有联系人</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>

        <%--展示动态数据：展示request域对象中存储的联系人集合--%>
        <c:forEach items="${list}" var="linkman" varStatus="vst">
            <%--
                每遍历出来一个数据就添加一行
            --%>
            <tr>
                <td>${vst.count}</td>
                <td>${linkman.name}</td>
                <td>${linkman.sex}</td>
                <td>${linkman.age}</td>
                <td>${linkman.address}</td>
                <td>${linkman.qq}</td>
                <td>${linkman.email}</td>

                <td>
                    <a class="btn btn-default btn-sm" href="linkman?action=findOne&id=${linkman.id}">修改</a>&nbsp;
                    <%--
                        给删除按钮绑定点击事件
                    --%>
                    <a class="btn btn-default btn-sm" href="javascript:;" onclick="deleteLinkMan('${linkman.name}','${linkman.id}')">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8" align="center"><a class="btn btn-primary"
                                              href="add.jsp">添加联系人</a></td>
        </tr>
    </table>
</div>
<script>
    //声明一个删除联系人的方法
    function deleteLinkMan(name,id) {
        //弹出一个确认框，询问是否真的要删除
        var flag = confirm("你确定要删除"+name+"吗?");
        //如果点击确定，返回值flag就为true，否则就为false
        if (flag) {
            //要删除联系人
            //发送请求给LinkManServlet进行删除联系人,并且携带action=delete&id=要删除的联系人id
            location.href = "linkman?action=delete&id="+id
        }
    }
</script>
</body>
</html>
