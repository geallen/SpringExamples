<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<html>
<head>
<title>Login Page</title>
<script type="text/javascript">
	function validate(){
		if(document.forms["todo"]["user"].value == null || document.forms["todo"]["user"].value == ''){
			alert("Please Fill User Field");
			 document.forms["todo"]["user"].focus();
		      return false;
		}else if(document.forms["todo"]["desc"].value == null || document.forms["todo"]["desc"].value == ''){
			alert("Please Fill Desc Field");
			 document.forms["todo"]["desc"].focus();
		      return false;
		}
		  
	}
</script>
</head>
<body>
    <form action="/add-todo" method="POST" name="todo">
        Name : <input name="user" type="text" />
        <BR/>
        
        Description : <input name="desc" type="text" />
        <BR/>
        
         <input type="submit" value="Save" onclick="return validate();" />
    </form>
</body>
</html>