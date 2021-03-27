<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<h1>INSERT CITY</h1>
		<h3 style="color: red">${err}</h3>
		<form:form action="insertCity" modelAttribute="c" method="post">
			<table>
				<tr>
					<td>City Name:</td>
					<td>
						<form:input path="cityName" required="required"/>
					</td>
				</tr>
				<tr>
					<td>Country:</td>
					<td>
						<form:select path="countryId.countryId">
							<form:options items="${listCountry}" itemLabel="countryName" itemValue="countryId"/>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>Foundation Date:</td>
					<td>
						<form:input path="foundationDate" required="required" type="date"/>
					</td>
				</tr>
				<tr>
					<td>Area:</td>
					<td>
						<form:input path="area" required="required" type="number"/>
					</td>
				</tr>
				<tr>
					<td>Population:</td>
					<td>
						<form:input path="population" required="required" type="number"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input  value="Insert" type="submit"/>
						<input  value="Clear" type="reset"/>
					</td>
				</tr>
			</table>
		</form:form>
		<a href="listCities">Back</a>
	</div>
</body>
</html>