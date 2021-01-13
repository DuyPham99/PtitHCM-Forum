<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Start your development with a Dashboard for Bootstrap 4.">
<meta name="author" content="Creative Tim">
<title>Argon Dashboard - Free Dashboard for Bootstrap 4</title>
<!-- Favicon -->
<link rel="icon"
	href="http://localhost:8000/resources/assets/img/brand/favicon.png"
	type="image/png">
<!-- Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
<!-- Icons -->
<link rel="stylesheet"
	href="http://localhost:8000/resources/assets/vendor/nucleo/css/nucleo.css"
	type="text/css">
<link rel="stylesheet"
	href="http://localhost:8000/resources/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
	type="text/css">
<!-- Argon CSS -->
<link rel="stylesheet"
	href="http://localhost:8000/resources/assets/css/argon.css?v=1.2.0"
	type="text/css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://localhost:8000/resources/js/utils.js"></script>	
</head>

<body>
	<!-- Sidenav -->
	<nav
		class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white"
		id="sidenav-main">
		<div class="scrollbar-inner">
			<!-- Brand -->
			<div class="sidenav-header  align-items-center">
				<a class="navbar-brand" href="javascript:void(0)">
					${sessionScope.username}
				</a>
			</div>
			<div class="navbar-inner">
				<!-- Collapse -->
				<jsp:include page="nav.jsp"></jsp:include>
			</div>
		</div>
	</nav>
	<!-- Main content -->
	<div class="main-content mt-6" id="panel">
		<!-- Page content -->
		<div class="container-fluid mt--6">
			<div class="row">
				<div class="col">
					<div class="card">
						<!-- Card header -->
						<div class="card-header border-0">
							<h3 class="mb-0">Quản lý tài khoản</h3>
						</div>
						<!-- Light table -->
						<div class="table-responsive">
							<table class="table align-items-center table-flush">
								<thead class="thead-light">
									<tr>
										<th scope="col" class="sort" data-sort="name">STT</th>
										<th scope="col" class="sort" data-sort="budget">Tên đăng
											nhập</th>
										<th scope="col" class="sort" data-sort="status">Email</th>
										<th scope="col">Số lượng bài viết</th>
										<th scope="col" class="sort" data-sort="completion"></th>
										<th scope="col">Quyền</th>
										<th scope="col">Chức năng</th>
									</tr>
								</thead>
								<tbody class="list">
									<c:forEach var="post" items="${list}" varStatus="loop">
										<tr>
											<td>${loop.count}</td>
											<td>${post.timeCreate}</td>
											<td>${post.title}</td>
											<td>${post.user.username}</td>
											<td>	</td>
											</select> 
											<td>
												<button type="button" class="btn btn-danger" id="deleteUser" onclick="deletePost('${post.idPost}')">DELETE</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- Card footer -->
						<div class="card-footer py-4">
							<nav aria-label="...">
								<ul class="pagination justify-content-end mb-0">
									<li class="page-item"><a class="page-link" href="/admin/post/1"> <i
										class="fas fa-angle-left"></i> <span class="sr-only">Previous</span>
									</a></li>

									<c:forEach begin="1" end="${size}" varStatus="loop">
									<li class="page-item active"><a class="page-link" href="/admin/post/${loop.count}">${loop.count}</a>
									</li>
									</c:forEach>
									
									
									<li class="page-item"><a class="page-link" href="/admin/post/${size}"> <i
											class="fas fa-angle-right"></i> <span class="sr-only">Next</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<!-- Dark table -->

		</div>
	</div>
	<!-- Argon Scripts -->
	<!-- Core -->
	<script src="../assets/vendor/jquery/dist/jquery.min.js"></script>
	<script
		src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../assets/vendor/js-cookie/js.cookie.js"></script>
	<script src="../assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
	<script
		src="../assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
	<!-- Argon JS -->
	<script src="../assets/js/argon.js?v=1.2.0"></script>
</body>
<script>
  function deletePost(idPost){
	var r = confirm("Bạn có muốn xóa không?!");
	if (r == false) return;
    $.ajax({
                            contentType: "application/json; charset=utf-8",
                            type: "POST",
                            headers: { "Authorization": getCookie("Authorization") },
                            url: "http://localhost:8000/admin/post/delete/" + idPost,                     
                            // prevent jQuery from automatically transforming the data into a query string
                            success: function (response) {
                            	 window.location.href = "/admin/post/1";
                            },
                            error: function (xhr, ajaxOptions, error) {
                                var log = JSON.parse(xhr.responseText)
                                for (i in log.errors) {
                                    alert(log.errors[i]);
                                }
                            }
                        });
  }

  function changeRole(username){
    $.ajax({
                            contentType: "application/json; charset=utf-8",
                            type: "POST",
                            headers: { "Authorization": getCookie("Authorization") },
                            url: "http://localhost:8000/admin/table/update/" + username + "/"+ $("#role").val(),                     
                            // prevent jQuery from automatically transforming the data into a query string
                            success: function (response) {
                                window.location.href = "/admin/post/1";
                            },
                            error: function (xhr, ajaxOptions, error) {
                                var log = JSON.parse(xhr.responseText)
                                for (i in log.errors) {
                                    alert(log.errors[i]);
                                }
                            }
                        });
  }
</script>
</html>