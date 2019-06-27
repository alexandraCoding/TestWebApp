<%-- 
    Document   : updatestudent
    Created on : 26-Jun-2019, 15:28:49
    Author     : alexa
--%>

<%@page import="Entities.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Student</title>
    </head>
    
      
        <h1><%= request.getAttribute("Update")%></h1>

        <form method="POST" action="UpdateStudent" >
            id:<input name= "id" type="number" value="<%= request.getAttribute("id")%>"/><br>
            Name:<input name= "name" type="text" value="<%= request.getAttribute("name")%>"/><br>
            Surname:<input name="surname" type="text" value="<%= request.getAttribute("surname")%>"/><br>
            Grade:<input name="grade" type="number" value="<%= request.getAttribute("grade")%>"/><br>
            BirthDate:<input name="birthdate" type="date" value="<%= request.getAttribute("birthdate")%>"/><br>
            <input type="submit" value="Update" name="UpdateStudent" /><br>
         
        </form>
    

