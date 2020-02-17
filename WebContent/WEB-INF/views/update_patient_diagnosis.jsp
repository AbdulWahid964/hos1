
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
		<h2>Patient Diagnosis</h2>
		<form:form
			action="${pageContext.request.contextPath}/patientdiagnosis/updatePatientDiagnosis"
			method="post" commandName="patientDiagnosis">
			<div class="form-group">
				<label for="diagnosis_id">Diagnosis Id:</label>
				<form:input path="diagnosisId" class="form-control" readonly="true"
					placeholder="Enter Diagnosis Id" />
			</div>
			<label>Patient</label>
			<form:select path="patient.patientId" class="form-control">
				<option value="">---Select---</option>
				<c:forEach items="${patientList}" var="patient">
					<form:option value="${patient.patientId}">${patient.firstName}</form:option>
				</c:forEach>
			</form:select>
			<br />
			<div class="form-group">
				<label for="symptoms">Symptoms:</label>
				<form:input path="symptoms" class="form-control"
					placeholder="Enter Symptoms " />
			</div>
			<div class="form-group">
				<label for="diagnosis_provided">Diagnosis Provided:</label>
				<form:input path="diagnosisProvided" class="form-control"
					placeholder="Enter Diagnosis Provided" />
			</div>

			<div class="form-group">
				<label for="administered_by">Administered By:</label>
				<form:input path="administeredBy" class="form-control"
					placeholder="Enter Administered By " />
			</div>
			<div class="form-group">
				<label for="date_of_Diagnosis">Date Of Diagnosis</label>
				<form:input class="form-control" path="dateOfDiagnosis"
					placeholder="Enter Date Of Diagnosis" />
			</div>

			<div class="form-group">
				<label for="follow_up_required">Follow Up Required</label>
				<form:input class="form-control" path="followUpRequired"
					placeholder="Enter Follow Up Required" />
			</div>


			<div class="form-group">
				<label for="dateOfFollowUp">Date Of FollowUp</label>
				<form:input path="dateOfFollowUp" class="form-control"
					placeholder="Enter Date Of FollowUp" />
			</div>

			<div class="form-group">
				<label for="bill_amount">Bill Amount</label>
				<form:input path="billAmount" class="form-control"
					placeholder="Enter Bill Amount" />
			</div>

			<div class="form-group">
				<label for="card_num">Card Number</label>
				<form:input path="cardNumber" class="form-control"
					placeholder="Enter Card Number" />
			</div>

			<div class="form-group">
				<label for="mode_pay">Mode Of Payment</label>
				<form:input path="modeOfPayment" class="form-control"
					placeholder="Enter Mode Of Payment" />
			</div>


			<button type="submit" class="btn btn-default">Update Patient</button>
		</form:form>
		<br />
	</div>

</body>
</html>
