<%--
  Created by IntelliJ IDEA.
  User: 刘涛
  Date: 2019/4/19
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户数据列表</title>
    <script src="js/jquery-3.3.1.min.js"></script>
</head>
<body bgcolor="aqua">
<h1 align="center">用户数据列表</h1>
</div>
<form action="/show" method="post" style="text-align: center">
    卡种分类:<select name="kaname" >
    <option value="0" name="" >全部</option>
    <c:forEach var="card" items="${sessionScope.card}">

        <option value="${card.cardId}" name=""<c:if test="${card.cardId==sessionScope.page.kaname}" >  selected="selected"</c:if> >${card.cardName}</option>
    </c:forEach>
</select>
    姓名： <input type="text" name="username" value="${sessionScope.page.username}">
            <input type="submit" value="查询">


<div style="text-align: right ; margin-right: 20%">
<input type="button" onclick="location.href='/add.jsp'" value="添加账户">
</div>
</form>
<table border="1" align="center" cellspacing="0" cellpadding="15" bgcolor="#ffc0cb" >
    <tr>
        <input type="hidden" value="">
        <td>Id</td>
        <td>账户编号</td>
        <td>姓名</td>
        <td>详细地址</td>
        <td>开户日期</td>
        <td>卡种</td>
        <td>删除</td>
        <td>修改</td>
    </tr>

    <c:forEach var="list" items="${sessionScope.list}" >
        <tr>
            <td>${list.id}</td>
            <td>${list.num}</td>
            <td>${list.name}</td>
            <td>${list.addr}</td>
            <td>${list.date}</td>
            <td>${list.card.cardName}</td>
            <td><a href="/delete?deleteId=${list.id}" name="" >删除</a></td>
            <td><a href="/update?update=${list.id}" name="" >修改</a> </td>


        </tr>

    </c:forEach>
</table>
<table align="center"  bgcolor="#7fffd4">
    <tr><td >
        <a href="javascript:topage(1)">首页</a>
        <a href="javascript:topage(${sessionScope.page.startpage}-1)">上一页</a>
        <a href="javascript:topage(${sessionScope.page.startpage}+1)">下一页</a>
        <a href="javascript:topage(${sessionScope.page.sumpage})">尾页</a>
        <input type="text" name="" id="ID"  value="${page.startpage}" >
        <a href="javascript:topage1()" >G0</a>
        第${sessionScope.page.startpage}页/共${sessionScope.page.sumpage}页
    </td>
    </tr>
</table>
</body>
<script>
function topage(a) {

        if (a>${sessionScope.page.sumpage}){

            a=${sessionScope.page.sumpage};
                }
        if(a<1){
            a=1
                }
            location.href="/show?currpage="+a;
            }
function  topage1() {

     location.href = "/show?currpage=" + ($("#ID").val())

}
</script>

</html>
