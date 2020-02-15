<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Hospital Management System</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
 <style type="text/css">
  <%@include file="/resources/style.css" %>
</style>
 
    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>
</head>

<body>
    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>Hospital Management System</h3>
            </div>
            <ul class="list-unstyled components">

                <li>
                    <a href="${pageContext.request.contextPath}/showHome">Home</a>
                </li>
                <li class="active">

                 
                    <a href="#patientSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Patient</a>
                    <ul class="collapse list-unstyled" id="patientSubmenu">
                        <li>
                            <a href="${pageContext.request.contextPath}/patient/showPatient">Enroll Patient</a>
						</li>
                        <li>
                            <a href="${pageContext.request.contextPath}/patient/viewPatient">View Patient</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#physicianSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Physician</a>
                    <ul class="collapse list-unstyled" id="physicianSubmenu">
                        <li>
                            <a href="${pageContext.request.contextPath}/physician/showPhysician">Add Physician</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/physician/editPhysician">View Physician</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#patientDiagnosisSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Patient Diagnosis</a>
                    <ul class="collapse list-unstyled" id="patientDiagnosisSubmenu">
                        <li>
                             <a href="${pageContext.request.contextPath}/patientdiagnosis/showPatientDiagnosis" >Add Patient Diagnosis</a> 
                          
                       
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}//patientdiagnosis/editPatientDiagnosis">View Patient Diagnosis</a>
                        </li>
                    </ul>
                </li>
            </ul>
                    </nav>

        <!-- Page Content  -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                        <span>Toggle Sidebar</span>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>
 <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item active">
                                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                            </li>
                            
                        </ul>
                    </div>
                                    </div>
            </nav>

            <h2>Hosiptal Management</h2>
            <p>Physician</p>
            <p>The IT system has revolutionised the field of medicine. In this fast-paced world of medicine, it is a daunting task to manage a multi-speciality hospital. A hospital management system (HMS) is a computer or web based system that facilitates managing the functioning of the hospital or any medical set up1. This system or software will help in making the whole functioning paperless. It integrates all the information regarding patients, doctors, staff, hospital administrative details etc. into one software4. It has sections for various professionals that make up a hospital.</p>
            
            <div class="line"></div>

            <h2>Patient</h2>
            <p>New patients can be registered in the system. An electronic medical record system is in-built which stores all the basic and medical details of the patient2. One can also add a feature to store photos of the patients as identity proof which can also help in medico-legal cases of false identities or fraud</p>

            
    </div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>

</html>