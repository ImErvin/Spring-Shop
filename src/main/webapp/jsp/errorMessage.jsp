<html>
<head>
	<title>Spring MVC @ControllerAdvice example</title>	
</head>
<body>

	<h1>Error Creating the following Order</h1>
	
	<h2>${message}</h2>
	
	<table>
		<tr>
			<th>Quantity</th>
			<th>Customer ID</th>
			<th>Product ID</th>
		</tr>
		
		<tr>
			<td>${qty}</td>
			<td>${cid}</td>
			<td>${pid}</td>
		</tr>
				
	</table>

	<table>
		<tr>
			<td><a href="/">Home</a></td>
			<td><a href="/addOrder">New Order</a></td>
			<td><a href="/showOrders">List Orders</a></td>
		</tr>
	</table>
</body>
</html>