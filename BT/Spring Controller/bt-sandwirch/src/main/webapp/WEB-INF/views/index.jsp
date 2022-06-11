<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 11/06/2022
  Time: 2:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/result" method="get">
    <table>
      <tr>
        <td><input type="checkbox" name="menu" value="lettuce">Lettuce</td>
        <td><input type="checkbox" name="menu" value="tomato">Tomato</td>
        <td><input type="checkbox" name="menu" value="mustard">Mustard</td>
        <td><input type="checkbox" name="menu" value="sprouts">Sprouts</td>
      </tr>
    </table>
    <input type="submit" value="Submit">
  </form>
  </body>
</html>
