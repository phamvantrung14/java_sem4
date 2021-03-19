<%--
  Created by IntelliJ IDEA.
  User: asuspc
  Date: 3/19/2021
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div>
            <a class="navbar-brand" href="#">Navbar</a>
        </div>
        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${user == null}">
                <form action="insert" method="post">
            </c:if>
                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${user!=null}">
                        <input type="hidden" name="id" value="<c:out value="${user.id}"/>"/>
                    </c:if>
                    <fieldset class="form-group">
                        <label>User name</label>
                        <input type="text" value="<c:out value="${user.name}"/>" class="form-control" name="name"
                        required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Password</label>
                        <input type="text" value="<c:out value="${user.password}"/>" class="form-control"
                               name="password"
                               required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Country</label>
                        <input type="text" value="<c:out value="${user.country}"/>" class="form-control"
                               name="country"
                               required="required">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>

        </div>
    </div>
</div>

</body>
</html>
