<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!--   <meta charset="utf-8"> -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>PTIT-HCM: Diễn đàn trao đổi học tập!!</title>
  <!-- Import Boostrap css, js, font awesome here -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
  </script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link href="resources/css/style.css" rel="stylesheet">
</head>

<body>
  <div class="container register-form">
    <a href="/"><img src="images/ptitLogo.jpg" style="margin-bottom: 10px;margin-left: 80px;width:80px;height:80px"></a>
    <form>
      <input type="text" name="username" placeholder="Tên đăng nhập">
      <br>
      <input type="password" name="password" placeholder="Mật khẩu" class="mt-3">
      <p style="font-size: 12px; margin-bottom: 0px; margin-top: 3px; margin-bottom: 3px; /* color: ; */"><a
          href="#">Quên mật khẩu?</a></a></p>
      <input name="" id="btnSubmit" class="btn btn-primary btn-block" style="margin-top: 0px;margin-bottom: 10px;"
        type="submit" value="Đăng nhập">
      <p style="font-size: 12px; display:block;">Chưa có tài khoản? <a href="/register">Đăng ký</a></p>
    </form>
  </div>
</body>

<script>
function getCookie(name) {
    // Split cookie string and get all individual name=value pairs in an array
    var cookieArr = document.cookie.split(";");
     
    // Loop through the array elements
    for(var i = 0; i < cookieArr.length; i++) {
        var cookiePair = cookieArr[i].split("=");
        
        if(name == cookiePair[0].trim()) {
            return decodeURIComponent(cookiePair[1]);
        }
    }
}
	
  $("#btnSubmit").click(function (event) {
    var username = $("input[name=username]").val();
    var password = $("input[name=password]").val();
    var data = { 'username': username, 'password': password };
    event.preventDefault();
    if (username != "" && password != "") {
      $.ajax({
        contentType: "application/json; charset=utf-8",
        url: '/login',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(data),
        success: function (data, response) { 
          document.cookie = "Authorization=Bearer " + data.jwt + "; " ;
          window.location.href = "/";
        },
        error: function (xhr, ajaxOptions, thrownError) {
          window.location.reload();       
        }
      });
    }
  })  

  // $("#temp").click(function (event) {  
  //   event.preventDefault();
  //     $.ajax({
  //       contentType: "application/json; charset=utf-8",
  //       url: '/create/hello',
  //       headers: {"Authorization" : getCookie("Authorization")},
  //       type: 'GET',
  //       dataType: 'json',
  //       data: JSON.stringify("test"),
  //       success: function (data, response) {
  //         alert("success");
  //       },
  //       error: function (xhr, ajaxOptions, thrownError) {
  //         alert("error");
  //       }
  //     });   
  })  

  
</script>


</html>