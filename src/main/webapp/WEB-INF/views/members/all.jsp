<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 19.02.19
  Time: 12:00
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <title>All members</title>
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
                <a class="nav-link" href="/app/users/main">Main panel</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/users/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class=" jumbotron ">

        <h1>My Family</h1>
        <%--<img src="/images/icon.png">--%>



    </div>
</div>


    <div class="row" >
        <div class="col-sm-6 col-md-9 col-md-offset-3" align="center">
<table class="table table-striped tab">
    <thead>
    <tr>
        <th scope="col"> Actions</th>
        <th scope="col"> Family member</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <c:forEach var="member" items="${members}">
        <th scope="row">
            <div class="btn-group-vertical">
                <a href="/app/members/remove/${member.id}"
                   onclick="return confirm('Are you sure you want to delete this item?');">
                    <button type="button" class="btn btn-success mm bt"> Remove</button>
                </a>
                <a href="/app/members/edit/${member.id}">
                    <button type="button" class="btn btn-warning mm bt">Edit</button>
                </a>
                <a href="/app/members/plan/${member.id}">
                    <button type="button" class="btn btn-primary mm bt">Week plan</button>
                </a>
            </div>
        </th>

        <td> ${member.name}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>

        </div>
    </div>

<br>
<br>


<div class="col-sm-6 col-md-4 col-md-offset-4">
    <br>
    <br>
    <br>
</div>

<nav class="navbar fixed-bottom navbar navbar-dark bg-primary" style="background-color: #e3f2fd;">
    <p class="navbar-brand" href="#">Family manager - developed by Apaczka</p>
</nav>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>

</body>
</html>
