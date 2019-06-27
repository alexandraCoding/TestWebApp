<%-- 
    Document   : newstudent
    Created on : 26-Jun-2019, 11:58:05
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Student</title>
    </head>
    <body>
        <h1><%= request.getAttribute("title")%></h1>
        <form method="POST" action="InsertStudent">
        Name:<input name="name" type="text"/>
        Surname:<input name="surname" type="text"/>
        Grade:<input name="grade" type="number"/>
        BirthDate:<input name="birthdate" type="date"/>
        <input type="submit" value="New" name="NewStudent" />
        </form>
    </body>
</html>
