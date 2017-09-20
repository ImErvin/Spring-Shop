<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Customer - SS RAD Final Project</title>
</head>
<body>
	<h1>Show Customers</h1>
		<c:forEach items="${customers}" var="customer">
			<h2>${customer.cId} ${customer.cName}</h2>
			<h3>${customer.cName}'s Orders</h3>
			<table border="2">
				<tr>
					<th>Order ID</th>
					<th>Quantity</th>
					<th>Product ID</th>
					<th>Description</th>
				</tr>
					
				<c:forEach items ="${customer.orders}" var="order">
					<tr>
						<td>${order.oId}</td>
						<td>${order.qty}</td>
						<td>${order.prod.pId}</td>
						<td>${order.prod.pDesc}</td>
					</tr>
				</c:forEach>
					
			</table>
			<br/>
		</c:forEach>
		
	<table>
		<tr>
			<td><a href="/">Home</a></td>
			<td><a href="/addCustomer">Add Customers</a></td>
			<td><a href="/showProducts">List Product</a></td>
			<td><a href="/showOrders">List Orders</a></td>
			<td><a href="/logout">Logout</a></td>
		</tr>
	</table>
</body>
</html>