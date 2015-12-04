
<!DOCTYPE html>
<%@page import="com.metasocio.model.usermanagement.GooglePojo"%>
<%@ page import="java.io.*,java.util.*" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>:: META-SOCIO ::</title>
    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Retina.js - Load first for faster HQ mobile images. -->
    <script src="assets/js/plugins/retina/retina.min.js"></script>
    <!-- Font Awesome -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <link href="assets/css/bootstrap/bootstrap-datepicker3.css" rel="stylesheet" type="text/css">
    <!-- Default Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,600,500,700,800,900' rel='stylesheet' type='text/css'>
    <!-- Modern Style Fonts (Include these is you are using body.modern!) -->
    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Cardo:400,400italic,700' rel='stylesheet' type='text/css'>
    <!-- Vintage Style Fonts (Include these if you are using body.vintage!) -->
    <link href='http://fonts.googleapis.com/css?family=Sanchez:400italic,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Cardo:400,400italic,700' rel='stylesheet' type='text/css'>
    <!-- Plugin CSS -->
    <link href="assets/css/plugins/owl-carousel/owl.carousel.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/owl-carousel/owl.theme.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/owl-carousel/owl.transitions.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/magnific-popup.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/background.css" rel="stylesheet" type="text/css">
    <link href="assets/css/plugins/animate.css" rel="stylesheet" type="text/css">
    <link id="changeable-colors" rel="stylesheet" href="assets/css/vitality-red.css">
    <link href="assets/demo/style-switcher.css" rel="stylesheet">
    <!-- IE8 support for HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>


<body id="page-top">
     <%@ page errorPage="../../exception/error.jsp"%>
    <!-- Navigation -->
    <!-- Note: navbar-default and navbar-inverse are both supported with this theme. -->
    <nav class="navbar navbar-inverse navbar-fixed-top navbar-expanded" style="background-color: black">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll hidden-sm"  href="HomePage">
                    <img src="assets/img/logo.png" class="img-responsive hidden-sm" alt="">
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a class="page-scroll" href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="what-is-META-SOCIO.jsp">What is Meta-Socio</a>
                    </li>
                    
                    <li>
                        <a class="page-scroll" href="#pricing">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
   <section id="contact">
        <div class="container wow fadeIn">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Profile Information</h2>
                    <hr class="colored">
                </div>
            </div>
            
            <div class="row content-row">
             <form name="sentMessage" action="CreateUserProfile" id="contactForm" method="post">
                <div class="col-lg-8">
                   
                    <%
                   
                    
                    
                    GooglePojo userDataObject=new GooglePojo();
                    userDataObject=(GooglePojo)request.getAttribute("userDataObject") ;
                    session.setAttribute("userProfile", userDataObject);
                    
                   
                    %>
					


						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseOne">1. Personal Info</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in">
									<div class="panel-body">
										<div class="row control-group">
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Name</label>
												 
												 <input type="text" class="form-control" required = "required"
													style="background-color: transparent; font-weight: bolder;" value="<%=userDataObject.getName()%>" 
													
													<%
														if(userDataObject.getName().equalsIgnoreCase(" ")){
															%>readonly<%		
														}
														%>
													
													
													
													placeholder="Name" name="name" required="required">
												<p class="help-block text-danger"></p>
											</div>
											<div
												class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Email Address</label> <input type="email"
													class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Email Address"
													value="<%=userDataObject.getEmail()%>" name="email"
													readonly="readonly">
												<p class="help-block text-danger"></p>
											</div>
										</div>
										
										
										
										<div class="row control-group">
											<div class="form-group col-xs-12 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Address</label> <input type="text" class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Address" name="address">
												<p class="help-block text-danger"></p>
											</div>
										</div>
										
										<div class="row control-group">
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Phone Number</label> <input type="number" class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Phone Number" name="phoneNumber">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>City</label> <input type="text"
													class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="City" name="city">
												<p class="help-block text-danger"></p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseTwo" style="color:orangered">2. Work and Education (Compulsory)</a>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse">
									<div class="panel-body">
										<div class="row control-group">
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Department</label> <input type="text" class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Department" name="department" required="required">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Role</label> <input type="text"
													class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Role" name="role" required="required">
												<p class="help-block text-danger"></p>
											</div>
										</div>
										 <input type="hidden" value="<%=userDataObject.getPicture()%>" name="picture">
										<div class="row control-group">
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>College</label> <input type="text" class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="College" name="college">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Course</label> <input type="text"
													class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Course" name="course">
												<p class="help-block text-danger"></p>
											</div>
										</div>
										
										
										<div class="row control-group">
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>High School</label> <input type="text" class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="High School" name="highSchool">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Stream</label> <input type="text"
													class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Stream" name="stream">
												<p class="help-block text-danger"></p>
											</div>
										</div>
										
										
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseThree">3. Basic Info</a>
									</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse">
									<div class="panel-body">
										<div class="row control-group">
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1;height: 100px">
												<label>Date Of Birth</label>
												<div id="sandbox-container">
													<input class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Date Of Birth" type="text" name="dateOfBirth">
												</div>
											</div>
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1;height: 100px">
												<label>Gender</label> 
												<div class="row" style="padding-left: 20px;margin: 0px;">
													<div class="col-xs-6" >
														<div class="radio">
															<input type="radio" name="gender" value="male">Male
														</div>
													</div>
													<div class="col-xs-6" >
														<div class="radio">
															<input type="radio" name="gender" value="female">Female
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="panel panel-default">
							 <input type="hidden" name="picture" value="<%=userDataObject.getPicture()%>">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapseFour">4. Details About You</a>
									</h4>
								</div>
								<div id="collapseFour" class="panel-collapse collapse">
									<div class="panel-body">
										
											<div class="row control-group">
											<div class="form-group col-xs-12 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>About You</label> <textarea class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Write Something about yourself" name="about">
												</textarea>
											</div>
										</div>
										
										<div class="row control-group">
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Nick Name</label> <input type="text" class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Nick Name" name="nickName">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group col-xs-6 floating-label-form-group controls" style="border-left:1px solid #e1e1e1;border-right:1px solid #e1e1e1">
												<label>Relationship Status</label> <input type="text"
													class="form-control"
													style="background-color: transparent; font-weight: bolder;"
													placeholder="Relationship Status" name="relationship">
												<p class="help-block text-danger"></p>
											</div>
										</div>
										</div>
									</div>
								</div>
							</div>
						
						<div class="col-lg-12">
            			<input type="submit" class="btn btn-outline-dark" value="Save">
            			</div>
						</form>
						</div>
						
						<div class="col-lg-4">
                			<div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                
                               <img class="img-responsive" src="<%=userDataObject.getPicture()%>" >
								
								<form action="PhotoUpload" method="post" enctype="multipart/form-data">
										<input type="file" name="file" size="50" />
										<br />
										<input type="submit" value="Upload File" />
								</form>
                            </div>
                        </div>
                		</div>
                		
                		
                		
            
            </div>
           
    </section>
    
   
    <!-- End Style Switcher -->
    <!-- Core Scripts -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap/bootstrap.min.js"></script>
        
    
    <!-- Plugin Scripts -->
    
    <script src="assets/js/bootstrap/bootstrap-datepicker.min.js"></script>
    <script src="assets/js/plugins/jquery.easing.min.js"></script>
    <script src="assets/js/plugins/classie.js"></script>
    <script src="assets/js/plugins/cbpAnimatedHeader.js"></script>
    <script src="assets/js/plugins/owl-carousel/owl.carousel.js"></script>
    <script src="assets/js/plugins/jquery.magnific-popup/jquery.magnific-popup.min.js"></script>
    <script src="assets/js/plugins/background/core.js"></script>
    <script src="assets/js/plugins/background/transition.js"></script>
    <script src="assets/js/plugins/background/background.js"></script>
    <script src="assets/js/plugins/jquery.mixitup.js"></script>
    <script src="assets/js/plugins/wow/wow.min.js"></script>
    <script src="assets/js/contact_me.js"></script>
    <script src="assets/js/plugins/jqBootstrapValidation.js"></script>
    <!-- Vitality Theme Scripts -->
    <script src="assets/js/vitality.js"></script>
    <!-- Style Switcher Scripts - Demo Purposes Only! -->
    <script src="assets/demo/style.switcher.js"></script>
    
    
    <script type="text/javascript">
    $('#sandbox-container input').datepicker({
        autoclose: true
    });
        </script>
</body>

</html>
