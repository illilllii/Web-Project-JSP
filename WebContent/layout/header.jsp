<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>EDIYA COFFEE</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/ediya/assets/img/favicon.ico" rel="icon">
<link href="/ediya/assets/img/apple-touch-icon.png"
	rel="apple-touch-icon">


<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/ediya/assets/css/fonts.css">

<!-- Vendor CSS Files -->
<link href="/ediya/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/ediya/assets/vendor/icofont/icofont.min.css"
	rel="stylesheet">
<link href="/ediya/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link
	href="/ediya/assets/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="/ediya/assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="/ediya/assets/vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/ediya/assets/css/style.css" rel="stylesheet">


<!-- User CSS -->
<link href="/ediya/assets/css/joinForm.css" rel="stylesheet">
<link href="/ediya/assets/css/loginForm.css" rel="stylesheet">
<link href="/ediya/assets/css/myPage.css" rel="stylesheet">
<link href="/ediya/assets/css/editPage.css" rel="stylesheet">


<link href="/ediya/assets/css/notice.css" rel="stylesheet">

<link rel="stylesheet"
	href="/ediya/assets/css/summernote/summernote-lite.css">





<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script src="/ediya/assets/vendor/jquery/jquery.als-2.1.min.js"></script>


<script src="/ediya/assets/vendor/summernote/summernote-lite.js"></script>
<script src="/ediya/assets/vendor/summernote/lang/summernote-ko-KR.js"></script>


<!-- =======================================================
  * Template Name: BizLand - v1.2.0
  * Template URL: https://bootstrapmade.com/bizland-bootstrap-business-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>
	<!-- ======= Top Bar ======= -->
	<div id="topbar" class="d-none d-lg-flex align-items-center fixed-top">
		<div class="container">
			<div class="contact-info d-flex justify-content-end">
				<!-- <a href="mailto:contact@example.com">contact@example.com</a> -->
				<c:choose>
					<c:when test="${sessionScope.principal != null}">
						<div class="topbar__submenu">
							<a class="topbar__submenu__login"
								href="<%=request.getContextPath()%>/user?cmd=myPage">My page</a>
							<a class="topbar__submenu__login" style="margin-left: 10px;"
								href="<%=request.getContextPath()%>/user?cmd=logout"> 로그아웃</a> <a
								class="topbar__submenu__join" style="margin-left: 10px;">매장찾기</a>

							<c:if test="${sessionScope.principal.userRole eq 'MENUADMIN'}">
								<a class="topbar__submenu__admin-menu"
									href="<%=request.getContextPath()%>/admin?cmd=menuList"
									style="margin-left: 10px;">메뉴관리</a>
							</c:if>
							<c:if test="${sessionScope.principal.userRole eq 'USERADMIN'}">
								<a class="topbar__submenu__admin-user"
									style="margin-left: 10px;"
									href="<%=request.getContextPath()%>/admin?cmd=userList">
									회원관리</a>
							</c:if>


						</div>
					</c:when>
					<c:otherwise>
						<div class="topbar__submenu">
							<a class="topbar__submenu__login"
								href="<%=request.getContextPath()%>/user?cmd=loginForm">로그인</a>
							<a class="topbar__submenu__login" style="margin-left: 10px;"
								href="<%=request.getContextPath()%>/user?cmd=joinForm"> 회원가입</a>
							<a class="topbar__submenu__join" href="">매장찾기</a>

						</div>
					</c:otherwise>
				</c:choose>

				<div class="social-links">
					<a href="#" class="twitter"><i class="icofont-twitter"></i></a> <a
						href="https://www.facebook.com/iEDIYA" class="facebook"><i
						class="icofont-facebook"></i></a> <a
						href="https://www.instagram.com/ediya.coffee/" class="instagram"><i
						class="icofont-instagram"></i></a> <a
						href="https://www.youtube.com/channel/UCK45lxAV_92LqR2DcQCP8Qg?view_as=subscriber"
						class="youtube"><i class="icofont-youtube"></i></a> <a href="#"
						class="linkedin"><i class="icofont-linkedin"></i></a>
				</div>
			</div>
		</div>
	</div>

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top">
		<div class="container d-flex align-items-center">
			<div>
				<a href="/ediya/"><img src="/ediya/assets/img/top_logo.gif"></a>
			</div>

			<!-- Uncomment below if you prefer to use an image logo -->
			<!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt=""></a>-->

			<nav class="nav-menu d-none d-lg-block">
				<ul>
					<li class="drop-down"><a href="/ediya/menu/menu_intro.jsp">메뉴</a>
						<ul>
							<li><a href="/ediya/menu?cmd=drinks">음료</a></li>
							<li><a href="/ediya/menu?cmd=bakery">베이커리</a></li>
							<li><a href="/ediya/menu?cmd=snack">스낵</a></li>
							<li><a href="/ediya/menu?cmd=md">MD</a></li>

						</ul></li>
					<li><a href="#">이디야 멤버스</a></li>
					<li><a href="#">기프트카드</a></li>
					<li><a href="#">이디야커피랩</a></li>
					<li><a href="#">이디야컬쳐랩</a></li>

					<li class="drop-down"><a
						ref="/ediya/notice?cmd=noticeList&page=0">이디야 소식</a>
						<ul>
							<li><a href="/ediya/notice?cmd=noticeList&page=0">공지사항</a></li>
							<li><a href="/ediya/menu?cmd=event">이벤트</a></li>
							<li><a
								href="https://www.youtube.com/channel/UCK45lxAV_92LqR2DcQCP8Qg?view_as=subscriber">이디야
									유튜브</a></li>

							<li><a href="https://blog.naver.com/ediya-coffee">이디야
									블로그</a></li>
							<li><a href="https://www.instagram.com/ediya.coffee/">이디야
									인스타그램</a></li>
							<li><a href="https://www.facebook.com/iEDIYA">이디야 페이스북</a></li>
						</ul></li>

				</ul>
			</nav>
			<!-- .nav-menu -->

		</div>
	</header>
	<!-- End Header -->