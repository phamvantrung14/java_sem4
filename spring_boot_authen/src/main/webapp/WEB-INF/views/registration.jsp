<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create an account</title>
    <%--    <link rel="stylesheet" href="${contextPath}/webjars/bootstrap/4.3.1/css/bootstrap.css">--%>
    <link type="text/css" rel="stylesheet" href="<c:url value="assets/bootstrap.css"/>">
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

            <form:form action="/registration" method="post" modelAttribute="userForm" class="form-signin">
                <h1 class="">Create your account</h1>
                <spring:bind path="username">
                    <div class="form-group" ${status.error ? 'has-error':''}>
                        <form:input path="username" type="text" class="form-control" autofocus="true"></form:input>
                        <form:errors path="username"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="form-group" ${status.error ? 'has-error':''}>
                        <form:input path="password" type="password" class="form-control" autofocus="true"></form:input>
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>
                <spring:bind path="passwordConfirm">
                    <div class="form-group" ${status.error ? 'has-error':''}>
                        <form:input path="passwordConfirm" type="password" class="form-control" autofocus="true"></form:input>
                        <form:errors path="passwordConfirm"></form:errors>
                    </div>
                </spring:bind>
               <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </form:form>
        </div>
    </div>
</div>


</body>
</html>