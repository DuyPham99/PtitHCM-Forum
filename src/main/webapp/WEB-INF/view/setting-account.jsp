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
                    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
                        integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
                        crossorigin="anonymous">
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
                    <script src="resources/js/utils.js"></script>
                </head>

                <body style="background:#f2f2f2;">
                    <jsp:include page="header.jsp"></jsp:include>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-2 mt-3">

                            </div>
                            <div class="col-md-8 p-0 new-feed profile">
                                <div class="row mt-5" style="margin-left: 8em;">
                                    <form action="/image/save" id="imageForm" enctype="multipart/form-data"
                                        method="POST">
                                        <img id="profileImage" class="far fa-user" height="70" width="70"
                                            style="float: left; width:auto; margin-left: 48px;  background-image:none;"
                                            src="http://localhost:8000/${profile.avatar}" />
                                        <input id="imageUpload" type="file" name="avatar" placeholder="Photo"
                                            required="" onchange="submitFunction()" capture>
                                    </form>
                                    <!-- <textarea name="quote" cols="51" style="margin-left: 3em;"> </textarea> -->
                                </div>

                                <form action="#" method="get" class="" id="setting">
                                    <!-- Start: Row 1-->
                                    <div class="row mt-2" style="margin-left: 10em;">
                                        <div class="col-md-6">
                                            <input type="hidden" value="${sessionScope.username}" name="username"
                                                id="username" />
                                            <label>Tên hiển thị: </label>
                                            <br>
                                            <input type="text" name="name" id="name" value="${profile.name}">

                                            <br><br>
                                            <label>Ngày sinh: </label>
                                            <br>
                                            <input type="date" name="birthday" id="birthday"
                                                value="${profile.birthday}">

                                            <br><br>
                                            <label>Địa chỉ: </label>
                                            <br>
                                            <input type="text" name="address" id="address" value="${profile.address}">

                                            <br><br>
                                            <a href="#" data-toggle="modal" data-target="#myModal">Thay đổi mật khẩu</a>


                                        </div>
                                        <div class=" col-md-6">
                                            <label>CMND: </label>
                                            <br>
                                            <input type="number" name="idCard" id="idCard" value="${profile.idCard}">

                                            <br><br>
                                            <label>Giới tính: </label>
                                            <br>
                                            <label class="radio-inline">
                                                <input type="radio" name="gender" id="male" value="true" checked> Nam
                                            </label>
                                            <label class="radio-inline" style="margin-left: 50px;">
                                                <input type="radio" name="gender" id="female" value="false"> Nữ
                                            </label>

                                            <br>
                                            <label style="margin-top: 20px;">Số điện thoại: </label>
                                            <br>
                                            <input type="text" name="phoneNumber" id="phoneNumber"
                                                value="${profile.phoneNumber}">
                                            <br><br>
                                            <a href="#">Thay đổi email</a>
                                        </div>


                                    </div>
                                    <button type="submit" id="saveSetting" class="btn btn-primary mt-3"
                                        style="margin-left: 350px;"> Xác nhận </button>
                                    <button type="reset" class="btn btn-danger mt-3 ml-2" style=""
                                        onclick="window.location.reload()"> Hủy bỏ </button>
                                    <!-- End: Row 1-->
                                </form>
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" role="dialog">
                                    <div class="modal-dialog">
                                        <!-- Modal content-->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close"
                                                    data-dismiss="modal">&times;</button>
                                                <h4 class="modal-title"></h4>
                                            </div>
                                            <div class="modal-body">
                                                <form action="" method="POST" id="changePassword">
                                                    <div>Mật khẩu cũ:</div>
                                                    <input type="password" id="oldPassword" name="oldPassword"/>
                                                    <div>Mật khẩu mới:</div>
                                                    <input type="password" id="newPassword" name="newPassword" />
                                                    <div>Nhập lại mật khẩu:</div>
                                                    <input type="password" id="retypePassword" name="retypePassword" />
                                                    <br><br>
                                                    <button type="submit" id="submitPassword" >Xác nhận</button>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default"
                                                    data-dismiss="modal">Close</button>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">

                            </div>
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

                    $("#profileImage").click(function (e) {
                        $("#imageUpload").click();
                    });
                </script>

                <script>
                    $(document).ready(function () {
                        $("#saveSetting").click(function (event) {
                            event.preventDefault();
                            // var formStatus = $("#form-content-editor").validate().form();
                            // if (formStatus != 1) return;
                            ajaxSubmitForm();
                        });
                    });



                    function ajaxSubmitForm() {
                        // Get form
                        // var form = $('#form-content-editor')[0];
                        //var data = { title: $("#title").val(), content: $('textarea').val(), category: $("#category").val() };
                        var data1 = {};
                        $("#setting").serializeArray().map(function (x) { data1[x.name] = x.value; });
                        console.log(data1);
                        $.ajax({
                            contentType: "application/json; charset=utf-8",
                            type: "POST",
                            headers: { "Authorization": getCookie("Authorization") },
                            url: "/create/setting/save",
                            data: JSON.stringify(data1),
                            // prevent jQuery from automatically transforming the data into a query string
                            success: function (response) {
                                window.location.href = response;
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
                <script>
                    if (${ profile.gender } == false) document.getElementById("female").checked = true;

                </script>
                <script>

                    function submitFunction() {
                        document.getElementById("imageForm").submit();// Form submission
                    }
                </script>
                <script>
                    $(document).ready(function () {
                        $("#submitPassword").click(function (event) {
                            event.preventDefault();
                            // var formStatus = $("#form-content-editor").validate().form();
                            // if (formStatus != 1) return;
                            changePassword();
                        });
                    });
                    function changePassword() {
                        var data = {};
                        $("#changePassword").serializeArray().map(function (x) { data[x.name] = x.value; });
                        console.log(data);
                        $.ajax({
                            contentType: "application/json; charset=utf-8",
                            type: "POST",
                            headers: { "Authorization": getCookie("Authorization") },
                            url: "/account/update/password",
                            data: JSON.stringify(data),
                            // prevent jQuery from automatically transforming the data into a query string
                            success: function (response) {
                                window.location.reload();
                            },
                            error: function (xhr, ajaxOptions, error) {
                                alert(xhr.responseText);

                            }
                        });
                    }
                </script>


                </html>