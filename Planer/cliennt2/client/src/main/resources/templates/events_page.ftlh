<!doctype html>
<html lang="en">
<meta charset="UTF-8">
<title>Document</title>
<head>
</head>
<body>
<div>
<table>

<th>ID</th>
<th>Day_of_Week</th>
<th>start_data</th>
<th>end_data</th>
<th>location</th>
<th>name_group</th>
<th>name_title</th>
<th>organization</th>
<th>type_university</th>
<th>type_week</th>




</tr>
<#list events as event>
<tr>
<td>${event.id}</td>
<td>${event.dayOfWeek}</td>
<td>${event.startData}</td>
<td>${event.endData}</td>
<td>${event.location}</td>
<td>${event.nameGroup}</td>
<td>${event.nameTitle}</td>
<td>${event.organization}</td>
<td>${event.typeUniversity}</td>
<td>${event.typeWeek}</td>


</tr>
</#list>



</table>
</div>
</body>
</html>