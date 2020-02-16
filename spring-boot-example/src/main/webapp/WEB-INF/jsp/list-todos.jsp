<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>First Web Application</title>
</head>
<body>
	<BR /> Your Name is : ${name}
	<BR />
	<table border="1" cellpadding="10">
	<tr><th>ID</th><th>User</th><th>Description </th><th>Target Date</th><th>Operations</th>
	</tr>
	<c:forEach var="todo" items="${todos}">
	<tr>
		<td>${todo.id}</td>
		<td>${todo.user}</td>
		<td>${todo.desc}</td>
		<td>${todo.targetDate}</td>
		<td><a href="/editTodo?id=${todo.id}" >Edit</a></td>
		<td><a href="/deleteTodoById?id=${todo.id}">Delete</a></td>
	</tr>
	</c:forEach>
	
	</table>
	<BR/>
	<input type="button" onclick="location.href='/showTodo'" value="Add Todo" /> 
	<BR/><BR/>
	<c:if test="${fn:length(todos) gt 1}">
   		<input type="button" onclick="location.href='/deleteAll'" value="Delete All"/>
	</c:if> 
</body>
</html>