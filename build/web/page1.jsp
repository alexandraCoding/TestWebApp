<%-- 
    Document   : page1
    Created on : 27-Jun-2019, 12:57:37
    Author     : alexa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

   
   
        <% String username= request.getParameter("username");
        if(!username.equals("admin")){
            throw new Exception("Unauthorized Access");
        }else{ %>
        <jsp:include page="page2.jsp"> 
            <jsp:param name="secret-key" value="<%= secretKey %>" />
        </jsp:include>
       <% } %>
       
       <%! private String secretKey= "1234";%> 
        
        
   

