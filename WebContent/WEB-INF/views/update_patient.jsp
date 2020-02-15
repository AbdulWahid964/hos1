 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<script>

 $( function() {

    $( "#datepicker" ).datepicker({
    	dateFormat: 'dd-mm-yy'
    });

  } );

  </script>


<body>
 
<div class="container">
  <h2>Enroll Patient</h2>
<form:form action="${pageContext.request.contextPath}/patient/updatePatient" method="post" commandName="patient">

    <div class="form-group">
      <label for="patient_id">Patient Id:</label>
      <form:input path="patientId"  class="form-control" readonly="true" placeholder="Enter Patient Id"/>
    </div>
    <div class="form-group">
      <label for="first_name">First Name:</label>
		<form:input path="firstName"  class="form-control" placeholder="Enter First Name "/>
    </div>

    <div class="form-group">
      <label for="last_name">Last Name</label>
		<form:input path="lastName"  class="form-control" placeholder="Enter Last Name "/>
    </div>
    
    <div class="form-group">
      <label for="password">Password:</label>
      <form:password path="password"  class="form-control" readonly="true" placeholder="Enter Password "/>
    </div>
    <%-- 
    <div class="form-group">
      <label for="dob">Date Of Birth</label>
		<form:input type="text" class="form-control"  path="dateOfBirth"   placeholder="Date Of birth" />
    </div>
     --%>
    <div class="form-group">
      <label for="email">Email</label>
	<form:input class="form-control" path="emailAddress" placeholder="Enter Email"/>
    </div>
    
    <div class="form-group">
      <label for="contactNumber">Contact Number</label>
      <form:input path="contactNumber"  class="form-control"  placeholder="Enter Contact Number"/>
    </div>
    
    <div class="form-group">
      <label for="state">State</label>
      <form:input path="state"  class="form-control" placeholder="Enter State"/>
    </div>
    
    <div class="form-group">
      <label for="insurance">Insurance Plan</label>
      <form:input path="insurancePlan"  class="form-control"  placeholder="Enter Insurance Plan"/>
    </div>
    
  
    <button type="submit" class="btn btn-default">Update Patient</button>
  </form:form><br/>
</div>

</body> 
</html>
