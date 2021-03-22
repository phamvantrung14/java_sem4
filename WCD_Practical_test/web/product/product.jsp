<%--
  Created by IntelliJ IDEA.
  User: asuspc
  Date: 3/22/2021
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="../assets/layout/header.jsp"%>
<c:if test="${sessionScope.username==null}">
    <jsp:forward page="/login"></jsp:forward>
</c:if>
<jsp:useBean id="finder" class="com.example.model.ProductFinderBean" scope="request" />
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
        </div>
        <a href="login?action=logout">Logout</a>
    </nav>
    <div class="jumbotron">
        <h1 class="display-4">Product List</h1>
    </div>
</div>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">price</th>
                <th scope="col">amount</th>
                <th scope="col">details</th>
            </tr>
        </thead>
        <c:forEach  var="product" items="${finder.allProduct}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.amount}"/></td>
                <td><c:out value="${product.details}"/></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

