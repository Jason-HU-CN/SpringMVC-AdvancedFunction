<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 2023/5/14
  Time: 下午 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单信息</title>
</head>
<body>
您好：${USER_SESSION.username}
<a href="${pageContext.request.contextPath}/loginout">退出</a>
<table border="1" width="80%">
    <tr align="center"> <td colspan="2">订单ID:D001</td> </tr>
    <tr align="center"> <td>商品ID</td> <td>商品名称</td> </tr>
    <tr align="center"> <td>P001</td> <td>三文鱼</td> </tr>
    <tr align="center"> <td>P002</td> <td>红牛</td> </tr>
</table>
</body>
</html>
