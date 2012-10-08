<%-- 
    Document   : uusikayttaja
    Created on : 29.9.2011, 13:57:25
    Author     : miimaija
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muistio</title>
    </head>
    <body>
        <h1>Luo käyttäjätunnuksesi</h1>
        <h3> ${viesti} </h3>
            
        <form name="lisaaKayttaja"
              action="${pageContext.request.contextPath}/lisaaKayttaja"
              method="post">
            Tunnus: <input type="text" name="tunnus" maxlength=15 /> <br/>
            Salasana: <input type="password" name="salasana" maxlength=15 /> <br/>
            <input type="submit" value="Luo tunnus" />
        </form>
          
        <br/>      
              
        <form name="Takaisin"
              action="${pageContext.request.contextPath}/index.jsp">
            <input type="submit" value="Takaisin" />
        </form>

            
    </body>
</html>