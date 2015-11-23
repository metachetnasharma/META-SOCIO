<%@ page isErrorPage="true" %>
<html>
<head>
<title>Error Page</title>
</head>
<body>
<%@ page session="false"%>
 
<h1>Opps...</h1>
<p>Sorry, an error occurred.</p>
<p>Here is the exception stack trace: </p>
<pre>
<%if(exception!=null) {
	%>
	<%=exception%>
	<%
}
%>
<p align="center" style="color: red; font-size: 20px; font-weight: bold;">${message}</p>
</pre>
</body>
</html>

