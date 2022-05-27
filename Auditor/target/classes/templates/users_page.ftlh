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
        button {
            color: white;
            background: #083353;
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
            text-align: center;
            min-width: 175px;
        }
        .table__price th {
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
        <caption>Список мероприятий</caption>
        <tr>
            <th>ФИО</th>
            <th>Мероприятие</th>
            <th>Участники</th>
            <th>Время</th>
            <th>Локация</th>
            <th>Статус</th>
            <th>Категория</th>
            <th></th>
        </tr>
        <#list organizationals as organizational>
            <tr>
                <td>${organizational.name}</td>
                <td>${organizational.eventName}</td>
                <td>${organizational.members}</td>
                <td>${organizational.eventTime}</td>
                <td>${organizational.location}</td>
                <td>${organizational.status}</td>
                <td>${organizational.category}</td>
                <td><a><button onClick="delClicked(${organizational.id})">Удалить</button></a></td>
            </tr>
        </#list>
        <tr>
            <td><a href="signUp">Добавить</a></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <div>Кол-во мероприятий</div>
                <div>
                     <span>Проведенных: </span>
                     <span id="statusProv"></span>
                </div>
                <div>
                     <span>Ожидаемых: </span>
                     <span id="statusOzh"></span>
                </div>
                <div>
                     <span>Отмененных: </span>
                     <span id="statusOtm"></span>
                </div>
            </td>
            <td>
                <div>Кол-во мероприятий</div>
                <div>
                    <span>Организационных: </span>
                    <span id="categoryOrg"></span>
                </div>
                <div>
                     <span>Учебных: </span>
                     <span id="categoryUch"></span>
                </div>
                <div>
                     <span>Внеучебных: </span>
                     <span id="categoryNeu"></span>
                </div>
            </td>
            <td></td>
        </tr>
    </table>
</section>
    <script>
        const deleteData = async (id) => {
            const response = await fetch("http://localhost:8080/delete/" + id, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                }
            })
            if(!response.ok) document.location.reload();
        }

        const delClicked = (id) => {
            deleteData(id);
        }

        const getAmount = async (url, elem) => {
            const response = await fetch(url);
            if(response.ok) response.json().then(result => {
                elem.innerHTML = result;
            });
        }

        (function renderAmount() {
            getAmount("http://localhost:8080/amount/category/org", document.getElementById("categoryOrg"));
            getAmount("http://localhost:8080/amount/category/uch", document.getElementById("categoryUch"));
            getAmount("http://localhost:8080/amount/category/neu", document.getElementById("categoryNeu"));
            getAmount("http://localhost:8080/amount/status/prov", document.getElementById("statusProv"));
            getAmount("http://localhost:8080/amount/status/ozh", document.getElementById("statusOzh"));
            getAmount("http://localhost:8080/amount/status/otm", document.getElementById("statusOtm"));
        })();
    </script>
</body>
</html>