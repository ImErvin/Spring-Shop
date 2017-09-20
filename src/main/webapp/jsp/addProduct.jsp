<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add New Product - SS RAD Final Project</title>
</head>
<body>
	<h1>Add New Product</h1>
	
	<form:form modelAttribute="product">
		<table>
			<tr>
			  	<td>Product Description:</td>
				<td><form:input path="pDesc"></form:input></td>
				<td><form:errors path="pDesc"></form:errors></td>
			</tr>
			
			<tr>
			  	<td>Quantity in Stock:</td>
				<td><form:input path="qtyInStock"></form:input></td>
				<td><form:errors path="qtyInStock"></form:errors></td>
			</tr>
				
			<tr>
				<td><input type="submit" value="Add"/></td>
			</tr>
			
		</table>
	</form:form>

	<br/>
	
	<table>
		<tr>
			<td><a href="/">Home</a></td>
			<td><a href="/showProducts">List Products</a></td>
			<td><a href="/showCustomers">List Customers</a></td>
			<td><a href="/showOrders">List Orders</a></td>
		</tr>
	</table>
</body>
</html>