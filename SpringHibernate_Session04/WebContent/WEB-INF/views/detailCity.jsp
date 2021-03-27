<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
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
		<h1>Detail CITY</h1>
		
		
			<table border="1">
				<tr>
					<td>City id:</td>
					<td>
						${c.cityId}
					</td>
				</tr>
				<tr>
					<td>City Name:</td>
					<td>
						${c.cityName}
					</td>
				</tr>
				<tr>
					<td>Country:</td>
					<td>
						${c.countryId.countryName}
					</td>
				</tr>
				<tr>
					<td>Foundation Date:</td>
					<td>
						${c.foundationDate}
					</td>
				</tr>
				<tr>
					<td>Area:</td>
					<td>
							${c.area}
					</td>
				</tr>
				<tr>
					<td>Population:</td>
					<td>
						${c.population}
					</td>
				</tr>
				<tr>
					<td colspan="2"><a href="proUpdateCity?cityId=${c.cityId}">update</a></td>
					
				</tr>
			</table>
	
		<a href="listCities">Back</a>
	</div>
</body>
</html>