<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<title>First Web Application</title>
</head>
<body>
	<BR /> Your Name is : ${name}
	<BR />
	<table border="1" cellpadding="10">
	
	<c:forEach var="todo" items="${todos}">
	<tr>
		<td>${todo.user}</td>
		<td>${todo.desc}</td>
		<td>${todo.id}</td>
		<td>${todo.targetDate}</td>
	</tr>
	</c:forEach>
	
	</table>
	<BR/>
	<input type="button" onclick="location.href='/showTodo'" value="Add Todo" /> 
</body>
</html>