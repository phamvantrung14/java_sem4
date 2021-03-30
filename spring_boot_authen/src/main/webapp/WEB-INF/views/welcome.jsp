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
    <link rel="stylesheet" href="<c:url value="assets/bootstrap.css"/>">
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
       <c:if test="${pageContext.request.userPrincipal.name != null}">
           <form id="LogoutForm" method="post" action="${contextPath}/logout">
               <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           </form>
           <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
       </c:if>
    </div>
</div>


</body>
</html>