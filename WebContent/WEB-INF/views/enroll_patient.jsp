<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1>Patient EnrollMent Form</H1>

<br/>

<form:form action="/HospitalManagementXML/patient/savePatient" method="post" commandName="patient">

<label>Patient Id</label><form:input path="patientId" readonly="true"/><br/>
<label>First Name</label><form:input path="firstName"/><br/>
<label>Last Name</label><form:input path="lastName"/><br/>
<label>Password</label><form:password path="password"/><br/>
<label>Date of Birth</label><form:input path="dateOfBirth"/><br/>
<label>Email Address</label><form:input path="emailAddress"/><br/>
<label>Contact Number</label><form:input path="contactNumber"/><br/>
<label>State</label><form:input path="state"/><br/>
<label>Insurance Plan</label><form:input path="insurancePlan"/><br/>

<input type="submit" value="Submit">

</form:form>

</body>
</html>