<!doctype html>
<html lang="ru">


<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CampusIndoorLocation</title>
    <style>

       h1 {
           height: 10em;
           display: flex;
           /*align-items: center;*/
           justify-content: center
       }
    </style>
</head>
<body bgcolor="#ffc632">
    <header id="header" class="header">
        <div class="container">
            <h1>CampusIndoorLocation</h1>
        </div>
    </header>
<div>
    <section id="signUP" class="signUp">
        <div class="container">
        </div>
    </section>




    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>