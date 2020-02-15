<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<html>
<head>
<title>Login Page</title>
</head>
<body>
<%--     <form action="/update-todo" method="POST" modelAttribute="todo"> --%>
<%--     <p>ID is : ${todo.id}</p> --%>
<!--         Name : <input name="user" type="text" /> -->
<!--         <BR/> -->
        
<!--         Description : <input name="desc" type="text" /> -->
<!--         <BR/> -->
        
<!--          <input type="submit" value="Update" /> -->
<%--     </form> --%>
  <form:form method="POST" modelAttribute="todo" action="/update-todo">
<input name="id" id="id" type="hidden" value=${todo.id} />
<form:input path="user" id="user" />
	
   Desc :
        <form:input path="desc" id="desc" />
    <input type="submit" value="Update" />
    </form:form>  
</body>
</html>