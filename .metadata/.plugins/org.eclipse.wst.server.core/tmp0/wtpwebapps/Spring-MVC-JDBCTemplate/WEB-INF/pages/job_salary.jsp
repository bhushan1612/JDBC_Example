<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<style>
      td{
        font-size: 20px;
        color: black;
        font-family: Times New Roman;
      }
      
      th{
        font-size: 20px;
        color: Black;
        font-family:  Arial, sans-serif;
      }
      
      h1{
      	text-decoration: underline;
      }
    </style>
</head>
<body>
	<h1 align="center">Employee Details</h1>
	<table border="1" bgcolor="white" align="center">
	
		<tr bgcolor="red" bordercolor="black">
		
			
			<th>Employee Job</th>
			<th>Employee Salary</th>
			
		<c:forEach var="emp2" items="${employee_list3}">
		
			<tr bgcolor="white">
			<td><c:out value ="${emp2.employee_job}"/></td>
			<td><c:out value ="${emp2.employee_salary}"/></td>
		</tr>	
		</c:forEach>
		<td  align="center"><a  href="home.htm">Home Page</a></td>
		</tr>
	</table>	 
	 
</body>
</html>