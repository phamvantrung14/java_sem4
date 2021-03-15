<%--
  Created by IntelliJ IDEA.
  User: asuspc
  Date: 3/15/2021
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="col-6">
        <h1>Edit product</h1>
        <form action="product" method="post">
            <input type="hidden" name="id" value="${product.id}">
            <div class="form-group">
                <label>Product name</label>
                <input type="text" class="form-control" value="${product.name}" name="name"  placeholder="product name">
            </div>
            <div class="form-group">
                <label >Product description</label>
                <input type="text" class="form-control" value="${product.desc}" name="desc"  placeholder="description">
            </div>

            <input type="submit" class="btn btn-primary"  name="action" value="update"/>
        </form>
    </div>
</div>
</body>
</html>
