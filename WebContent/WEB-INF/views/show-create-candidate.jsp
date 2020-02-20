<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Candidate</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  <link rel="stylesheet" href="/resources/demos/style.css">

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>

  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>

 $( function() {

    $( "#datepicker" ).datepicker({
    	dateFormat: 'dd-mm-yy'
    });

  } );

  </script>


</head>
<body>

<form:form action="${pageContext.request.contextPath}/CRApp/createcandidate" modelAttribute="candidate" method="POST">
    <%--    <form:input type="text" path="id" placeholder="enter id"/> --%>
    <form:hidden path="id"/>
      <form:input type="text" path="candidateName" placeholder="enter username"/>
      <br><br>
      <form:select path="gender"><option value="Male">Male</option><option value="Female">Female</option></form:select>
      <br><br>
      <form:input type="text"  path="candidateEmail" placeholder="Enter Email"/>
      <br><br>
      <form:input type="text"  path="previousEmployer" placeholder="Enter Previous Employer"/>
      <br><br>
      <form:input type="text"  path="phoneNumber" placeholder="Enter Phone Number"/>
      <br><br>
       <form:input type="text"  path="dateOfInterview" id="datepicker" placeholder="Enter dateOfInterview"/> 
      <br><br>
      <input type="submit"  value="Save"/>
    </form:form>
    
    <br><br>
    <a href="${pageContext.request.contextPath}/CRApp/home"> Home </a>

</body>
</html>