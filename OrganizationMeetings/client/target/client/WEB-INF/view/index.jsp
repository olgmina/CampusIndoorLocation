<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<header>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <link href="style.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        .table{
            border: 1px solid #eee;
            table-layout: fixed;
            width: 100%;
            margin-bottom: 20px;
        }
        table th {
            font-weight: bold;
            padding: 5px;
            background: #efefef;
            border: 1px solid #dddddd;
        }
        table td{
            padding: 5px 10px;
            border: 1px solid #eee;
            text-align: center;
        }
        table tbody tr:nth-child(odd){
            background: #fff;
        }
        table tbody tr:nth-child(even){
            background: #F7F7F7;
        }
        .name{
            width: 100px;
        }
        .location{
            width: 150px;
        }

        input.bot1 {
            display: inline-block;
            font-family: arial,sans-serif;
            font-size: 14px;
            font-weight: bold;
            color: rgb(68,68,68);
            text-decoration: none;
            user-select: none;
            padding: .2em 1.2em;
            outline: none;
            border: 1px solid rgba(0,0,0,.1);
            border-radius: 2px;
            background: rgb(245,245,245) linear-gradient(#f4f4f4, #f1f1f1);
            transition: all .218s ease 0s;

        }
        input.bot1:hover {
            color: rgb(24,24,24);
            border: 1px solid rgb(198,198,198);
            background: #f7f7f7 linear-gradient(#f7f7f7, #f1f1f1);
            box-shadow: 0 1px 2px rgba(0,0,0,.1);
        }
        input.bot1:active {
            color: rgb(51,51,51);
            border: 1px solid rgb(204,204,204);
            background: rgb(238,238,238) linear-gradient(rgb(238,238,238), rgb(224,224,224));
            box-shadow: 0 1px 2px rgba(0,0,0,.1) inset;
        }
    </style>
</header>
<body>
<h2>Работа с мероприятием</h2>
<table class="table">
    <tr>
        <th class="name">Name</th>
        <th >descriptions</th>
        <th class="location">location</th>
        <th>localDateTimeStart</th>
        <th>localDateTimeEnd</th>
        <th>операции</th>
    </tr>
    <c:forEach var="meetings" items="${meetingsList}">
        <%--        <c:url var="deleteButton" value="/deleteEmployee">--%>
        <%--            <c:param name="empId" value="${empls.id}"></c:param>--%>
        <%--        </c:url>--%>
        <tr>
            <td>${meetings.name}</td>
            <td>${meetings.descriptions}</td>
            <td>${meetings.location}</td>
            <td>${meetings.localDateTimeStart}</td>
            <td>${meetings.localDateTimeEnd}</td>
            <td>
                <c:url var="meetDelete" value="/deleteMeeting">
                    <c:param name="meetId" value="${meetings.id}"></c:param>
                </c:url>
                <c:url var="meetUpdate" value="/updateMeeting">
                    <c:param name="meetId" value="${meetings.id}"></c:param>
                </c:url>
                <input class="bot1" type="button" value="удалить" onclick="window.location.href = '${meetDelete}'">
                <input class="bot1" type="button" value="изменить" onclick="window.location.href = '${meetUpdate}'">
            </td>
        </tr>
    </c:forEach>
</table>
<input class="bot1" type="button" value="добавить мероприяте" onclick="window.location.href = '/addNewMeeting'">
</body>
</html>
