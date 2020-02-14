<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1>Patient Diagnosis Form</H1>

<br/>

<form:form action="/HospitalManagementXML/patientdiagnosis/savePatientDiagnosis" method="post" commandName="patientDiagnosis">

<label>Diagnosis Id</label><form:input path="diagnosisId" readonly="true"/><br/>
 <label>Patient</label><form:select path="patient.patientId">   
<option value="">---Select---</option>
          	<c:forEach  items="${patientlist}" var="patient">
          	<form:option value="${patient.patientId}">${patient.firstName}</form:option>
        	</c:forEach>
</form:select><br/>
<label>Symptoms</label><form:input path="symptoms"/><br/>
<label>Diagnosis Provided</label><form:input path="diagnosisProvided"/><br/>
<label>Administered By</label><form:input path="administeredBy"/><br/>
<label>Date Of Diagnosis</label><form:input path="dateOfDiagnosis"/><br/>
<label>followUp Required</label><form:input path="followUpRequired"/><br/>
<label>Date Of FollowUp</label><form:input path="dateOfFollowUp"/><br/>
<label>Bill Amount</label><form:input path="billAmount"/><br/>
<label>Card Number</label><form:input path="cardNumber"/><br/>
<label>Mode Of Payment</label><form:input path="modeOfPayment"/><br/>

<input type="submit" value="Submit">

</form:form>

</body>
</html>