<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, organizational-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form action="/signUp" method = "post">
        <input name="name" placeholder="ФИО">
        <input name="eventName" placeholder="Название события">
        <input name="members" placeholder="Участники">
        <input name="eventTime" placeholder="Время">
        <input name="location" placeholder="Локация">
        <select name="status">
            <option value="Проведено">Проведено</option>
            <option value="Отменено">Отменено</option>
            <option value="Ожидается">Ожидается</option>
        </select>
        <select name="category">
            <option value="Учебное">Учебное</option>
            <option value="Внеучебное">Внеучебное</option>
            <option value="Организационное">Организационное</option>
        </select>
        <input type = "submit" value="Добавить">
    </from>
</div>
    <a href="users">Назад</a>
</body>
</html>