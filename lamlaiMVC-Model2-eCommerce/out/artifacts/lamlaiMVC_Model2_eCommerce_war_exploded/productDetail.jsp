<%--
  Created by IntelliJ IDEA.
  User: asuspc
  Date: 3/12/2021
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .center{
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="center">
    <h1>Product detail</h1>

    <table border="1">
        <tr>
            <td><b>Student ID</b></td>
            <td>${product.id }</td>
        </tr>
        <tr>
            <td><b>firstName</b></td>
            <td>${product.name }</td>
        </tr>
        <tr>
            <td><b>lastName</b></td>
            <td>${product.desc }</td>
        </tr>
        <tr>
            <td >
                <form action="product" method="post">
                    <input name="id" value="${product.id }" type="hidden">
                    <input type="submit" name="action" value="delete">
                </form>
            </td>
            <td>
                <form action="product" method="post">
                    <input name="id" value="${product.id }" type="hidden">
                    <input type="submit" name="action" value="editProduct">
                </form>
            </td>

        </tr>




    </table>
    <a href="product">Back</a>
</div>
</body>
</html>
