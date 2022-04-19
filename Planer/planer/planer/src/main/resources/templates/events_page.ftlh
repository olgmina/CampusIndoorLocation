<!doctype html>
<html lang="en">
<meta charset="UTF-8">
 <style> type="text/css"</style>
<title>Document</title>
<head>
<style>
@font-face {
font-family: Montserrat;
font-weight: normal;
src: url(/local/templates/vstu/css/fonts/Montserrat-Regular.ttf);
}
  hr{border:none;
              background-color: #343a40;
              color: #343a40;
              height:2px;}


element.style {
}
header {
    font-size: 16px;
}
div, header, footer, a, li, input, select, textarea, button, aside, article {
    box-sizing: border-box;
}
article, aside, figcaption, figure, footer, header, hgroup, main, nav, section {
    display: block;
}
*, ::after, ::before {
    box-sizing: border-box;
}
user agent stylesheet
header {
    display: block;
}
body, div, td {
    font-family: Montserrat, sans-serif;
    font-weight: bold;
    color: #212529;
}
body {
    color: #212529;
    font-weight: bold;
}


@font-face {
font-family: MontserratBold;
src: url(/local/templates/vstu/css/fonts/Montserrat-Bold.ttf);
}



div, header, footer, a, li, input, select, textarea, button, aside, article {
box-sizing: border-box;
}

a, .btn-link {
color: #295296;
position: relative;
transition: .3s;
}

a:hover, .btn-link:hover {
color: #263145;
color: hsl(219deg 29% 40%);
color: hsl(217deg 57% 65%);
/*opacity: 80%;*/
text-decoration: unset;
}

button:focus {
outline: none;
}



h1{
 margin: 1em 0 0.5em 0;
         color: #343434;
         font-size: 28px;
         line-height: 40px;
         font-weight: normal;
         text-transform: uppercase;
         font-family: 'Orienta', sans-serif;
         letter-spacing: 1px;
         font-style: italic;
}
h2, .h2 {
text-transform: uppercase;
font-size: 1.5rem;
color: #343a40;
margin-bottom: 0.75rem;
}

h3, .h3 {
font-size: 1.5rem;
color: #263145;
}


h6, .h6 {
font-size: 1rem;
font-weight: bold;
}

h1 a, .h1 a, h2 a, .h2 a, h3 a, .h3 a, h4 a, .h4 a, h5 a, .h5 a, h6 a, .h6 a {
color: #263145;
}

small, .small {
font-size: 0.875rem;
}

kbd {
background-color: #667388;
}

pre {
white-space: pre-wrap;
color: #667388;
}
th {
border-bottom: 3px ;
padding: 10px;
text-align: left;
}
td {
padding: 10px;
}
tr:nth-child(odd) {
background: white;
}
tr:nth-child(even) {
background: #E8E6D1;
}


.container {
position: relative;
/*
padding-right: 0px;
padding-left: 0px;
*/
}

min-width: 1200px {
.container {
max-width: 1199px;
}
}

table {
color: #667388;


form-control {
position: relative;
width: auto;
margin-right: 30px;
color: #E6EFFF;
background-color: transparent;
border: none;
border-bottom: 2px solid #B5C6E2;
border-radius: 0;
z-index: 2;
transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}

form-control:focus {
color: unset;
background-color: unset;
border-color: unset;
box-shadow: unset;
}

.form-control-plaintext {
color: #667388;
}

.was-validated .form-control:valid, .form-control.is-valid {
padding-right: unset;
}

.was-validated .form-control:valid:focus, .form-control.is-valid:focus {
border-color: #28a745;
box-shadow: 0 0 0 0.2rem rgba(40, 167, 69, 0.25);
}

.was-validated .form-control:valid:focus, .form-control.is-valid:focus {
border-color: unset;
box-shadow: unset;
}

.was-validated .form-control:invalid, .form-control.is-invalid {
padding-right: unset;
}

.was-validated .form-control:invalid:focus, .form-control.is-invalid:focus {
border-color: unset;
box-shadow: unset;
}

.card-header {
padding: 0.25rem 0.5rem;
}
</style>
</head>




<body>
<div class="e1" style="position:absolute; top:50px;left:40px;">
<div>

<p><h1><center> Planer </center></h1></p>
<hr>
<div>

<table>
<tr>
<th>Номер</th>
<th>Тип недели</th>
<th>Тип университета</th>
<th>День недели</th>
<th>Начало пары</th>
<th>Конец пары</th>
<th>Аудитория</th>
<th>Название группы</th>
<th>Название предмета</th>
<th>Организатор</th>



</tr>
<#list events as event>
<tr>
<td>${event.id}</td>
<td>${event.typeWeek}</td>
<td>${event.typeUniversity}</td>
<td>${event.dayOfWeek}</td>
<td>${event.startData}</td>
<td>${event.endData}</td>
<td>${event.location}</td>
<td>${event.nameGroup}</td>
<td>${event.nameTitle}</td>
<td>${event.organization}</td>


</tr>

</#list>
</div>


</table>
</div>
</body>
</html>
