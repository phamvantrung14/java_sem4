<%--
  Created by IntelliJ IDEA.
  User: asuspc
  Date: 3/22/2021
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="assets/layout/header.jsp"%>
<div class="container " style="height: 100%">
    <div class="row justify-content-center align-items-center"  style="height: 100%">
        <div class="col-3">
            <h3 class="text-center">Login</h3>
            <form action="login" method="post">
                <p style="color: red">${err}</p>
                <div class="form-group">
                    <label for="exampleInputEmail1">User name</label>
                    <input type="text" class="form-control" name="username" placeholder="user name" id="exampleInputEmail1" aria-describedby="emailHelp">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" placeholder="password" name="password" id="exampleInputPassword1">
                </div>
                <button type="submit" name="action" value="login" class="btn btn-primary">login</button>
            </form>
        </div>
    </div>


</div>

</body>
</html>

