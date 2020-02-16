<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Login Page</title>
</head>
<body>

	<form:form method="POST" modelAttribute="todo" action="/update-todo">
		<input name="id" id="id" type="hidden" value=${todo.id } />
		User:
		<form:input path="user" id="user" />
		Desc :
        <form:input path="desc" id="desc" />
		<input type="submit" value="Update" />
	</form:form>
</body>
</html>