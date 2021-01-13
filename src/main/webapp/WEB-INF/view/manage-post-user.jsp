<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <!DOCTYPE html>
                    <html lang="en" id="top">

                    <head>
                        <meta charset="utf-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1">
                        <title>PTIT-HCM: Diễn đàn trao đổi học tập!!</title>
                        <!-- Import Boostrap css, js, font awesome here -->
                        <link rel="stylesheet"
                            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
                        <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">
                        <link href="custom.css" rel="stylesheet">
                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">

                        </script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">

                        </script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
                        <link href="http://localhost:8000/resources/css/style.css" rel="stylesheet">
                        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
                            integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
                            crossorigin="anonymous">

                        <link href="resources/froala-editor/css/froala_editor.pkgd.min.css" rel="stylesheet"
                            type="text/css" />
                        <script type="text/javascript"
                            src="resources/froala-editor/js/froala_editor.pkgd.min.js"></script>
                        <link href="resources/froala-editor/css/froala_style.min.css" rel="stylesheet"
                            type="text/css" />
                        <script src="http://localhost:8000/resources/js/utils.js"></script>
                        <script
                            src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>

                        <!--Start: Initial Websocket-->
                        <title>Chat WebSocket</title>
                        <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
                        <!--End: Initial Websocket-->

                        <base href="http://localhost:8000/" />
                    </head>

                    <body style="background: #f2f2f2;">
                        <jsp:include page="header.jsp"></jsp:include>
                        <br>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-2 mt-3">
                                    <div class="container sticky">
                                        <!--navigation-->

                                    </div>
                                </div>
                                <div class="col-md-8 p-0">
                                    <!--Start: new feed-->
                                    <ul class="nav flex-column">
                                        <li class="nav-item">
                                            <div class="container">
                                                <div class="position-relative border new-feed"
                                                    style="height: 100%; padding-bottom: 60px;">
                                                    <!--Start: Table List Post-->
                                                    <table class="table">
                                                        <thead class="thead-light">
                                                            <tr>
                                                                <th>STT</th>
                                                                <th>Thời gian</th>
                                                                <th>Tiêu đề</th>
                                                                <th></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach var="post" items="${list}" varStatus="i">
                                                            <tr>
                                                                <td>${i.count}</td>
                                                                <td>${post.timeCreate}</td>
                                                                <td>${post.title}</td>
                                                                <td>
                                                                    <button type="button" id="change" class="btn btn-primary"
                                                                        onclick="window.location.href='/post-update?id=' + ${post.idPost} ">
                                                                        Sửa</button>
                                                                    <button type="button"
                                                                        class="btn btn-danger" onclick="deletePost('${post.idPost}')">Xóa</button>
                                                                </td>
                                                            </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                    <!--End: Table List Post-->
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                    <!--End: new feed-->
                                    <!--Start: comment-->

                                    <!--End: comment-->
                                </div>
                            </div>
                            <div class="container" style="font-size: 10px;" id="end">
                                <hr>
                                <p>Học viện Công nghệ Bưu chính - TP.HCM</p>
                                <p>Địa chỉ 1: Quận 1</p>
                                <p>Địa chỉ 2: 97 Man Thiện, phường Tăng Nhơn Phú A, quận 9, TP.Hồ Chí Minh</p>
                            </div>
                            <br>
                            <br>
                    </body>
                    <script>
                        jQuery(document).ready(function ($) {
                            $(".clickable-row").click(function () {
                                window.location = $(this).data("href");
                            });
                        });
                    </script>

                    <script>
                        function Change(id) {
                            var path = "/update/post" + "?id=" + id;
                            $.ajax({                       
                                type: "GET",
                                headers: { "Authorization": getCookie("Authorization")},
                                url: path,
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
    function deletePost(id) {
        var cf = confirm("Bạn có muốn xóa?");
        if (cf!= true) return;
        $.ajax({
            contentType: "application/json; charset=utf-8",
            type: "GET",
            headers: { "Authorization": getCookie("Authorization") },
            url: "/delete/post/" + id,
            // prevent jQuery from automatically transforming the data into a query string
            success: function (response) {
                window.location.reload();
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