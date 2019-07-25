<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <!-- Meta -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, maximum-scale=1.0, minimum-scale=1.0, initial-scale=1.0"/>
    <meta name="robots" content="index, follow"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <meta name="author" content=""/>
    <meta name="copyright" content=""/>

    <title>Singolo</title>

    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href=""/>

    <!-- CSS -->
    <link href="singolo-template/main.css" rel="stylesheet" type="text/css"/>
    <link href="singolo-template/css/nivo-slider.css" rel="stylesheet" type="text/css"/>
    <link href="singolo-template/css/nivotheme.css" rel="stylesheet" type="text/css"/>
    <link href="singolo-template/css/prettyPhoto.css" rel="stylesheet" type="text/css"/>


    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'/>

    <!-- JS -->
    <script type="text/javascript" src="singolo-template/js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="singolo-template/js/jquery.nivo.slider.pack.js"></script>
    <script type="text/javascript" src="singolo-template/js/jquery.quicksand.js"></script>
    <script type="text/javascript" src="singolo-template/js/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="singolo-template/js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="singolo-template/js/script.js"></script>
    <script type="text/javascript" src="singolo-template/js/custom.js"></script>

</head>

<body>

<!-- Header
    ============================= -->
<div id="header">
    <div class="inner">

        <!-- Logo -->
        <h1 class="logo left"><a href="#home">Singolo</a></h1><!-- .logo-->

        <!-- Nav Menu -->
        <ul class="nav-menu right">
            <li class="current"><a href="#home">home</a></li>
            <li><a href="#services">services</a></li>
            <li><a href="${pageContext.request.contextPath}/user/login">sign in</a></li>
        </ul><!-- .nav-menu-->

    </div><!-- .inner -->
</div><!-- #header -->
<!-- End Header -->


<!-- Slider
    ============================= -->
<div id="slider" class="theme-default">
    <div class="inner">

        <div class="nivo-slider nivoSlider">
            <a href=""><img src="singolo-template/images/slides/singolo-slide1.jpg" alt="#"/></a>
            <img src="singolo-template/images/slides/singolo-slide2.jpg" alt="#"/>
        </div>

    </div><!-- .inner -->
</div><!-- #slider -->
<!-- End Slider -->


<!-- Services
    ============================= -->
<div id="services">
    <div class="inner">

        <h2>Our Services</h2>
        <h3>Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum. Duis mollis, non commodo luctus, nisi
            erat porttitor ligula, eget lacinia odio sem nec elit. Fusce dapibus, tellus ac cursus commodo, tortor
            mauris condimentum nibh.</h3>

        <ul>
            <li>
                <span class="li_pen"></span>
                <h4>Custom Design</h4>
                <p>Curabitur vestibulum eget mauris quis laoreet. Phasellus in quam laoreet, viverra lacus ut, ultrices
                    velit.</p>
            </li>


            <li>
                <span class="li_bulb"></span>
                <h4>Inovative Ideas</h4>
                <p>Quisque luctus, quam eget molestie commodo, lacus purus cursus purus, nec rutrum tellus dolor id
                    lorem.</p>
            </li>


            <li>
                <span class="li_heart"></span>
                <h4>Love Is The Answer</h4>
                <p>Nulla sed nunc et tortor luctus faucibus. Morbi at aliquet turpis, et consequat felis. Quisque
                    condimentum.</p>
            </li>


            <li>
                <span class="li_phone"></span>
                <h4>Responsive Layout</h4>
                <p>Sed porttitor placerat rhoncus. In at nunc tellus. Maecenas blandit nunc ligula. Praesent elit
                    leo.</p>
            </li>


            <li>
                <span class="li_bubble"></span>
                <h4>24 / 7 Support</h4>
                <p>Vivamus vel quam lacinia, tincidunt dui non, vehicula nisi. Nulla a sem erat. Pellentesque egestas
                    venenatis lorem .</p>
            </li>


            <li>
                <span class="li_star"></span>
                <h4>Feel Like A Star</h4>
                <p>Quisque hendrerit purus dapibus, ornare nibh vitae, viverra nibh. Fusce vitae aliquam tellus.</p>
            </li>
        </ul>

    </div><!-- .inner -->
</div><!-- #services -->
<!-- End Services -->


</body>
</html>