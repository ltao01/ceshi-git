<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2019/4/20
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">添加信息</h1>
<table bgcolor="#7fffd4" align="center" border="1" cellspacing="0" cellpadding="15">

    <form action="/delete" method="post">
        <tr>
            <td> <input type="hidden" name="id" value="null" > </td></tr>
        <tr><td>账户编号</td>
            <td><input type="text" name="num" value=""></td></tr>
        <tr><td>姓名</td>
            <td><input type="text" name="name" value=""></td></tr>
        <tr><td>详细地址</td>
            <td><input type="text" name="addr" value=""></td></tr>
        <tr> <td>开户日期</td>
            <td><input type="date" name="date" value=""></td></tr>
        <tr><td>卡种</td>

            <td><select name="userId">
            <option value="" name="userId" >全部</option>

            <c:forEach var="card" items="${sessionScope.card}">

            <option value="${card.cardId}"  >${card.cardName}</option>
            </c:forEach>
            </select></td>
        <tr align="center">
            <td colspan="2">
                <input type="submit" name="" value="添加">
                <input type="reset" value="重置">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
