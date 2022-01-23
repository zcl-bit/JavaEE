<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:forEach items="${pageBean.list}" var="linkman" varStatus="vst">
            <tr>
                <td>${vst.count}</td>
                <td>${linkman.name}</td>
                <td>${linkman.sex}</td>
                <td>${linkman.age}</td>
                <td>${linkman.address}</td>
                <td>${linkman.qq}</td>
                <td>${linkman.email}</td>
                <td><a class="btn btn-default btn-sm" href="修改联系人.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="修改联系人.html">删除</a></td>
            </tr>
        </c:forEach>

        <%--新增一行，用于展示总数据条数以及每页数据条数--%>
        <tr>
            <td colspan="8" align="center">
                总数据条数为${pageBean.totalSize}条<br>
                每页显示${pageBean.pageSize}条数据
            </td>
        </tr>
        <tr>
            <td colspan="8" align="center">
				<ul class="pagination success">
                    <%--
                        上一页，当前如果不是第一页才显示
                    --%>
                    <c:if test="${pageBean.currentPage != 1}">
                        <li>
                            <a href="linkman?action=findByPage&currentPage=${pageBean.currentPage - 1}&pageSize=${pageBean.pageSize}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <%--
                        页码:有多少页，就显示多少个页码，并且当前页的页码需要高亮显示
                    --%>
                    <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                        <%--
                            如果遍历的i就是当前页数，那么这一页应该高亮
                        --%>
                        <c:if test="${pageBean.currentPage == i}">
                            <%--
                                class="active"就是高亮
                            --%>
                            <li class="active"><a href="#">${i}</a></li>
                        </c:if>

                        <%--
                            如果遍历出来的i不是当前页数，那么这一页就不高亮
                        --%>
                        <c:if test="${pageBean.currentPage != i}">
                            <li><a href="linkman?action=findByPage&currentPage=${i}&pageSize=${pageBean.pageSize}">${i}</a></li>
                        </c:if>
                    </c:forEach>

                    <%--
                        下一页,如果当前页不是最后一页才显示
                    --%>
                    <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                        <li>
                            <a href="linkman?action=findByPage&currentPage=${pageBean.currentPage + 1}&pageSize=${pageBean.pageSize}" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
				</ul>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
