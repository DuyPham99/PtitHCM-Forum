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
    <link href="resources/css/style.css" rel="stylesheet">
    
</head>
<body>
  <div class="container register-form">
      <a href="/"><img src="images/ptitLogo.jpg" style="margin-bottom: 10px;margin-left: 80px;width:80px;height:80px"></a>
      <form action="">
        <div>Bạn vui lòng nhập thông tin để lấy <br>lại mật khẩu </div>
        <input type="text" id="username" placeholder="Tên đăng nhập"><br><br>
        <input type="email" id="email" placeholder="email@example.com">
        <p style="font-size: 12px; margin-bottom: 0px;"></p>
        <input name="" id="submit" class="btn btn-primary" style="margin-top: 10px;margin-bottom: 10px;" type="submit" value="Gửi">
        <p style="font-size: 12px; display:block;">Đã có tài khoản? <a href="/login">Đăng nhập</a></p>  
      </form>
      </div>
</body>
 
<script>
    $(document).ready(function () {
                        $("#submit").click(function (event) {
                            event.preventDefault();
                            location.href = "/sendSimpleEmail/" + $("#username").val() + "/" + $("#email").val();
                        });
                    });
</script>
</html>