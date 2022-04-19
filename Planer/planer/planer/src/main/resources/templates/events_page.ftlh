<!doctype html>
<html lang="en">
<meta charset="UTF-8">
 <style> type="text/css"</style>
<title>Document</title>
<head>
<style>
table {
border-spacing: 0;
empty-cells: hide;
}
td {
padding: 10px 20px;
text-align: center;
border-bottom: 1px solid #F4EEE8;
transition: all 0.5s linear;
}
td:first-child {
text-align: left;
color: #3D3511;
font-weight: bold;
}
th {
padding: 10px 20px;
color: #3D3511;
border-bottom: 1px solid #F4EEE8;
border-top-left-radius: 10px;
border-top-right-radius: 10px;
}
td:nth-child(even) {
background: #F6D27E;
}
td:nth-child(odd) {
background: #D1C7BF;
}
th:nth-child(even)  {
background: #F6D27E;
}
th:nth-child(odd)  {
background: #D1C7BF;
}
.round-top {
border-top-left-radius: 5px;
}
.round-bottom {
border-bottom-left-radius: 5px;
}
tr:hover td{
background: #FFA500;
font-weight: bold;
}
</style>
</head>

<body>
<div class="e1" style="position:absolute; top:50px;left:40px;">
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