<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
<%--    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.css">--%>
    <link rel="stylesheet" href="<c:url value="webjars/bootstrap/4.3.1/css/bootstrap.css"/>">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
    </div>
</nav>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1> Create New User</h1>
            <form:form action="add" method="post" modelAttribute="u">
                <div class="form-group">
                    <label for="username"> name:</label>
                    <form:input type="text" class="form-control" id="username" path="name" placeholder="Enter name" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <label > Email :</label>
                    <form:input type="text" class="form-control" id="username" path="email" placeholder="Enter email" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <label > Phone :</label>
                    <form:input type="text" class="form-control" id="username" path="phone" placeholder="Enter phone" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 ">
                            <input type="submit" name="login-submit" id="Login-submit" class="form-control btn btn-success" value="Save" >
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>