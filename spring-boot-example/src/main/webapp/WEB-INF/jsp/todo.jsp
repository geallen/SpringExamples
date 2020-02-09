<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<html>
<head>
<title>Login Page</title>
</head>
<body>
    <form action="/add-todo" method="POST">
        Name : <input name="user" type="text" />
        <BR/>
        
        Description : <input name="desc" type="text" />
        <BR/>
        
         <input type="submit" value="add" />
    </form>
</body>
</html>