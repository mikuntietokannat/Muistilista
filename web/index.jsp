<%-- 
    Document   : index
    Created on : 29.9.2011, 13:39:28
    Author     : miimaija
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muistio</title>
    </head>
    <body>
        <h1>Tervetuloa muistilistapalveluun</h1>
        <h3> ${viesti} </h3>
        
        <form name="kirjaudu sisään"
              action="${pageContext.request.contextPath}/Kirjautumistarkistus"
              method="post">
            Tunnus: <input type="text" name="tunnus" maxlength=15 /> <br/>
            Salasana: <input type="password" name="salasana" maxlength=15 /> <br/>
            <input type="submit" value="Kirjaudu" />
        </form>
              
        Etkö ole vielä rekisteröitynyt?
        <form name="rekisteröidy"
              action="${pageContext.request.contextPath}/uusikayttaja"
              method="post">
            <input type="submit" value="Rekisteröidy" />
        </form>
        
    </body>
</html>
