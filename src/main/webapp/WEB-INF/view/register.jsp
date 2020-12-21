<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
  </head>

  <body>
    <div class="container register-form" style="top: 100px;">
      <a href="#"><img src="images/ptitLogo.jpg"
          style="margin-bottom: 10px;margin-left: 80px;width:80px;height:80px"></a>
      <form id="register-form">
        <div>Tên đăng nhập: </div>
        <input type="text" id="username" name="username" placeholder="">
        <div>Nhập email: </div>
        <input type="email" id="email" name="email" placeholder="email@example.com">
        <p style="font-size: 12px; margin-bottom: 0px;">Bạn sẽ nhận được email đăng ký tài khoản!</p>
        <div>Mật khẩu: </div>
        <input type="password" id="password" name="password" placeholder="">
        <div>Nhập lại khẩu: </div>
        <input type="password" id="retype" name="retype" placeholder="">
        <br>
        <input name="" id="btnSubmit" class="btn btn-primary" style="margin-top: 10px;margin-bottom: 10px;"
          type="submit" value="Gửi">
        <p style="font-size: 12px; display:block;">Đã có tài khoản? <a href="/login">Đăng nhập</a></p>
      </form>
    </div>
  </body>

  <script>
    {
      $().ready(function () {
        $("#register-form").validate({
          onfocusout: false,
          onkeyup: false,
          onclick: false,
          rules: {
            "username": {
              required: true,
              maxlength: 15
            },
            "password": {
              required: true,
              minlength: 8
            },
            "email": {
              required: true,
              email: true
            },
            "retype": {
              equalTo: "#password",
              minlength: 8
            }
          },
          messages: {
            "username": {
              required: "Bắt buộc nhập username",
              maxlength: "Hãy nhập tối đa 15 ký tự"
            },
            "password": {
              required: "Bắt buộc nhập password",
              minlength: "Hãy nhập ít nhất 8 ký tự"
            },
            "email": {
              required: "Bắt buộc nhập email",
              email: "Email không chính xác"
            },
            "retype": {
              equalTo: "Hai password phải giống nhau",
              minlength: "Hãy nhập ít nhất 8 ký tự"
            }
          }
        });
      });
    }
  </script>

  <script>
    $("#btnSubmit").click(function (event) {
      //get data from form
      var data = {};
      event.preventDefault();
      // var formStatus = $("#register-form").validate().form();
      // if (formStatus != 1) return;
      $("#register-form").serializeArray().map(function (x) { data[x.name] = x.value; });
      if (username != "" && password != "") {
        $.ajax({
          contentType: "application/json; charset=utf-8",
          url: '/register',
          type: 'POST',
          data: JSON.stringify(data),
          success: function (data, response) {
            alert("Thành công!");
            window.location.href = "/login";
          },
          error: function (xhr, ajaxOptions, error) {
            if (xhr.responseText === 'User was existed!') {
              alert("Tên đăng nhập đã tồn tại!");
            } else if (xhr.responseText === 'User was existed!') {
              alert("Email đã tồn tại!");
            }

            var log = JSON.parse(xhr.responseText)
            for (i in log.errors) {
              alert(log.errors[i]);
            }
          }
        });
      }
    })  
  </script>

  </html>