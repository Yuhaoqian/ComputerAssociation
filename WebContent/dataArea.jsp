<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>
<meta charset="utf-8">
<title>资料下载 - 计算机协会 - 江苏科技大学张家港校区</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Raleway:300,400,500,700,800|Montserrat:300,400,700"
	rel="stylesheet">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/magnific-popup/magnific-popup.css" rel="stylesheet">
<link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet">

<!-- Main Stylesheet File -->
<link href="css/homepage.css" rel="stylesheet">
<link href="css/dataarea.css" rel="stylesheet">
<link href="css/a.css" rel="stylesheet">
</head>

<body id="body">

	<!--==========================
    Top Bar
  ============================-->
	<!-- <section id="topbar" class="d-none d-lg-block">
    <div class="container clearfix">
      <div class="contact-info float-left">
        <i class="fa fa-envelope-o"></i> <a href="mailto:contact@example.com">name@websitename.com</a>
        <i class="fa fa-phone"></i> +1 2345 67855 22
      </div>
      <div class="social-links float-right">
        <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
        <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
        <a href="#" class="google-plus"><i class="fa fa-google-plus"></i></a>
        <a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a>
        <a href="#" class="instagram"><i class="fa fa-instagram"></i></a>
      </div>
    </div>
  </section> -->

	<!--==========================
    Header
  ============================-->
	<header id="header">
		<div class="container">

			<div id="logo" class="pull-left">
				<h1>
					<a href="#body" class="scrollto"><span>JUST</span>计算机协会</a>
				</h1>
				<!-- <a href="#body"><img src="img/logo.png" alt="" title="" /></a>-->
			</div>

			<nav id="nav-menu-container">
				<ul class="nav-menu">
					<li><a href="index.html" id="homepage">首页</a></li>
					<li><a href="about.html" id="aboutus">创作团队</a></li>
					<li class="menu-active"><a href="dataArea.jsp" id="data_area">文章专区</a></li>
					<li><a href="download.html" id="download_area">资料下载</a></li>
					<li><a href="Login.html" id="login1">登录/注册</a></li>

				</ul>
			</nav>
			<!-- #nav-menu-container -->
		</div>
	</header>
	<!-- #header -->
	<!--==========================
    Intro Section
  ============================-->
	<section id="intro">

		<div class="intro-content">
			<h2>
				<span>JUST</span><br>计算机协会欢迎您！！！
			</h2>
			<div>
				<a class="btn-get-started scrollto" id="login2" href="Login.html">加入我们</a>
			</div>
		</div>
		<div style="background-image: url('img/intro-carousel/hh.jpg');"></div>
	</section>
	<!-- #intro -->

	<main id="main">


		<div class="w clearfix">

			<div class="right">
				<button class="write" id="write">发布文章</button>
				<div class="categories">
					<div class="header">
						<h3>分类目录</h3>
					</div>

					<ul id="category-ul">
						<li><a href="#" class="category">C/C++</a></li>
						<li><a href="#" class="category">Java</a></li>
						<li><a href="#" class="category">Python</a></li>
						<li><a href="#" class="category">数据结构</a></li>
						<li><a href="#" class="category">数据库</a></li>
						<li><a href="#" class="category">机器学习</a></li>
						<li><a href="#" class="category">操作系统</a></li>
						<li><a href="#" class="category">组成原理</a></li>

					</ul>
				</div>
			</div>
			
			<!-- 文章集合 -->
			<ul id="article-ul">
			</ul>
			
			<div class="navigation">
				<div class="navi_links">

				
				</div>
			</div>
			<div id ='save-json'"></div>
		</div>
	</main>

	<!--==========================
    Footer
  ============================-->
	<footer id="footer">
		<div class="container">
			<div class="copyright">Copyright &copy; 2019.计算机协会 版权所有</div>
			<div class="credits"></div>
		</div>
	</footer>
	<!-- #footer -->

	<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

	<!-- JavaScript  -->
	<script src="lib/jquery/jquery.min.js"></script>
	<script src="lib/jquery/jquery-migrate.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/superfish/hoverIntent.js"></script>
	<script src="lib/superfish/superfish.min.js"></script>
	<script src="lib/wow/wow.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/magnific-popup/magnific-popup.min.js"></script>
	<script src="lib/sticky/sticky.js"></script>
	<script src="contact/jqBootstrapValidation.js"></script>
	<script src="contact/contact_me.js"></script>
	<script src="js/main.js"></script>
	<script src="js/index.js"></script>
	<script src="js/dataarea.js"></script>
</body>

</html>