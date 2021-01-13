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
                        integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
                        crossorigin="anonymous">

                    <link href="resources/froala-editor/css/froala_editor.pkgd.min.css" rel="stylesheet"
                        type="text/css" />
                    <script type="text/javascript" src="resources/froala-editor/js/froala_editor.pkgd.min.js"></script>
                    <link href="resources/froala-editor/css/froala_style.min.css" rel="stylesheet" type="text/css" />
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
                                    <ul class="nav flex-column nav-pills" style="float: right;">
                                        <li class="nav-item">
                                            <a class="nav-link disabled" href="#comment"><i class="fa fa-comments"
                                                    style="margin-right: 2px;"></i></a>
                                        </li>
                                        <li class="nav-item ">
                                            <a class="nav-link disabled" href="#top"><i class="fas fa-angle-double-up"
                                                    style="margin-right: 6px;"> </i></a>
                                        </li>
                                        <li class="nav-item ">
                                            <a class="nav-link disabled" href="#end"><i class="fas fa-angle-double-down"
                                                    style="margin-right: 3px;"> </i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-8 p-0">
                                <!--Start: new feed-->
                                <ul class="nav flex-column">
                                    <li class="nav-item">
                                        <div class="container">
                                            <div class=""
                                                style="height: 100%; padding-bottom: 60px;">
                                                <div class="author-feed">
                                                    <div class="account">
                                                        <a href="#"
                                                            style="float:left;"><b>${post.user.username}</b>&nbsp</a>
                                                        <p style="display: inline; color: #99A3AD;">trong</p>
                                                        <a href="#" class="topic-title"
                                                            style="color:#2C3E50;">${category}</a>
                                                        <p style="margin-bottom: 0px;">
                                                            <fmt:formatDate type="both" dateStyle="short"
                                                                timeStyle="short" value="${post.timeCreate}" />
                                                        </p>
                                                    </div>
                                                </div>
                                          <br><br>
                                                <div class="content">
                                                    <div class="text">
                                                        <!--Start:Title-->
                                                        <p class="title">
                                                            ${post.title}
                                                        </p>
                                                        <!--End:Title-->
                                                        <!--Start: content-->
                                                        <p class="body">
                                                            ${post.content}
                                                        </p>
                                                        <!--End: content-->
                                                        <!--Start:author-->
                                                        <a href="#">
                                                        </a>
                                                        <!--End : Author-->
                                                    </div>
                                                </div>
                                                <div class="toolbar">
                                                    <div class="" style="float: left;">
                                                       
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                                <!--End: new feed-->
                            <!--Start: comment-->
                                <ul class="nav flex-column mt-0" >
                                    <li class="nav-item">
                                        <div id="comment" class="container" >
                                            <div class="position-relative border new-feed"
                                                style="height: 100%; padding-bottom: 60px;">
                                                <p style="margin-bottom: 10px;"> Bình luận: </p>                                              
                                                <!--Start: CommentEditor-->
                                                <form class="form-inline" id="commentForm">
                                                    <div class="form-group" style="padding-left: 5px;">
                                                        <label for=""></label>
                                                        <input type="text" size="85%" name="" id="content" class="form-control"
                                                            placeholder="" aria-describedby="helpId">
                                                        <i class="far fa-smile"
                                                            style="color:#ced4da;margin-left: 4px;margin-right: 4px;"></i>
                                                        <input type="hidden" id="user" value=" ${sessionScope['username']}"/>
                                                        <button type="submit" id="save" class="btn btn-primary">Gửi</button>
                                                    </div>
                                                </form>
                                                <!--End: CommentEditor-->

								                <c:forEach var="comment" items="${post.comments}"> 
                                                <!--Start: Nest MediaObject-->
                                                <div class="container mt-3">
                                                    <hr>
                                                    <br>
                                                    
                                                    <!-- Start : Comment 1-->
                                                    <div class="media">
                                                        <img src="${comment.user.profile.avatar}" alt="John Doe"
                                                            class="mr-3 mt-3 rounded-circle" style="width:60px;">
                                                        <div class="media-body">
                                                            <a href="#" style="float: right;"><i
                                                                    class=""></i></a>                     
                                                            <h4>${comment.user.username}<small style="font-size: 12px;"><i>   <fmt:formatDate type="both" dateStyle="short"
                                                                timeStyle="short" value="${comment.dateCreate}" /></i></small>
                                                            </h4>
                                                            ${comment.content}        
    
                                                        </div>
                                                    </div>
                                                    <!-- End : Comment 1-->  

                                                </div>
                                                <!-- End: Nest MediaObject-->
									</c:forEach>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
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
                    function myFunction(x) {
                        x.classList.toggle("fa-heart-pink");
                    }
                </script>
                <script>
                    $(document).ready(function () {
                        $("#save").click(function (event) {
                            event.preventDefault();
                            if ($("#content").val == null || $("#content").val == "") return;
                            ajaxSubmitForm();
                        });
                    });
        
                    function ajaxSubmitForm() {
                        // Get form
                        // var form = $('#form-content-editor')[0];
                        //var data = { title: $("#title").val(), content: $('textarea').val(), category: $("#category").val() };
                        var data = {content: $("#content").val()};                      
                        console.log(data);
                        $.ajax({
                            contentType: "application/json; charset=utf-8",
                            type: "POST",
                            headers: { "Authorization": getCookie("Authorization") },
                            url: "/create/comment/${post.idPost}",
                            data: JSON.stringify(data),
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