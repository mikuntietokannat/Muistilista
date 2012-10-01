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
        <h1>Tehtävälista</h1>
        <h3> ${viesti} </h3>
        
        <form name="uusi muistio"
              action=<%pageContext.forward("uusitehtava.jsp");%> 
            <input type="submit" value="uusi muistio" />
        </form>
        
        <br/> 
        
        
        <c:forEach var="kayttaja" items="${lista}">
            ${kayttaja.tunnus} <br/>
        </c:forEach>
            
    </body>
</html>

   <!--     
   
        <form name="muistiinpano"
              action="${pageContext.request.contextPath}/Lisaatehtava"
              method="post">
              <input type="submit" value="uusi muistio" />
        </form>
              
        <form name="uusi muistio"
            action=$pageContext.forward(uusitehtava.jsp)>
            <input type="submit" value="uusi muistio" />
        </form>
              
        <a href="http://localhost:8080//examples/jsp//login.jsp">view</a>;       
    -->