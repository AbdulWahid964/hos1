<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Management System</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.formError {
	color: red;
}
</style>
</head>
<body>

<br/>

 <div class="container">
<br/>
 <button type="submit" class="btn btn-primary" onclick="location.href = '${pageContext.request.contextPath}'">Home</button>
  <h2>Patient Diagnosis Form</h2>
  <form:form action="/HospitalManagementXML/patientdiagnosis/savePatientDiagnosis" method="post" commandName="patientDiagnosis">


<table>
    <tr>
    	<td>Diagnosis Id:</td>
    	<td><form:input path="diagnosisId"  cssClass="formInput" readonly="true"/></td>
    </tr>
    <tr>
    	<td>Patient:</td>
    	<td><form:select path="patient.patientId">
    		<option value="">---Select---</option>
          	<c:forEach  items="${patientlist}" var="patient">
          	<form:option value="${patient.patientId}">${patient.firstName}</form:option>
        	</c:forEach>
		</form:select></td>
    </tr>
     <tr>
    	<td>Symptoms:</td>
    	<td><form:input path="symptoms"  cssClass="formInput" placeholder="Enter symptom"/></td>
    	<td><form:errors path="symptoms"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Diagnosis Provided:</td>
    	<td><form:input path="diagnosisProvided"  cssClass="formInput" placeholder="diagnose details"/></td>
    	<td><form:errors path="diagnosisProvided"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Administered By:</td>
    	<td><form:input path="administeredBy"  cssClass="formInput" placeholder="enter here"/></td>
    	<td><form:errors path="administeredBy"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>Date Of Diagnosis:</td>
    	<td><form:input path="dateOfDiagnosisString"  cssClass="formInput" placeholder="yyyy/mm/dd"/></td>
    	<td><form:errors path="dateOfDiagnosisString"  cssClass="formError"/></td>
    </tr>
     <tr>
    	<td>followUp Required:</td>
    	<td><form:input path="followUpRequired"  cssClass="formInput" placeholder="enter here"/></td>
    	<td><form:errors path="followUpRequired"  cssClass="formError"/></td>
    </tr>
         <tr>
    	<td>Date Of FollowUp:</td>
    	<td><form:input path="dateOfFollowUpString"  cssClass="formInput" placeholder="yyyy/mm/dd"/></td>
    	<td><form:errors path="dateOfFollowUpString"  cssClass="formError"/></td>
    </tr>
         <tr>
    	<td>Bill Amount:</td>
    	<td><form:input path="billAmount"  cssClass="formInput" placeholder="0.0"/></td>
    	<td><form:errors path="billAmount"  cssClass="formError"/></td>
    </tr>
         <tr>
    	<td>Card Number:</td>
    	<td><form:input path="cardNumber"  cssClass="formInput" placeholder="16 digit card number"/></td>
    	<td><form:errors path="cardNumber"  cssClass="formError"/></td>
    </tr>
         <tr>
    	<td>Mode Of Payment:</td>
    	<td><form:input path="modeOfPayment"  cssClass="formInput" placeholder="Online"/></td>
    	<td><form:errors path="modeOfPayment"  cssClass="formError"/></td>
    </tr>
    <tr><td><input type="submit" value="Submit"/></td><td><input type="reset" value="Reset"/></td></tr>
    </table>
    </form:form> 
<%-- <form:form action="${pageContext.request.contextPath}/patientdiagnosis/savePatientDiagnosis" method="post" commandName="patientDiagnosis">

    <div class="form-group">
      <label for="diagnosis_id">Diagnosis Id:</label>
      <form:input path="diagnosisId"  class="form-control" readonly="true" placeholder="Enter Diagnosis Id"/>
    </div>
     <label>Patient</label><form:select path="patient.patientId" class="form-control">   
<option value="">---Select---</option>
          	<c:forEach  items="${patientlist}" var="patient">
          	<form:option value="${patient.patientId}">${patient.firstName}</form:option>
        	</c:forEach>
</form:select><br/>
    
    <div class="form-group">
      <label for="symptoms">Symptoms:</label>
		<form:input path="symptoms"  class="form-control" placeholder="Enter Symptoms "/>
</div>
 <div class="form-group">
      <label for="diagnosis_provided">Diagnosis Provided:</label>
		<form:input path="diagnosisProvided"  class="form-control" placeholder="Enter Diagnosis Provided"/>
    </div>
    
    <div class="form-group">
      <label for="administered_by">Administered By:</label>
		<form:input path="administeredBy"  class="form-control" placeholder="Enter Administered By "/>
    </div>
    <div class="form-group">
      <label for="date_of_Diagnosis">Date Of Diagnosis</label>
	<form:input class="form-control" path="dateOfDiagnosis" placeholder="Enter Date Of Diagnosis"/>
    </div>
    
    <div class="form-group">
      <label for="follow_up_required">Follow Up Required</label>
	<form:input class="form-control" path="followUpRequired" placeholder="Enter Follow Up Required"/>
    </div>
    
    
    <div class="form-group">
      <label for="dateOfFollowUp">Date Of FollowUp</label>
      <form:input path="dateOfFollowUp"  class="form-control"  placeholder="Enter Date Of FollowUp"/>
    </div>
    
    <div class="form-group">
      <label for="bill_amount">Bill Amount</label>
      <form:input path="billAmount"  class="form-control" placeholder="Enter Bill Amount"/>
    </div>
    
    <div class="form-group">
      <label for="card_num">Card Number</label>
      <form:input path="cardNumber"  class="form-control"  placeholder="Enter Card Number"/>
    </div>
    
  <div class="form-group">
      <label for="mode_pay">Mode Of Payment</label>
      <form:input path="modeOfPayment"  class="form-control"  placeholder="Enter Mode Of Payment"/>
    </div>
    
  
    <button type="submit" class="btn btn-default">Submit</button>
	<button type="reset" class="btn btn-default">Reset</button>
    
  </form:form><br/> --%>
</div>
 
 
</body>
</html>