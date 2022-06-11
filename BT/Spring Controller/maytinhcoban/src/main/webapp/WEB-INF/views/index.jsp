<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/06/2022
  Time: 2:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/result" method="get">
  <input type="text" name="first">
  <select name="operator">
    <option value="+" name="addition">+</option>
    <option value="-" name="minus">-</option>
    <option value="*" name="multiplication">*</option>
    <option value="/" name="division">/</option>
  </select>
  <input type="text" name="second">
  <input type="submit" value="=">
</form>
<p>Result: ${result}</p>
</body>
</html>
