<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<title>First Web Application</title>
</head>
<body>
<%-- 	Here are the list of your todos: ${todos.user} --%>
	<BR /> Your Name is : ${name}
	<BR />
	<c:forEach var="todo" items="${todos}">
		<li>${todo.user}</li>
		<li>${todo.desc}</li>
		<li>${todo.id}</li>
	</c:forEach>
</body>
</html>