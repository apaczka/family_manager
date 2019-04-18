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
        <%@include file="/css/style.css"%>
    </style>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>Edit Event</title>
</head>

<body class="blu">

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
                <a class="nav-link" href="/app/users/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="evt">
    <form:form method="post" modelAttribute="event" action="/app/events/edit">
        <form:hidden path="id"/>
        <form:hidden path="family" value="${event.family.id}"/>

        <label class="label"> Name </label>
        <form:input path="name" class="ss"/><br>
        <form:errors path="name" cssClass="error" element="div"/>
        <label class="label"> Date </label>
        <form:input type="date" path="date" class="ss"/><br>
        <form:errors path="date" cssClass="error" element="div"/>
        <label class="label"> Family member </label>
        <form:select path="members" class="ss">
            <form:option value="0" label="--Please Select--"/>
            <form:options items="${members}" itemLabel="name" itemValue="id"/>
        </form:select><br>
        <form:errors path="members" cssClass="error" element="div"/>
        <label class="label"> Start time </label>
        <form:input type="time" path="timeFrom" class="ss"/><br>
        <form:errors path="timeFrom" cssClass="error" element="div"/>
        <label class="label"> End time </label>
        <form:input type="time" path="timeTo" class="ss"/><br>
        <form:errors path="timeTo" cssClass="error" element="div"/>
        <label class="label"> Category </label>
        <form:select path="category" class="ss">
            <form:option value="0" label="--Please Select--"/>
            <form:options items="${categories}"/>
        </form:select><br>
        <form:errors path="category" cssClass="error" element="div"/>
        <label class="label"> Notes </label>
        <form:textarea rows="5" cols="20" path="notes" class="ss"/><br>
        <form:errors path="notes" cssClass="error" element="div"/>
        <input type="submit" value="save" class="ss"/>
    </form:form>
    +
</div>

</div>

<nav class="navbar sticky-bottom navbar navbar-dark bg-primary" style="background-color: #e3f2fd;">
    <p class="navbar-brand" href="#">Family manager - developed by Apaczka</p>
</nav>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
