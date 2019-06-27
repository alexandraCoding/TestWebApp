<%-- 
    Document   : example
    Created on : 26-Jun-2019, 15:41:45
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         </head>
          <body>
         
         <jsp:useBean id="student" class="Entities.Student" scope="page" />
         <jsp:setProperty name="Student" property="surname" value="Tasos"/>
   Student Surname :<%=student.getSurname()%>
   <h1><%= request.getAttribute("title")%></h1>
        <form method="POST" action="InsertStudent">
        Name:<input name="name" type="text"/>
        Surname:<input name="surname" type="text"/>
        Grade:<input name="grade" type="number"/>
        BirthDate:<input name="birthdate" type="date"/>
        <input type="submit" value="New" name="NewStudent" />
           
    </body>
</html>
