<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Create Registration</h2>
	<form action="saveReg" method="post">
		<pre>
	    	Username:<input type="text" name="user">
	    	Mobile:<input type="text" name="mobile">
	    	City:<input type="text" name="city">
	    	Email:<input type="text" name="email">
	    	<input type="submit" value="save">
		</pre>
	</form>
	<%Boolean status =  (Boolean)request.getAttribute("status"); 
	if(status!=null){
		if(status==true){			
		out.println("record inserted!");
		}
		else
		{
			out.println("record insertion failed!");
			
		}
	}
	%>
</body>
</html>