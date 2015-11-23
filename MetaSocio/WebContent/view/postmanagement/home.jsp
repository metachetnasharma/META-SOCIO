
<!DOCTYPE html>
<%@page import="com.metasocio.model.postmanagement.PostManagement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.metasocio.model.usermanagement.User"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Vitality</title>
    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Retina.js - Load first for faster HQ mobile images. -->
    <script src="assets/js/plugins/retina/retina.min.js"></script>
    <!-- Font Awesome -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
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
<%@ page session="false"%>
     <%@ page errorPage="../../exception/error.jsp"%>
    <!-- Navigation -->
    <!-- Note: navbar-default and navbar-inverse are both supported with this theme. -->
    <nav class="navbar navbar-inverse navbar-fixed-top navbar-expanded">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll hidden-sm"  href="#page-top">
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
                        <a class="page-scroll" href="#about">What is Meta-Socio</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#process">Learn More</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#work">Pricing</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#pricing">Log-in</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Business Benefits</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <section id="about">
        <div class="container-fluid">
        <form action="AddPost" method="post">
            <div class="row text-center">
                <div class="col-lg-8 col-lg-offset-2 wow fadeIn">
                    <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label>Tell everybody what are you working on. </label>
                               <input type="text" class="form-control"  placeholder="Tell everybody what are you working on" name="post" required data-validation-required-message="Please enter your role.">
                    </div>
            	</div>
            </div>
            <div class="row text-right">
                    <div class="col-lg-8 col-lg-offset-2 wow fadeIn">
                    <div class="form-group col-xs-12">
                           <input type="submit" class="btn btn-outline-dark" value="Share"/>
                    </div>
                    </div>
                    
            </div>
            </form>
            <div class="row content-row">
                <div class="col-md-3 col-sm-6 wow fadeIn" data-wow-delay=".2s">
                    <div class="about-content">
                        <h3>Groups</h3>
                        <div class="col-md-12" style="margin-bottom: 20px;">
                        <a class="btn btn-outline-dark" style="width: 100%;">Browse Groups</a>
                        </div>
                        <div class="col-md-12">
                        <a class="btn btn-outline-dark" style="width: 100%">Create Group</a>
                        </div>                        
                    </div>
                </div>
                
                
                
                
		 <!-- if(postList != null){
				for(PostManagement post:postList){
				   out.println("<tr>");
				  out.println("<td><img src='images/"+post.get()+"' alt='car image' width='300px' height='200px'></td>");
				   out.println("<td>");
				   out.println(vehicle.getMake());
				   out.println("<br/><br/>"); 
				   out.println(vehicle.getModel());
				   out.println("<br/><br/>");
				   out.println(vehicle.getPrice());
				   out.println("<br/><br/>");
				   out.println("<a href='/CaseStudy5/UserSearchResultController?vehicleId="+vehicle.getId()+"'> View Specifications </a>");
				   out.println("<br/><br/>");
				   out.println("<a href='/CaseStudy5/AdminEditController?vehicleId="+vehicle.getId()+"'> Edit Car </a>");
				   out.println("</td>");
				   out.println("</tr>");
				}
			}
			else{
				out.println("<tr><font size='20px' color='red'>Oops there is not any car in this catagory</font></tr>");
			} 
			%>
                 -->
                
                
                
                
                
                
                <div class="col-md-6 col-sm-6 wow fadeIn" data-wow-delay=".4s">
					
					
					<% List<PostManagement> postList = (List)request.getAttribute("postList"); 
					if(postList != null)
					{
						for(PostManagement post:postList){ %>
					
					
					<div class="row">
						<div class="col-md-2">
							<img src="assets/img/people/2.jpg" height="50px" width="50px">
						</div>
						<div class="col-md-10">
							<p>
								Name - <%=post.getCreated_by() %> <strong>date -  <%=post.getCreated_at() %></strong>
							</p>
							<h3>
								<strong><%=post.getPostDetails() %></strong>
							</h3>
							<button class="btn btn-outline-dark">like</button>
							<button class="btn btn-outline-dark">comment</button>
							<div class="col-md-12">
								<div class="row" id="comment" style="margin-top: 20px;background-color: #F2F2F2">
									<div class="col-md-2">
										<img src="assets/img/people/2.jpg" height="50px" width="50px">
									</div>
									<div class="col-md-10">
										<p>
											Name - <strong>date</strong> at <strong>time</strong> from <strong>place</strong>
										</p>
										<h3>
											<strong>Comment</strong>
										</h3>
										<button class="btn btn-outline-dark">like</button>
										<button class="btn btn-outline-dark">comment</button>
									</div>
								</div>

							</div>
						</div>
						</div>
						<%} %>
						<%} %>
	
				</div>
                <div class="col-md-3 col-sm-6 wow fadeIn" data-wow-delay=".8s">
                    <div class="about-content">
                        <i class="fa fa-heart fa-4x"></i>
                        <h3>Suggested People</h3>
                        <%User userObject=new User();
                        userObject=(User)request.getAttribute("userObject");
                      //  int id = (int)request.getAttribute("id"); 
                     HttpSession session=request.getSession(false);
                     session.setAttribute("userObject", userObject);
                      %>
                        <%// String email =(String) request.getAttribute("email");%>
                        <%List<User> usersOfSameDepartment =new ArrayList<User>(); 
                        usersOfSameDepartment=(List<User>)request.getAttribute("usersList"); 
                        if(usersOfSameDepartment.size()==1){
                        	%>
                        	<div class="col-md-12 col-lg12 col-sm-12 col-xs-12">No Suggestions</div>
                        	<%
                        }
                        else{
                        	 for(User userOfSameDepartment : usersOfSameDepartment){
                         		if(!userOfSameDepartment.getEmail_id().equalsIgnoreCase(userObject.getEmail_id())){
                        			   %>	
                        			    <div class="row" style="margin-bottom: 20px">
                        				<div class="col-md-8"><%=userOfSameDepartment.getName()%></div>
                        				<div class="col-md-4"><a href="AddFriend?userId=<%=userObject.getUser_id()%>&friendId=<%=userOfSameDepartment.getUser_id()%>"><button class="btn btn-sm btn-outline-dark">Add</button></a></div>
                        				</div>
                        <%		}
                        	}
                        }   %>
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
</body>

</html>
