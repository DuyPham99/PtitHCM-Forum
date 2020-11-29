<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<link href="resources/css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
		integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

	<link href="resources/froala-editor/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="resources/froala-editor/js/froala_editor.pkgd.min.js"></script>
	<link href="resources/froala-editor/css/froala_style.min.css" rel="stylesheet" type="text/css" />
</head>

<body style="background: #f2f2f2;">
	<!-- Navigation & Header -->
	<header>
		<div class="container-fluid bg-white">
			<div class="row text-center border-bottom">
				<div class="col text-right">
					<a href="#"><img src="images/ptitLogo.jpg" height="70" class="logo" width="270"
							style="width: 30%;"></a>
				</div>

				<div class="col-6">
					<a href="#"><i class="fa fa-search"></i></a> <input class="header-search" size="40" type="text"
						placeholder="Tìm kiếm bài viết, tác giả,..." aria-label="Search">
				</div>
				<div class="col align-self-center">
					<a href="#" class="text-header"> Đăng ký </a> <a href="#" class="ml-5 text-header"> Đăng nhập</a>
				</div>
			</div>
		</div>

	</header>
	<nav class="navbar navbar-expand-sm navbar-dark sticky-top bg-white header p-auto">
		<div class="container">
			<ul class="nav col-md-12 nav-bar text-header" style="color: black;">
				<li class="nav-item "><a class="nav-link py-0" href="#">Trang
						chủ</a></li>
				<li class="nav-item"><a class="nav-link py-0" href="#">Hoạt
						động</a></li>
				<li class="nav-item"><a class="nav-link py-0" href="#">Học
						tập</a></li>
				<li class="nav-item"><a class="nav-link py-0" href="#">Đội
						- Nhóm</a></li>
				<li class="nav-item"><a class="nav-link py-0" href="#">Chuyện
						trò - tâm sự</a></li>
				<li class="nav-item"><a class="nav-link py-0" href="#">Chia
						sẻ kinh nghiệm</a></li>
				<li class="nav-item"><a class="nav-link py-0" href="#">Truyện
						cười</a></li>
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
					<img src="https://spiderum.com/assets/images/banner/cover-spiderum-not-login.jpg" alt="Chicago"
						width="1100" height="500">
					<div class="carousel-caption">
						<h3>Los Angeles</h3>
						<p>We had such a great time in LA!</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="https://spiderum.com/assets/images/banner/cover-spiderum-not-login.jpg" alt="New York"
						width="1100" height="500">
					<div class="carousel-caption">
						<h3>Los Angeles</h3>
						<p>We had such a great time in LA!</p>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		</div>
	</div>
	<!--End: Banner-->
	<br>
	<div class="container">
		<!-- <div id="example">
         
      </div> -->


		<div id="froala-editor">
			<form action="save" method="POST" id="form-content-editor">
				<textarea name="editor" id="editor" cols="30" rows="10"></textarea>
				<button id="saveButton" class="btn btn-primary mt-1">Đăng
					bài</button>
			</form>
		</div>
	</div>
	<br>
	<br>
</body>
<script>
	var editor = new FroalaEditor('#editor', {
		imageUploadParam: 'image',
		imageUploadURL: '/editor/upload_image',
		imageAllowedTypes: ['jpeg', 'jpg', 'png'],
		imageMaxSize: 5 * 1024 * 1024,
		imageUploadMethod: 'POST',
		heightMin: 500,
		heightMax: 400,
		pluginsEnabled: ["align", "charCounter", "codeBeautifier", "colors",
			"draggable", "embedly", "emoticons", "entities", "fontFamily",
			"fontSize", "image", "imageManager", "inlineStyle",
			"lineBreaker", "fileUpload", "lists", "paragraphFormat",
			"paragraphStyle", "quote", "save", "url", "wordPaste"],
		events: {
			'image.removed': function ($img) {
				var xhttp = new XMLHttpRequest();
				xhttp.open("DELETE", "/editor/image_delete", true);
				xhttp.send(JSON.stringify({
					src: $img.attr('src')
				}));
			}

		}
	})
</script>

<script>
	$(document).ready(function () {
		$("#saveButton").click(function (event) {
			event.preventDefault();
			ajaxSubmitForm();

		});
	});

	function ajaxSubmitForm() {
		// Get form
		// var form = $('#form-content-editor')[0];
		var data = $('textarea').val();
		$("#saveButton").prop("disabled", true);
		$.ajax({
			type: "POST",
			dataType: 'html',
			url: "/editor/save",
			data: data,
			// prevent jQuery from automatically transforming the data into a query string
			processData: false,
			contentType: false,
			cache: false,
			timeout: 1000000,
			success: function (response) {
				alert("Success");
			},
			error: function (errorThrown) {
				alert("Fail");
			}
		});
	}
</script>
</html>