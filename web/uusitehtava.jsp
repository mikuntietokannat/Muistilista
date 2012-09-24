<%-- 
    Document   : uusitehtava
    Created on : 24-Sep-2012, 14:36:55
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
        <h1>Luo uusi muistiinpano</h1>
        <form name="lisaaKayttaja"
              action="${pageContext.request.contextPath}/lisaaTehtava"
              method="post">
            Nimi: <input type="text" name="nimi" /> <br/>
            Kategoria: <input type="text" name="kategoria" /> <br/>
            Tärkeysaste: <input type="text" name="tärkeysaste" /> <br/>
            <select name="kategorid">
                    <c:forEach var="Kategoria" items="${Kategoria}">
                        <option value="${Kategoria.getId}">${Kategoria.getNimi}</option>
                    </c:forEach>
                </select><br/>
            <input type="submit" value="Luo" />
        </form>
    </body>
</html>
