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
        <title>Humhum? tämä ei näy?</title>
    </head>
    <body>
        <h1>Luo käyttäjätunnuksesi</h1>
        <h3> ${viesti} </h3>
            
        <form name="lisaaKayttaja"
              action="${pageContext.request.contextPath}/lisaaKayttaja"
              method="post">
            Tunnus: <input type="text" name="tunnus" /> <br/>
            Salasana: <input type="text" name="salasana" /> <br/>
            <input type="submit" value="Rekisteröidy" />
        </form>
    </body>
</html>