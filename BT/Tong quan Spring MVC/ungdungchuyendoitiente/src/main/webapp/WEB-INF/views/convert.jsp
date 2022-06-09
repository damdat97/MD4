<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 09/06/2022
  Time: 10:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Chuyển đổi tiền tệ</title>
  </head>
  <body>
    <form method="post">
      <h1>Chuyển đổi tiền tệ</h1>
      <label>Số tiền muốn chuyển đổi</label>
      <input type="text" name="inputCurrency" style="margin-bottom: 20px">
      <br>
      <label>Tỉ giá</label>
      <input type="text" name="inputRate" style="margin-bottom: 20px">
      <button type="submit">Chuyển đổi</button>
      <h3>VND: ${result}</h3>
    </form>
  </body>
</html>
