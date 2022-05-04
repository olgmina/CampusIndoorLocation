<html lang="en">
<head>
    <title>Admin_Server</title>
    <meta http-equiv="Content-Type" content="text/ftlh; charset=utf-8">
    <style>
        /*Обнуление*/
        *{
            padding: 0;
            margin: 0;
            border: 0;
        }
        *,*:before,*:after{
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
        }
        :focus,:active{outline: none;}
        a:focus,a:active{outline: none;}

        nav,footer,header,aside{display: block;}

        html,body{
            height: 100%;
            width: 100%;
            line-height: 1;
            font-size: 14px;
            -ms-text-size-adjust: 100%;
            -moz-text-size-adjust: 100%;
            -webkit-text-size-adjust: 100%;
        }
        input,button,textarea{font-family:inherit;}

        input::-ms-clear{display: none;}
        button{cursor: pointer;}
        button::-moz-focus-inner {padding:0;border:0;}
        a, a:visited{text-decoration: none;}
        a:hover{text-decoration: none;}
        ul li{list-style: none;}
        img{vertical-align: top;}

        h1,h2,h3,h4,h5,h6{font-size:inherit;font-weight: 400;}
        /*--------------------*/

        /*Основная часть*/
        *{
            scroll-behavior: smooth;
        }
        body {
            margin: 0;
            padding: 0;
        }
        section {
            padding-bottom: 50px;
            padding-top: 50px;
            position: relative;
            width: 100%;
            height: auto;
            display: flex;
            justify-content: center;

            font-size: 3em;
            font-weight: 800;
        }
        section:nth-child(odd) {
            background: #a4f9ff;
        }
        section:nth-child(even) {
            background: #8ed7ff;
        }
        nav {
            position: fixed;
            top: 0;
            width: 100%;
            text-align: center;
            background: #083353;
        }
        nav a {
            position: relative;
            color: aliceblue;
            text-decoration: none;
            padding: 8px 25px;
            font-size: 1.5em;
            display: inline-block;
        }
        nav a:hover{
            background: #a8e9f1;
            color: #0e3e44;
        }
        nav a:active{
            background: #94fab3;
        }
        /*--------------------*/
        /* Таблица */
        .table__price {
            border-collapse: collapse;
            border-left: 3px solid #263145;
            border-right: 3px solid #263145;
            border-bottom: 3px solid #263145;
            font-family: "Lucida Grande", sans-serif;
            width: 100px;
        }
        .table__price caption {
            background: #263145;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
            padding: 10px;
            box-shadow: 0 2px  4px 0 rgba(0,0,0,.3);
            color: white;
            font-family: "Roboto Slab",serif;
            font-style: normal;
            font-size: 26px;
            text-align: center;
            margin: 0;
        }
        .table__price td, .table__price th {
            padding: 10px;
        }
        .table__price th {
            text-align: left;
            font-size: 18px;
        }
        .table__price tr:nth-child(odd) {
            background: #a4f9ff;
        }
        .table__price tr:nth-child(even) {
            background: #8ed7ff;
        }
        .table__price td:last-of-type {
            text-align: center;
        }
        .table__price a {
            display: inline-block;
            padding: 5px 10px;
            background: #083353;
            color: white;
            box-shadow: 2px 2px 0 0 gray;
            /*position: relative;*/
        }
        .table__price a:hover {
            box-shadow: none;
            top: 2px;
            left: 2px;
        }

        /*--------------------*/
    </style>
</head>
<body>
<section id="n1">
    <table class="table__price">
        <caption>Внеучебные мероприятия</caption>
        <tr>
            <th>ФИО</th>
            <th>Мероприятие</th>
            <th>Категория</th>
            <th>Дата</th>
        </tr>
        <#list organizationals as user2>
            <td>${user2.fio}</td>
            <td>${user2.event}</td>
            <td>${user2.category}</td>
            <td>${user2.data}</td>
        </#list>
        <tr>
            <td><a href="signUp">Добавить</a></td>
            <td><a href="#">Удалить</a></td>
        </tr>
    </table>
</section>
<section id="n2">
    <table class="table__price">
        <caption>Учебные мероприятия</caption>
        <tr>
            <th>ФИО</th>
            <th>Мероприятие</th>
            <th>Категория</th>
            <th>Дата</th>
        </tr>
        <#list organizationals as user1>
            <td>${user1.fio}</td>
            <td>${user1.event}</td>
            <td>${user1.category}</td>
            <td>${user1.data}</td>
        </#list>
        <tr>
            <td><a href="signUp">Добавить</a></td>
            <td><a href="#">Удалить</a></td>
        </tr>
    </table>
</section>

<section id="n3">

    <table class="table__price">
        <caption>Организационные мероприятия</caption>
        <tr>
            <th>ФИО</th>
            <th>Мероприятие</th>
            <th>Категория</th>
            <th>Дата</th>
        </tr>
        <#list organizationals as organizational>
            <td>${organizational.fio}</td>
            <td>${organizational.event}</td>
            <td>${organizational.category}</td>
            <td>${organizational.data}</td>
        </#list>
        <tr>
            <td><a href="signUp">Добавить</a></td>
            <td><a href="#">Удалить</a></td>
        </tr>
    </table>
</section>
<nav>
    <a href="#n1">Учебные </a>
    <a href="#n2">Внеучебные </a>
    <a href="#n3">Организационные </a>
</nav>

</body>
</html>