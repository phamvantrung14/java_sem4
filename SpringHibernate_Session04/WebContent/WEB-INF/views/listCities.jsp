<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.center{
	display: flex;
	flex-direction: column;;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<div class="center">
		<h1>LIST CITIES</h1>
		<div style="color: red">${err}</div>
		<div style="color: green">${success}</div>
		<table border="1">
			<tr>
				<th>City Id</th>
				<th>City Name</th>
				<th>Country Name</th>
				<th>Foundation Date</th>
				<th>Area</th>
				<th>Population</th>
				<th>Details</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list11}" var="i">
				<tr>
					<td>${i.cityId }</td>
					<td>${i.cityName }</td>
					<td>${i.countryId.countryName}</td>
					<td>${i.foundationDate }</td>
					<td>${i.area }</td>
					<td>${i.population }</td>
					<td><a href="detailCity?cityId=${i.cityId }">Detail</a></td>
					<td><a href="deleteCity?cityId=${i.cityId }" onclick="return confirm('Sure?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="initInsertCity">Add New City</a>
	</div>
</body>
</html>