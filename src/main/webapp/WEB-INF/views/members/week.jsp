<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: anna
  Date: 26.02.19
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.LocalTime" %>
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
    <title>Week view</title>
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
                <a class="nav-link" href="/app/members/all">All members</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/users/main">Main panel</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/members/nextplan/${member.id}">Next week</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/members/prevplan/${member.id}">Previous week</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/app/users/logout">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<table class="table table-bordered table-striped calendar ">
    <c:forEach var="hour" begin="4" end="23">
        <tr>
            <c:forEach var="dayOfWeek" begin="0" end="7">
                <td>
                    <c:choose>
                        <c:when test="${hour == 4}">
                            <c:choose>
                                <c:when test="${dayOfWeek != 0}">
                                    <b>
                                            ${today.plusDays(dayOfWeek-1).getDayOfWeek()}<br>${today.plusDays(dayOfWeek-1)}</b>
                                </c:when>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${dayOfWeek == 0}">
                                    ${hour}
                                </c:when>
                                <c:otherwise>
                                    <%--Lista zadań z ${today.plusDays(dayOfWeek-1)} z godziny ${hour}--%>
                                    <%--${eventsMap.get(today.plusDays(dayOfWeek-1))}<br><br>--%>
                                    <%--Godzina ${LocalTime.now()}<br><br>--%>
                                    <%--${eventsMap.get(today.plusDays(dayOfWeek-1)).get(LocalTime.of(hour, 0))}--%>
                                    <c:set var="event" value="${eventsMap.get(today.plusDays(dayOfWeek-1)).get(LocalTime.of(hour, 0))}"></c:set>
                                    <c:if test="${not empty event}">

                                        <div class="calendar">
                                            <span style="font-weight: bold"> ${event.name} </span><br>
                                            <span> ${event.timeTo} </span><br>
                                                <%--<span> ${eventsMap.get(today.plusDays(dayOfWeek-1)).get(LocalTime.of(hour, 0)).members} </span><br>--%>
                                            <c:forEach items="${event.members}" var="member">
                                                <span>${member.name}</span><br>
                                            </c:forEach>
                                            <span> ${event.category} </span><br>
                                            <span> ${event.notes} </span><br>
                                            <a href="/app/events/notify/${event.id}"><img class="pencil" src="/resources/images/email.png"/></a><br>
                                            <a href="/app/events/remove/${event.id}"><img class="pencil" src="/resources/images/recycle-bin.svg"/></a><br>
                                            <a href="/app/events/edit/${event.id}"><img class="pencil" src="/resources/images/pencil.svg"/></a><br>

                                        </div>
                                    </c:if>

                                    <%--${LocalTime.of(hour,0)}--%>

                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>

                </td>
            </c:forEach>
        </tr>
    </c:forEach>


</table>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
