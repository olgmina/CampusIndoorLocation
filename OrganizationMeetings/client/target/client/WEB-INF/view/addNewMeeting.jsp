<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Создание и изменение</h1>
<form:form action="/saveMeeting"  modelAttribute="meeting">
    <form:hidden path="id"></form:hidden><br/><br>
    Название мероприятия<form:input path="name" ></form:input><br><br>
    
    Локация
    <form:select path="location">
        <c:forEach var="local" items="${locationList}">
            <form:option value="${local.name}" label="${local.name} ${local.equipmentList}"></form:option>
        </c:forEach>
    </form:select><br><br>


    Описание<form:input path="descriptions"></form:input><br><br>
    Дата начала<form:input path="localDateTimeStart" value="2022-04-01 12:02:09"></form:input>
    <form:errors path="localDateTimeStart"></form:errors><br>
    Конец<form:input path="localDateTimeEnd" value="2022-04-01 12:02:09"></form:input>
    <input type="submit">
</form:form>
</body>
</html>
