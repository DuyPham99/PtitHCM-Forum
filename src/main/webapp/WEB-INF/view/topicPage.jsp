<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>PTIT-HCM: Diễn đàn trao đổi học tập!!</title>
  <!-- Import Boostrap css, js, font awesome here -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
  <link href="custom.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
  </script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
  </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <link href="http://localhost:8000/resources/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
    integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <base href="http://localhost:8000/"/>
  </head>

<body style="background:#f2f2f2;">
  <!-- Navigation & Header -->
  <header>
    <div class="container-fluid bg-white">
      <div class="row text-center border-bottom">
        <div class="col text-right">
          <a href="#"><img src="images/ptitLogo.jpg" height="70" class="logo" width="270"
              style="width: 30%;"></a>
        </div>

        <div class="col-6">
          <a href="#"><i class="fa fa-search"></i></a>
          <input class="header-search" size="40" type="text" placeholder="Tìm kiếm bài viết, tác giả,..."
            aria-label="Search">
        </div>
        <div class="col align-self-center">
          <a href="#" class="text-header"> Đăng ký </a>
          <a href="#" class="ml-5 text-header"> Đăng nhập</a></div>
      </div>
    </div>

  </header>
  <nav class="navbar navbar-expand-sm navbar-dark sticky-top bg-white header p-auto">
    <div class="container">
      <ul class="nav col-md-12 nav-bar text-header" style="color: black;">
        <li class="nav-item"><a class="nav-link py-0" href="/topic/1/1">Hoạt
          động</a></li>
      <li class="nav-item"><a class="nav-link py-0" href="/topic/2/1">Học
          tập</a></li>
      <li class="nav-item"><a class="nav-link py-0" href="/topic/3/1">Đội
          - Nhóm</a></li>
      <li class="nav-item"><a class="nav-link py-0" href="/topic/4/1">Chuyện
          trò - tâm sự</a></li>
      <li class="nav-item"><a class="nav-link py-0" href="/topic/5/1">Chia
          sẻ kinh nghiệm</a></li>
      <li class="nav-item"><a class="nav-link py-0" href="/topic/6/1">Khác</a></li>
      </ul>
    </div>
    </div>
  </nav>
  <!--Start: Banner-->
  <div class="container ">
    <div id="demo" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
      </ul>

      <!-- The slideshow -->
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="https://spiderum.com/assets/images/banner/cover-spiderum-not-login.jpg" alt="Los Angeles"
            width="1100" height="300">
          <div class="carousel-caption">
            <h3>Los Angeles</h3>
            <p>We had such a great time in LA!</p>
          </div>
        </div>
        <div class="carousel-item">
          <img src="https://spiderum.com/assets/images/banner/cover-spiderum-not-login.jpg" alt="Chicago" width="1100"
            height="500">
          <div class="carousel-caption">
            <h3>Los Angeles</h3>
            <p>We had such a great time in LA!</p>
          </div>
        </div>
        <div class="carousel-item">
          <img src="https://spiderum.com/assets/images/banner/cover-spiderum-not-login.jpg" alt="New York" width="1100"
            height="500">
          <div class="carousel-caption">
            <h3>Los Angeles</h3>
            <p>We had such a great time in LA!</p>
          </div>
        </div>
      </div>

      <!-- Left and right controls -->
      <a class="carousel-control-prev" href="#demo" data-slide="prev">
        <span class="carousel-control-prev-icon"></span>
      </a>
      <a class="carousel-control-next" href="#demo" data-slide="next">
        <span class="carousel-control-next-icon"></span>
      </a>
    </div>
  </div>
  <!--End: Banner-->
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-3 mt-3">
        <div class="container sticky">
          <!--navigation-->
          <ul class="nav flex-column nav-pills" style="float: right;">
            <li class="nav-item">
              <a class="nav-link disabled" href="#"><i class="fab fa-hotjar" style="margin-right: 2px;"> </i> Nổi
                bật</a>
            </li>
            <li class="nav-item ">
              <a class="nav-link disabled" href="#"><i class="far fa-newspaper" style="margin-right: 4px;"> </i>Mới
                nhất</a>
            </li>

            <li class="nav-item ">
              <a class="nav-link active" href="#"><i class="fas fa-heartbeat" style="margin-right: 6px;"> </i>Sôi
                nổi</a>
            </li>
            <li class="nav-item ">
              <a class="nav-link disabled" href="#"><i class="fas fa-crown" style="margin-right: 3px;"> </i>Thịnh
                hành</a>
            </li>
          </ul>
        </div>
      </div>
      <div class="col-md-6 p-0">
      <c:forEach var="post" items="${list}">
        <!--Start: new feed-->
        <ul class="nav flex-column">
          <li class="nav-item">
            <div class="container">
              <div class="position-relative border new-feed">
                <div class="author-feed">
                  <div class="account">
                    <img
                      src="data:image/jpeg;base64,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"
                      alt="Icon Account"
                      style="float:left;width:40px;height:40px;margin-top: 2px; margin-right: 5px; margin-left: 3px;"
                      class="rounded-circle">
                    <a href="#" style="float:left;"><b>${post.user.username}</b>&nbsp</a>
                    <p style="display: inline; color: #99A3AD;">trong</p>
                    <a href="#" class="topic-title" style="color:#2C3E50;">${category}</a>
                    <p style="margin-bottom: 0px; color: #828b94;">${post.timeCreate}</p>
                  </div>
                </div>
                <div class="img-thumbnail ">
                  <a href="#">
                    <img style="width: 100%; margin-top: 15px;"
                      src="${post.thumb}"
                      width="674" height="280">
                  </a>
                </div>
                <div class="content">
                  <div class="text">
                    <!--Start:Title-->
                    <h5 class="title">
                      <a href="#" style="color: #2C3E50;" class="show-large"> ${post.title} </a>
                    </h5>
                    <!--End:Title-->
                    <a href="" class="body">
                      <h6 style="color: #293847;"></h6>
                    </a>
                    <!--Start:author-->
                    <a href="#">
                    </a>
                    <!--End : Author-->
                  </div>
                </div>
                <div class="toolbar">
                  <div class="" style="float: left;">
                    <a href="" style="color: #293847;"><i onclick="myFunction(this)" class="fas fa-heart"></i></a>

                  </div>
                  <div class="" style="float: right;">
                    <a href=""><i class="fas fa-comments" style="color: #293847;"></i> </a>

                    <a href="#"><i class="fas fa-eye" style="color: #293847;"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </li>
        </ul>
        <!--End: new feed-->
	</c:forEach>
     
        
      </div>
      <div class="col-md-3">

      </div>
    </div>
    <div class="d-flex justify-content-center mr-6" style="margin-right: 151px;">
      <div class="pagination ">
        <a href="#">&laquo;</a>
        <c:forEach begin="1" end="${amountOfPage}" varStatus="loop">
        <a href="/topic/${list.get(0).getCategory()}/${loop.count}">${loop.count}</a>
        </c:forEach>
        <a href="#">&raquo;</a>
      </div>
      <!-- End: Pagination-->
    </div>
    <div class="container" style="font-size: 10px;">
      <hr>
      <p>Học viện Công nghệ Bưu chính - TP.HCM</p>
      <p>Địa chỉ 1: Quận 1</p>
      <p>Địa chỉ 2: 97 Man Thiện, phường Tăng Nhơn Phú A, quận 9, TP.Hồ Chí Minh</p>
    </div>
</body>
<script>
  function myFunction(x) {
    x.classList.toggle("fa-heart-pink");
  }
</script>

</html>