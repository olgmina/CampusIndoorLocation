<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style> type="text/css"</style>

</head>
<body>
<div class="e1" style="position:absolute; top:20px;left:20px;">
<div>

<form action="Find2" method="get">
Запрос по дню недели

  <input  name="nameGroup" list="org">

       <datalist id="org">
       <option value="бпи-181"/>
       <option value="збаи-171"/>

         </datalist>
      <input  name="typeWeek" list="org2">

                <datalist id="org2">
                <option value="Числитель"/>
                <option value="Знаменатель"/>

                  </datalist>

 <input  name="dayOfWeek" list="org3">

                <datalist id="org3">
                <option value="Понедельник"/>
                <option value="Вторник"/>
                <option value="Среда"/>
                <option value="Четверг"/>
                <option value="Пятника"/>
                 <option value="Суббота"/>

                  </datalist>

    <input type="submit" value="Поиск">
    </div>

</form>
<div class="e2" style="position:absolute; top:60px;left:0px;">
    <div>

    <form action="Find" method="get">
        Запрос по локации
       <input  name="location" list="org4">

       <datalist id="org4">
       <option value="1406"/>
       <option value="1404"/>
       <option value="3429"/>

         </datalist>

         <input  name="typeUniversity" list="org4">

                <datalist id="org4">
                <option value="Строительный"/>
                <option value="Политехнический"/>

                  </datalist>
        <input type="submit" value="Поиск">
        </div>
</form>
<div class="32" style="position:absolute; top:60px;left:0px;">
<div>
<form action="Find4" method="get">
Запрос по предмету

<input  name="nameTitle" list="org">

     <datalist id="org">
     <option value="Релейная защита электрооборудования сельскохозяйственных объектов"/>
     <option value="Электрические станции и подстанции"/>

    <option value="Технологическое предпринимательство(лаб)"/>


                           </datalist>

    <input type="submit" value="Поиск">
    </div>
</form>


<div class="33" style="position:absolute; top:60px;left:0px;">
<div>
<form action="Find3" method="get">

         Запрос по преподователю
         <input  name="organization" list="org7">

          <datalist id="org7">
          <option value="Копытин Алексей Вячеславович"/>
         <option value="Минакова Ольга Владимировна"/>
         <option value="Овсяников Андрей Сергеевич"/>
         <option value="Горемыкин Сергей Александрович"/>
         <option value="Василенко Андрей Владимирович"/>

                       </datalist>

    <input type="submit" value="Поиск">
    </div>
</form>

<div class="34" style="position:absolute; top:60px;left:2px;">

<form action="Find5" method="get">
Запрос по началу пары
<input  name="startData" list="org">
<datalist id="org">
<option value="8:30:00"/>
<option value="10:15:00"/>
<option value="12:00:00"/>
<option value="14:20:00"/>
<option value="16:05:00"/>
<option value="19:25:00"/>

            </datalist><input type="submit" value="Поиск">

    </div>
</form>
</body>
</html>