<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/06/2022
  Time: 2:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:forEach items="${menu}" var="menu">
    <p>${menu}</p>
</c:forEach>
</body>
</html>
