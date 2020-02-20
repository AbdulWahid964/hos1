<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Physician</title>
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
<body>
 <div class="container">
<br/>
 <div class="home"></div><button type="submit" class="btn btn-primary" onclick="location.href = '${pageContext.request.contextPath}'">Home</button>
  </div>
  <h1 align="center">Add Physician</h1>
  <br/>
  
  <form:form action="/HospitalManagementXML/physician/savePhysician" method="post" commandName="physician">
<table align="center">
    <tr>
    	<td>Physician Id:</td>
    	<td><form:input path="physicianId"  cssClass="formInput" readonly="true"/></td>
    </tr>
     <tr>
    	<td>First Name:</td>
    	<td><form:input path="physicianFirstName"  cssClass="formInput" placeholder="Enter First Name"/></td>
    	<td><form:errors path="physicianFirstName"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Last Name:</td>
    	<td><form:input path="physicianLastName"  cssClass="formInput" placeholder="Enter Last named"/></td>
    	<td><form:errors path="physicianLastName"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Department:</td>
    	<td><form:select path="department"  cssClass="formInput">
    		<form:option value="diet" label="Diet" />
 			<form:option value="diet1" label="Diet1"/>
    	</form:select></td>
    	<td><form:errors path="department"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Year Of Experience:</td>
    	<td><form:input path="yearOfExperienceString"  cssClass="formInput" placeholder="20"/></td>
    	<td><form:errors path="yearOfExperienceString"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>State:</td>
    	<td><form:input path="state"  cssClass="formInput" placeholder="Odisha"/></td>
    	<td><form:errors path="state"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Insurance Plan:</td>
    	<td><form:input path="insurancePlan"  cssClass="formInput" placeholder="plan name"/></td>
    	<td><form:errors path="insurancePlan"  cssClass="formError"/></td>
    </tr>
    <tr><td align="right"><input type="submit" value="Submit"/></td><td align="left"><input type="reset" value="Reset"/></td></tr>
    </table>
 </form:form>
<%-- <form:form action="${pageContext.request.contextPath}/physician/savePhysician" method="post" commandName="physician">


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
    <button type="submit" class="btn btn-default">Submit</button>
 <button type="reset" class="btn btn-default">Reset</button>
    
  </form:form><br/> --%>
</div>
</body>
</html>