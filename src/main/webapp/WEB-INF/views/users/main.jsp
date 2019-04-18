<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 25.02.19
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        <%@include file="/css/style.css" %>
    </style>
    <link href="resources/css/styles.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Main panel</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Family Manager</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/users/edit">Edit user</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/users/logout">Logout</a>
            </li>

        </ul>
    </div>
</nav>

<div class="container main">
    <div class="jumbotron">
        <h1>My Family</h1>
        <p style="font-size: larger">“Family ties mean that no matter how much you might want to run from your family,
            you can’t.”</p>
    </div>
</div>
<br>
<br>

<p class="main" style="margin-bottom: 70px"> You are signed in as: ${logged.name} </p>

<div class="container">
    <div class="row">
        <div class="col col-md-3 col-sm-6 ">
            <a href="/app/members/add">
                <button type="button" class="btn btn-primary btn-lg mm ">Add member</button>
            </a>
        </div>
        <div class="col col-md-9 col-sm-6">
            <h3>Family members</h3>
            <p>Clicking on the button you will add new members to your family!</p>

        </div>
    </div>
    <div class="row">
        <div class="col col-md-3 col-sm-6 mm">
            <a href="/app/events/add">
                <button type="button" class="btn btn-success btn-lg mm">Add event</button>
            </a>
        </div>
        <div class="col col-md-9 col-sm-6">
            <h3>Add new family event</h3>
            <p>Here you can add new event for your family members</p>
        </div>
    </div>
    <div class="row">
        <div class="col col-md-3 col-sm-6">
            <a href="/app/events/week">
                <button type="button" class="btn btn-warning btn-lg mm">Week plan</button>
            </a>
        </div>
        <div class="col col-md-9 col-sm-6">
            <h3>Look at family week plan</h3>
            <p>Here you can look at your family week-plan</p>
        </div>
    </div>
    <div class="row">
        <div class="col col-md-3 col-sm-6">
            <a href="/app/members/all">
                <button type="button" class="btn btn-danger btn-lg mm">All members</button>
            </a>
        </div>
        <div class="col col-md-9 col-sm-6">
            <h3>Display list of your family members</h3>
            <p>Here you can look at your family members</p>
        </div>
    </div>
</div>

<div align="center">
    <div class="col col-md-10">
        <img src="/images/children.jpg" class="img-fluid" alt="children" style="margin-top: 100px">
    </div>
</div>
<br>
<br>
<br>
<br>

<nav class="navbar sticky-bottom navbar navbar-dark bg-primary" style="background-color: #e3f2fd;">
    <p class="navbar-brand" href="#">Family manager - developed by Apaczka</p>
</nav>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
