<head>
<meta charset="utf-8">
<title>Hospital Management System</title>
<style type="text/css">
  <%@include file="/resources/login.css" %>
</style>
</head>
<body>
<div class="container">
    <section id="content">
	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
			out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
		}
	%>
	 <c:if test="${not empty message}"><div>${message}</div></c:if> 
	
	<form name='loginForm' action="${pageContext.request.contextPath}/login" method='POST'>
	        <h1>Login Form</h1>
            <div>
            <input type='text' name='username' placeholder="Username"value=''>
            </div>
            <div>
            			<input type='password' placeholder="Password" name='password' />
            </div>
            <div>
                <input type="submit" value="Log in" />
            </div>
        </form>
        
    </section>
</div>
</body>
</html>

