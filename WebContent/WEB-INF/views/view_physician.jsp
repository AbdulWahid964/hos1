<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Management System</title>
<style>
#physician {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#physician td, #patients th {
  border: 1px solid #ddd;
  padding: 8px;
}

#physician tr:nth-child(even){background-color: #f2f2f2;}

#physician tr:hover {background-color: #ddd;}

#physician th {
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
<button type="submit" class="btn btn-primary" onclick="location.href = '${pageContext.request.contextPath}'">Home</button>
</div>
<div>
<H2>Physician Details</H2>
</div>
<div class="row">

 <form action="${pageContext.request.contextPath}/physician/viewPhysician">
         <button type="submit">Refresh</button>
      </form>
<br/>
<br/>

<form action="${pageContext.request.contextPath}/physician/searchPhysician" >
State:<input id="state"  name="state" class="form-control" value="${physician.state}" placeholder="Enter State"/>
   Insurance Plan: <input id="plan" name="plan" class="form-control" value="${physician.insurancePlan}" placeholder="Insurance Plan"/>
   Department: <input id="department"  name="department" class="form-control" value="${physician.department}" placeholder="Department"/>
	<input type="submit" value="Submit">
	<!-- <input type="reset" value="Reset"> -->

</form>


</div>
<br/>
<div>
<table id="physician">

		<thead>
			<tr>
				<th>Physician Id</th>
				<th>Physician First Name</th>
				<th>Physician Last Name</th>
			 	<th>Department</th>
				<th>Year Of Experience</th>
				<th>State</th>
				<th>Insurance Plan</th>
				<th>Action</th>
				<th >&nbsp;</th>
			</tr>
		</thead>
		<tbody>
	<c:if test="${physicianList.size() ==0}">
		<tr>			
			<td colspan ="9" style="text-align: center;">No Physician data to display</td>
	
				</tr>
		
		</c:if>
		<c:if test="${physicianList.size() >0}">
		
	
			<c:forEach var="physician" items="${physicianList}">
				<tr>
					<td>${physician.physicianId}</td>
					<td>${physician.physicianFirstName}</td>
					<td>${physician.physicianLastName}</td>
					<td>${physician.department}</td>
					<td>${physician.yearOfExperience}</td>
					<td>${physician.state}</td>
					<td>${physician.insurancePlan}</td>
					<td><a
						href="${pageContext.request.contextPath}/physician/getPhysician/${physician.physicianId}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/physician/deletePhysician/${physician.physicianId}">Delete</a></td>
				</tr>
				
			</c:forEach>
</c:if>
		</tbody>
	</table>
	</div>
</body>
</html>