<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>  body, div, td {
                 font-family: Montserrat, sans-serif;
                 font-weight: bold;
                 color: #212529;
             }
             body {top:20px;
             align="center";
                 color: #212529;
                 font-weight: bold;
             }
             .a {
             display: inline-block;
             box-sizing: border-box;
             padding: 0 20px;
             margin: 0 15px 15px 0;
             outline: none;
             border: none;
             border-radius: 4px;
             height: 28px;
             line-height: 32px;
             font-size: 14px;
             font-weight: 500;
             text-decoration: none;
             color: #fff;
             background-color:  #343a40;
             box-shadow: 0 2px #21487f;
             cursor: pointer;
             user-select: none;
             appearance: none;
             touch-action: manipulation;
             vertical-align: top;
             }

td:last-of-type {
text-align: center;}

             div{
             margin-top:6%
             }

             hr{border:none;
             background-color: #343a40;
             color: #343a40;
             height:2px;}

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
         h3{
          margin: 1em 0 0.5em 0;
                  color: #343434;
                  font-size: 16px;

                  font-weight: normal;
                  text-transform: uppercase;
                  font-family: 'Orienta', sans-serif;
                  letter-spacing: 1px;
                  font-style: italic;}


</style>
</head>
<body>


<p><h1><center> Planer </center></h1></p>
<hr>
<div>
</div>
<p><center>
<form action="Find2" method="get">
<h3>Запрос по дню недели</h3>

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

   <a> <input type="submit" value="Поиск" class="a"> </a>

    </center>
</p>
</form>
<p><center>


    <form action="Find" method="get">
      <h3>  Запрос по локации</h3>
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
      <input type="submit" value="Поиск" class="a">

</form>
</center>
</p>
<p><center>

<form action="Find4" method="get">
<h3>Запрос по предмету</h3>

<input  name="nameTitle" list="org">

     <datalist id="org">
     <option value="Релейная защита электрооборудования сельскохозяйственных объектов"/>
     <option value="Электрические станции и подстанции"/>

    <option value="Технологическое предпринимательство(лаб)"/>


                           </datalist>

   <input type="submit" value="Поиск" class="a">

</form>
</center>
<p><center>
<form action="Find3" method="get">
<h3>Запрос по времени</h3>



<input  name="startData" list="org">

     <datalist id="org">
<option value="8:30:00"/>
<option value="10:15:00"/>
<option value="12:00:00"/>
<option value="14:20:00"/>
<option value="16:05:00"/>
<option value="19:25:00"/>
                           </datalist>
 <input type="submit" value="Поиск" class="a">
    </div>
</form>
</p></center>

<p><center>
<form action="Find5" method="get">
<h3>Запрос по преподавателю</h3>

<input  name="organization" list="org">

     <datalist id="org">
   <option value="Копытин Алексей Вячеславович"/>
         <option value="Минакова Ольга Владимировна"/>
         <option value="Овсяников Андрей Сергеевич"/>
         <option value="Горемыкин Сергей Александрович"/>
         <option value="Василенко Андрей Владимирович"/>



                           </datalist>
   <input type="submit" value="Поиск" class="a">

    </div>
</form>
</body>
</html>
