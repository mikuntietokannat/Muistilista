<%-- 
    Document   : lista
    Created on : 7.10.2011, 13:18:56
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
        <h1>Muistiot</h1>
        <h3> ${viesti} </h3>
        
        <form name="uusi muistio"
              action="${pageContext.request.contextPath}/uusimuistio" method="post">
            <input type="submit" value="Luo uusi muistio" />
        </form>
            
        <form name="kirjaudu ulos"
              action="${pageContext.request.contextPath}/Kirjautumistarkistus" method="get">
            <input type="submit" value="Kirjaudu ulos" />
        </form>
        
        <br/> 
                
        <c:forEach var="kayttaja" items="${lista}">
            ${kayttaja.tunnus} <br/>
        </c:forEach>
            
    </body>
</html>

   <!--     

   
    -->