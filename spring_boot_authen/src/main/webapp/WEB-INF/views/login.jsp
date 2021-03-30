<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <%--    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.css">--%>
<%--    <link rel="stylesheet" href="<c:url value="assets/bootstrap.css"/>">--%>
    <link rel="stylesheet" href="${contextPath}/assets/bootstrap.css">
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

            <form action="${contextPath}/login" method="post" class="form-signin">
                <h1>Login</h1>
               <div class="form-group ${error != null ? 'has-error':''}">
                   <span>${message}</span>
                   <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true" />
                   <input name="password" type="password" class="form-control" placeholder="Password"/>
                   <span>${error}</span>
                   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                   <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                   <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
               </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>