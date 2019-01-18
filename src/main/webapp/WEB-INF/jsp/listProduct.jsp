<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>分类</td>
            <td>价格</td>
            <td>生产地</td>
            <td>编码</td>
        </tr>
        <c:forEach items="${page.content}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.category}</td>
                <td>${c.price}</td>
                <td>${c.place}</td>
                <td>${c.code}</td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <a href="?start=0">[首  页]</a>
        <a href="?start=${page.number-1}">[上一页]</a>
        <a href="?start=${page.number+1}">[下一页]</a>
        <%--<a href="?start=${page.totalPages-1}">[末  页]</a>--%>
    </div>
   page： <input value="${page.number}" disabled/>
   size：  <input value="${page.size}"disabled/>
    <br>
    <form action="queryproduct" method="post">

        name: <input name="keyword"> <br>
        <button type="submit">提交</button>

    </form>
</div>
