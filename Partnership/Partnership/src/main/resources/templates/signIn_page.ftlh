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
            display: block;
            font-size: 17px;
            text-align: center;
            Letter-spacing: 0.1em;
            padding: 17px 47px;
            border: 1px solid black;
            width: 238px;
            color: black;
            text-transform: uppercase;
            text-decoration: none;
            transition: all 0.5s ease;
        }
        h1 {
            margin-top: 200px;
            margin-bottom: 40px;
            height: 1em;
            display: flex;
            justify-content: center;
            font-size: 40px;
        }

.wrapper table {
    border-collapse: collapse;
    width: 1217px;
}
.wrapper td, th{
    margin: 0 auto;
    justify-content: center;
    border: 1px solid #888;
}
.wrapper .hide{
    margin: 0 auto;
    justify-content: center;
    background: #ff9;
    display: none;
}
    </style>

</head>
<header id="header" class="header">
<div class="container">
    <a href="index">Назад</a>
    <h1>CampusIndoorLocation</h1>
</div>
</header>
<body bgcolor="#ffc632">

<div class="wrapper">
    <form action="">
        <input type="text" placeholder="Неделя"
               autofocus="on" />
        <input  type="text" placeholder="Учебный блок"/>
        <input  type="text" placeholder="День недели"/>
        <input  type="text" placeholder="Аудитория"/>
        <input  type="text" placeholder="Группа"/>
        <input  type="text" placeholder="Предмет"/>
        <input  type="text" placeholder="Преподаватель"/>
    </form>
    <table>
        <tr>
            <th>Неделя</th>
            <th>Учебный блок</th>
            <th>Понедельник</th>
            <th>Аудитория</th>
            <th>Группа</th>
            <th>Предмет</th>
            <th>Преподаватель</th>
        </tr>
        <tr>
            <td>Числитель</td>
            <td>Строительный</td>
            <td>Вторник</td>
            <td>4219</td>
            <td>бПИ-181</td>
            <td>Экономика</td>
            <td>Курочка А.В.</td>
        </tr>
    <tr>
        <td>Знаменатель</td>
        <td>Строительный</td>
        <td>Понедельник</td>
        <td>5422</td>
        <td>пСАУ-191</td>
        <td>Профессиональная этика</td>
        <td>Дорохова Р.В.</td>
    </tr>
    <tr>
        <td>Числитель</td>
        <td>Политехнический</td>
        <td>Среда</td>
        <td>2231</td>
        <td>брстр-203</td>
        <td>Экономика</td>
        <td>Курочка А.В.</td>
    </tr>
        <tr>
            <td>Числитель</td>
            <td>Политехнический</td>
            <td>Пятница</td>
            <td>1111</td>
            <td>брстр-143</td>
            <td>Физкультура</td>
            <td>Рогозин М.С.</td>
        </tr>
        <tr>
            <td>Знаменатель</td>
            <td>Политехнический</td>
            <td>Четверг</td>
            <td>2331</td>
            <td>брстр-203</td>
            <td>Русский язык</td>
            <td>Волочкина С.Я.</td>
        </tr>
        <tr>
            <td>Числитель</td>
            <td>Строительный</td>
            <td>Вторник</td>
            <td>6321</td>
            <td>бПИ-181</td>
            <td>Физкультура</td>
            <td>Остриков Р.К.</td>
        </tr>
    </table>
</div>
<br>
<br>
<a href="#">Записаться</a>

<script>
    function formTable(selector) {
        var wrapper = document.querySelector(selector);
        var form = wrapper.getElementsByTagName("form")[0];
        var table = wrapper.getElementsByTagName("table")[0];

        form.onkeyup = function (ev) {

            var
                dt = form.elements[0].value,
                block = form.elements[1].value,
                day = form.elements[2].value;
                audit = form.elements[3].value;
                group = form.elements[4].value;
                object = form.elements[5].value;
                teacher = form.elements[6].value;

            for(var i = 1; i < table.rows.length; i++){
                table.rows[i].className = "";

                if (
                    table.rows[i].cells[0].innerHTML.indexOf(dt) ==-1 ||
                    table.rows[i].cells[1].innerHTML.indexOf(block) ==-1 ||
                    table.rows[i].cells[2].innerHTML.indexOf(day) ==-1 ||
                    table.rows[i].cells[3].innerHTML.indexOf(audit) ==-1 ||
                    table.rows[i].cells[4].innerHTML.indexOf(group) ==-1 ||
                    table.rows[i].cells[5].innerHTML.indexOf(object) ==-1 ||
                    table.rows[i].cells[6].innerHTML.indexOf(teacher) ==-1
                ) {
                    table.rows[i].className = "hide";
                }
            }
        }
    }
    formTable(".wrapper");
</script>
</body>
</html>