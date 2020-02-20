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

 <style type="text/css">
	.formError {
	color: red;
	}
	.home
{
margin-left: auto;
margin-right: auto;
}
body {
  background-repeat: no-repeat;
  height: 100%;
  background-size: cover; 
  background-attachment: fixed;
  background-position: center;
  background-color:#4ac7ed;
}

	
</style>
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
<br/>
<button type="submit" class="btn btn-primary" onclick="location.href = '${pageContext.request.contextPath}'">Home</button>
 
  <h2>Enroll Patient</h2>
<%-- <form:form action="${pageContext.request.contextPath}/patient/updatePatient" method="post" commandName="patient">

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
      <form:password   path="password"  class="form-control" placeholder="Enter Password " />
    </div>  
    
    <div class="form-group">
      <label for="dob">Date Of Birth</label>
		<form:input type="text" class="form-control" id="datepicker"  path="dateOfBirth"   placeholder="Date Of birth" />
    </div>
    
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
 --%>
<form:form action="${pageContext.request.contextPath}/patient/updatePatient" method="post" commandName="patient">
<table>
    <tr>
    	<td>Patient Id:</td>
    	<td><form:input path="patientId"  cssClass="formInput" readonly="true"/></td>
    </tr>
     <tr>
    	<td>First Name:</td>
    	<td><form:input path="firstName"  cssClass="formInput" placeholder="Enter First Name"/></td>
    	<td><form:errors path="firstName"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Last Name:</td>
    	<td><form:input path="lastName"  cssClass="formInput" placeholder="Enter Last named"/></td>
    	<td><form:errors path="lastName"  cssClass="formError"/></td>
    </tr>
    <%--  <tr>
    	<td>Password:</td>
    	<td><form:password path="password"   cssClass="formInput" placeholder="Enter Password"/></td>
    	<td><form:errors path="password"  cssClass="formError"/></td>
    </tr> --%>
     <tr>
    	<td>Date Of Birth:</td>
    	<td> <form:input type="text"  path="dateOfBirth" id="datepicker" placeholder="Enter dateOfBirth"/></td>
    	<%-- <td><form:input type="date" path="dateOfBirth" /></td> --%>
    	<%-- <td><form:errors path="dateOfBirthString"  cssClass="formError"/></td> --%>
    </tr>
  <%--   <tr>
    	<td>Date Of Birth:</td>
    	<td><form:input id="datepicker"  path="dateOfBirth"/></td>
    	  <td> <form:input type="text"  path="dateOfBirthString" id="datepicker" placeholder="Enter dateOfBirth"/></td>
    	<td> <form:input type="text"  path="dateOfBirthString" placeholder="yyyy/MM/dd"/></td>
    	<td><form:errors path="dateOfBirthString"  cssClass="formError"/></td>
    </tr>   --%>
     <tr>
    	<td>Email Address:</td>
    	<td><form:input path="emailAddress"  cssClass="formInput" placeholder="hello@gmail.com"/></td>
    	<td><form:errors path="emailAddress"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Contact Number:</td>
    	<td><form:input path="contactNumber"  cssClass="formInput" placeholder="0000000000"/></td>
    	<td><form:errors path="contactNumber"  cssClass="formError"/></td>
    </tr>
    
    <tr>
    	<td>State:</td>
    	<td><form:select path="state">
          	<form:option value="">---Select---</form:option>
          	<form:option value="Tamilnadu">Tamilnadu</form:option>
          	<form:option value="Kerala">Kerala</form:option>
          	<form:option value="Odisha">Odisha</form:option>
		</form:select></td>
		<td><form:errors path="state"  cssClass="formError"/></td>
    </tr>
    
     <%--  <tr>
    	<td>State:</td>
    	<td><form:input path="state"  cssClass="formInput" placeholder="state"/></td>
    	<td><form:errors path="state"  cssClass="formError"/></td>
    </tr> --%>
    
    <tr>
    	<td>Insurance Plan:</td>
    	<td><form:select path="insurancePlan">
          	<form:option value="">---Select---</form:option>
          	<form:option value="Medical">Medical</form:option>
          	<form:option value="Dental">Dental</form:option>
          	<form:option value="Others">Others</form:option>
		</form:select></td>
		<td><form:errors path="insurancePlan"  cssClass="formError"/></td>
    </tr>
    <%-- 
      <tr>
    	<td>Insurance Plan:</td>
    	<td><form:input path="insurancePlan"  cssClass="formInput" placeholder="ABC"/></td>
    	<td><form:errors path="insurancePlan"  cssClass="formError"/></td>
    </tr> --%>
  
    <tr>
    <td align="justify"><input type="submit" value="Update"/></td><td align="justify"><input type="reset" value="Reset"/></td></tr>
    </table>
  </form:form><br/>
 </div>

</body> 
</html>
