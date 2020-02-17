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
<form:form action="${pageContext.request.contextPath}/physician/updatePhysician" method="post" commandName="physician">

       <div class="form-group">
      <label for="physician_id">Physician Id:</label>
      <form:input path="physicianId"  class="form-control" readonly="true" placeholder="Enter Physician Id"/>
    </div>
    
    <div class="form-group">
      <label for="physician_first_name">Physician First Name:</label>
		<form:input path="physicianFirstName"  class="form-control" placeholder="Enter First Name "/>
</div>
    <div class="form-group">
      <label for="phy_last_name">Physician Last Name:</label>
		<form:input path="physicianLastName"  class="form-control" placeholder="Enter Physician Last Name "/>
    </div>
    
    <div class="form-group">
      <label for="department">Department:</label>
      <form:input path="department"  class="form-control" placeholder="Enter Department "/>
    </div>
    
    <div class="form-group">
      <label for="year_of_Experience">year Of Experience:</label>
	<form:input class="form-control" path="yearOfExperience" placeholder="Enter Year Of Experience"/>
    </div>
    
    <div class="form-group">
      <label for="state">state</label>
      <form:input path="state"  class="form-control"  placeholder="Enter State"/>
    </div>

    <div class="form-group">
      <label for="insurance">Insurance Plan</label>
      <form:input path="insurancePlan"  class="form-control"  placeholder="Enter Insurance Plan"/>
    </div>
  
    <button type="submit" class="btn btn-default">Update Physician</button>
  </form:form><br/>
</div>

</body> 
</html>
