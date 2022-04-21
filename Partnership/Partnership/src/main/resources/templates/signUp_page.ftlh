<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CampusIndoorLocation</title>
    <style>
        a:hover{
            background: black;
            color: white;
        }
        a {
            color: black;
            text-transform: uppercase;
            text-decoration: none;
            display: block;
            font-size: 14px;
            text-align: center;
            Letter-spacing: 0.1em;
            padding: 17px 40px;
            border: 1px solid black;
            width: 200px;
            transition: all 0.5s ease;
        }
        input.reg:hover{
            background: black;
            color: white;
        }
        input {
            font-size: 14px;
            text-align: center;
            Letter-spacing: 0.1em;
            padding: 10px 1px;
            width: 238px;
            transition: all 0.5s ease;
        }
        input .reg {
            display: block;
            font-size: 14px;
            text-align: center;
            Letter-spacing: 0.1em;
            padding: 10px 1px;
            width: 238px;
            transition: all 0.5s ease;
        }
        form {
            margin-top: 10px;
            margin-bottom: 40px;
            height: 1em;
            display: flex;
            justify-content: center;
            font-size: 40px;
        }
        h1 {
            margin-top: 300px;
            margin-bottom: 40px;
            height: 1em;
            display: flex;
            justify-content: center;
            font-size: 40px;
        }
    </style>
</head>

<body bgcolor="#ffc632">
<header id="header" class="header">
    <div class="container">
        <a href="index">Назад</a>
        <h1>CampusIndoorLocation</h1>
    </div>
</header>
<div>
    <section id="signUP" class="signUp">
        <div class="container">
        </div>
    </section>

<div>
    <form action="/signUp" method="post">
        <input name="firstName" placeholder="Имя">
        <input name="lastName" placeholder="Фамилия">
        <input name="email" placeholder="Email">
        <input name="password" placeholder="Пароль" type="password">
        <input class="reg" type="submit" value="Войти">
    </form>
</div>
</body>
</html>