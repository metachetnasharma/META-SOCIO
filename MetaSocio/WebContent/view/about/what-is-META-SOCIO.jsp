
<!DOCTYPE html>
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
                        <a class="page-scroll" href="#">What is Meta-Socio</a>
                    </li>
                   
                   
                  
                   <%HttpSession session=request.getSession(false);
            		
            		if(session==null){
            		%>
                    <li>
                        <a class="page-scroll" href="https://accounts.google.com/o/oauth2/auth?scope=email&amp;redirect_uri=http://localhost:8080/MetaSocio/OAuth&amp;response_type=code&amp;client_id=881126743057-0u1nhaqo1uk2dl0h0e9mpe3f9ptvmsa6.apps.googleusercontent.com&amp;approval_prompt=force&hd=metacube.com"">Log-in</a>
                    </li>
                    <%}else{ %>
                    
                      <li>
                        <a class="page-scroll" href="HomePage">Home</a>
                    </li>
                   
                   
                   
                    <li>
                        <a class="page-scroll" href="LogOut">Log Out</a>
                    </li>
                   <%} %>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <section id="about">
        <div class="container wow fadeIn">
            <div class="row">
                <div class="col-md-6">
                    <img src="assets/img/what-1.jpg" class="img-responsive" alt="">
                </div>
                <div class="col-md-6 text-center">
                    <h1>META-SOCIO</h1>
                    <hr class="colored">
                    <h3>WHERE TEAM WORK HAPPENS</h3>
                    <p>META-SOCIO is your company's private social network that helps you and your teams stay on top of it all. Start conversations, collaborate on files, and organize around projects so you can go further—faster.</p>
                    
                </div>
            </div>
        </div>
    </section>
    <section id="about">
        <div class="container wow fadeIn">
            <div class="row">
                <div class="col-md-6 text-center">
                    <h1>META-SOCIO</h1>
                    <hr class="colored">
                    <h3>BRING YOUR TEAM TOGETHER</h3>
                    <p>META-SOCIO makes it easy to quickly bring your team together so they can have conversations, collaborate on files, and more.</p>
                </div>
                <div class="col-md-6">
                    <img src="assets/img/what-2.jpg" class="img-responsive" alt="">
                </div>
            </div>
        </div>
    </section>	
    <section id="about">
        <div class="container wow fadeIn">
            <div class="row">
                <div class="col-md-6">
                    <img src="assets/img/what-3.jpg" class="img-responsive" alt="">
                </div>
                <div class="col-md-6 text-center">
                    <h1>META-SOCIO</h1>
                    <hr class="colored">
                    <h3>WORK SMARTER AND FASTER IN TEAMS</h3>
                    <p>META-SOCIO is built around open communication so team members can get up to speed, have greater context around the work they are doing, and make better decisions.</p>
                    
                </div>
            </div>
        </div>
    </section>
    
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
