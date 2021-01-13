<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
                <!DOCTYPE html>
                <html>

                <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
                    <meta name="author" content="Creative Tim">
                    <title>Argon Dashboard - Free Dashboard for Bootstrap 4</title>
                    <!-- Favicon -->
                    <link rel="icon" href="http://localhost:8000/resources/assets/img/brand/favicon.png"
                        type="image/png">
                    <!-- Fonts -->
                    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
                    <!-- Icons -->
                    <link rel="stylesheet" href="http://localhost:8000/resources/assets/vendor/nucleo/css/nucleo.css"
                        type="text/css">
                    <link rel="stylesheet"
                        href="http://localhost:8000/resources/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
                        type="text/css">
                    <!-- Page plugins -->
                    <!-- Argon CSS -->
                    <link rel="stylesheet" href="http://localhost:8000/resources/assets/css/argon.css?v=1.2.0"
                        type="text/css">
                </head>

                <body>
                    <!-- Sidenav -->
                    <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white"
                        id="sidenav-main">
                        <div class="scrollbar-inner">
                            <!-- Brand -->
                            <div class="sidenav-header  align-items-center">
                                <a class="navbar-brand" href="/">
                                    ${sessionScope.username}
                                </a>
                            </div>
                            <div class="navbar-inner">
                                <!-- Collapse -->
                                <div class="collapse navbar-collapse" id="sidenav-collapse-main">
                                    <!-- Nav items -->
                                    <ul class="navbar-nav">

                                        <li class="nav-item">
                                            <a class="nav-link active" href="/admin/post/1">
                                                <i class="ni ni-tv-2 text-primary"></i>
                                                <span class="nav-link-text">Quản lý bài viết</span>
                                            </a>
                                        </li>

                                        <li class="nav-item">
                                            <a class="nav-link active" href="/admin/table/1">
                                                <i class="ni ni-tv-2 text-primary"></i>
                                                <span class="nav-link-text">Quản lý tài khoản</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </nav>
                   
                </body>

                </html>