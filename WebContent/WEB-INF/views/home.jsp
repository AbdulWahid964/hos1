<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hospital Management</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
<link href="/HospitalManagementXML/Webcontent/resources/style.css" rel="stylesheet" type="text/css"/>
<style>
@CHARSET "ISO-8859-1";
a:hover, a:focus {
  color: #2a6496;
  text-decoration: none;
}
.square-service-block{
	position:relative;
	overflow:hidden;
	margin:15px auto;
	}
.square-service-block a {
  background-color: #e74c3c;
  border-radius: 5px;
  display: block;
  padding: 60px 30px;
  text-align: center;
  width: 100%;
}
.square-service-block a:hover{
  background-color: rgba(231, 76, 60, 0.8);
  border-radius: 5px;
}

.ssb-icon {
  color: #fff;
  display: inline-block;
  font-size: 28px;
  margin: 0 0 20px;
}

h2.ssb-title {
  color: #fff;
  font-size: 20px;
  font-weight: 200;
  margin:0;
  padding:0;
  text-transform: uppercase;
}

</style>
</head>
<body>

 <a href="/HospitalManagementXML/physician/addPhysician.html">PHYs</a>

<h1>Hospital Management</h1>
<div class="container">
       <div class="row">
        <div class="col-md-3">
            <div class="square-service-block">
               <a href="/HospitalManagementXML/patient/showPatient.html">
                 <div class="ssb-icon"><i class="fa-fa-user" aria-hidden="true"></i></div>
                 <h2 class="ssb-title">Enroll Patient</h2>  
               </a>
            </div>
          </div>
          
          <div class="col-md-3">
            <div class="square-service-block">
               <a href="/HospitalManagementXML/patientdiagnosis/showPatientDiagnosis.html">
                 <div class="ssb-icon"> <i class="fa fa-globe" aria-hidden="true"></i> </div>
                 <h2 class="ssb-title">Patient Diagnosis</h2>  
               </a>
            </div>
          </div>

</div>
</div>


</body>
</html>