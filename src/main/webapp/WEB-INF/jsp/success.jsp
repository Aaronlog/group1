<%@ page import="java.text.DateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ibm
  Date: 2018/6/14
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/saveCust.action" method="post" enctype="multipart/form-data">
    <input type="file" name="excel">
    <input type="submit" value="sub">
</form>

<c:if test="${!empty requestScope.cust}">
    <table border="1" width="50%">
        <tr>
            <th>cus_id</th>
            <th>cname</th>
            <th>date</th>
        </tr>
        <c:forEach items="${requestScope.cust}" var="c">
            <tr>
                <td>${c.cus_id}</td>
                <td>${c.cname}</td>
                <td><fmt:formatDate value="${c.date}" pattern="yyyy年MM月dd天"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
