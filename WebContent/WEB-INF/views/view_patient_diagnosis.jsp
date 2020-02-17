<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Management System</title>
<style>
#patientsdiagnosis {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#patientsdiagnosis td, #patientsdiagnosis th {
	border: 1px solid #ddd;
	padding: 8px;
}

#patientsdiagnosis tr:nth-child(even) {
	background-color: #f2f2f2;
}

#patientsdiagnosis tr:hover {
	background-color: #ddd;
}

#patientsdiagnosis th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>

</head>
<body>

	<div>
		<button type="submit" class="btn btn-primary"
			onclick="location.href = '${pageContext.request.contextPath}'">Home</button>
	</div>

	<div>
		<H2>Patient Diagnosis Details</H2>
	</div>

	<div>
		<table id="patientsdiagnosis">

			<thead>
				<tr>
					<th>Diagnosis Id</th>
					<th>Patient First Name</th>
					<th>Symptoms</th>
					<th>Diagnosis Provided</th>
					<th>Administered By</th>
					<th>Date Of Diagnosis</th>
					<th>Follow Up Required</th>
					<th>Date Of Follow Up</th>
					<th>Bill Amount</th>
					<th>Card Number</th>
					<th>Mode Of Payment</th>
					<th>Action</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${patientDiagnosisList.size() ==0}">
					<tr>
						<td colspan="13" style="text-align: center;">No Patient
							Diagnosis data to display</td>

					</tr>

				</c:if>
				<c:if test="${patientDiagnosisList.size() >0}">


					<c:forEach var="patientdiagnosis" items="${patientDiagnosisList}">
						<tr>
							<td>${patientdiagnosis.diagnosisId}</td>
							<td>${patientdiagnosis.patient.firstName}</td>
							<td>${patientdiagnosis.symptoms}</td>
							<%-- <td>${test.dateOfBirth}</td> --%>
							<td>${patientdiagnosis.diagnosisProvided}</td>
							<td>${patientdiagnosis.administeredBy}</td>
							<td>${patientdiagnosis.dateOfDiagnosis}</td>
							<td>${patientdiagnosis.followUpRequired}</td>
							<td>${patientdiagnosis.dateOfFollowUp}</td>
							<td>${patientdiagnosis.billAmount}</td>
							<td>${patientdiagnosis.cardNumber}</td>
							<td>${patientdiagnosis.modeOfPayment}</td>
							<td><a
								href="${pageContext.request.contextPath}/patientdiagnosis/getPatientDiagnosis/${patientdiagnosis.diagnosisId}">Edit</a></td>
							<td><a
								href="${pageContext.request.contextPath}/patientdiagnosis/deletePatientDiagnosis/${patientdiagnosis.diagnosisId}">Delete</a></td>
						</tr>

					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>