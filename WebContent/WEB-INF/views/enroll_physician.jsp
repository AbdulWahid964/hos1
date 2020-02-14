<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Physican Enrollement form</h1>

<form:form action="/HospitalManagementXML/physician/savePhysician" method="post" commandName="physician">

<label>Physician Id</label><form:input path="physicianId" readonly="true"/><br/>
<label>First Name</label><form:input path="physicianFirstName"/><br/>
<label>Last Name</label><form:input path="physicianLastName"/><br/>
<label>Department</label> 
<form:select path="department" >
 <form:option value="diet" label="Diet" />
 <form:option value="diet1" label="Diet1" />
 </form:select>

<label>Year Of Experience</label><form:input path="yearOfExperience"/><br/>
<label>State</label><form:input path="state"/><br/>
<label>Insurance Plan</label><form:input path="insurancePlan"/><br/>

<input type="submit" value="Submit">
<input type="reset" value="Reset">

</form:form>

</body>
</html>