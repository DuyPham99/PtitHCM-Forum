<!DOCTYPE html>
<html>

<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 
</head>

<body>
  <form >
    <input type="text" id="username" name="username" placeholder="Tên đăng nhập">
    <br>
    <input type="text" name="password" placeholder="Mật khẩu" class="mt-3">
    <p style="font-size: 12px; margin-bottom: 0px; margin-top: 3px; margin-bottom: 3px; /* color: ; */"><a href="#">Quên mật khẩu?</a></a></p>
    <button id="btnSubmit">click </button>
    <p style="font-size: 12px; display:block;">Chưa có tài khoản? <a href="#">Đăng ký</a></p>  
  </form>
  <input name="" id="btnSubmit" class="btn btn-primary btn-block" style="margin-top: 0px;margin-bottom: 10px;" type="submit" value="Đăng nhập">
</body>

<script>
  $('#btnSubmit').click(function (event) {
    alert($('#username').val());
    $.ajax({
      url: "login",
      type: "post",
      contentType: 'application/json',
      data:JSON.stringify( {'username' : $('#username').val(), 'password' :  $('#username').val()}),
      success: function (data, response) {
        alert(data.jwt);
      }
    });
  });
</script>

</html>