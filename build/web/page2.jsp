<%-- 
    Document   : page2
    Created on : 27-Jun-2019, 12:57:54
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        
        <% String username = request.getParameter("username");
        String secretKey =request.getParameter("secret-key");
        out.println("Welcome "+ username+ ", your secret key is: " + secretKey);  out.println(request.getQueryString()); %>
  