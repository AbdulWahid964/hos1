<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Management System</title>
<style>
#patients {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#patients td, #patients th {
  border: 1px solid #ddd;
  padding: 8px;
}

#patients tr:nth-child(even){background-color: #f2f2f2;}

#patients tr:hover {background-color: #ddd;}

#patients th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>

</head>
<body>
<a href="${pageContext.request.contextPath}"/>Home</a> 

<div>
<H2>Patient Details</H2>
</div>

<div>
<table id="patients">

		<thead>
			<tr>
				<th>Patient Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<!-- <th>Date Of Birth</th> -->
			
		 	<th>Email Address</th>
				<th>Contact Number</th>
				<th>State</th>
				<th>Insurance Plan</th>
				<th>Action</th>
				<th >&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="patient" items="${patientList}">
				<tr>
					<td>${patient.patientId}</td>
					<td>${patient.firstName}</td>
					<td>${patient.lastName}</td>
					<%-- <td>${test.dateOfBirth}</td> --%>
					<td>${patient.emailAddress}</td>
					<td>${patient.contactNumber}</td>
					<td>${patient.state}</td>
					<td>${patient.insurancePlan}</td>
					<td><a
						href="${pageContext.request.contextPath}/patient/getPatient/${patient.patientId}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/patient/deletePatient/${patient.patientId}">Delete</a></td>
				</tr>
				
			</c:forEach>

		</tbody>
	</table>
	</div>
</body>
</html>