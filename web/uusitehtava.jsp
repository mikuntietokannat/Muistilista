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
        <title>Muistio</title>
    </head>
    <body>
        <h1>${viesti}</h1>
        <form action="${pageContext.request.contextPath}/muokkaa"
              method="get">
            Nimi:        <input style="margin-left: 5em" type="text" name="nimi" maxlength=30 /> <br/>            
            Kategoria: 
            <select name="kategoria">
                <c:forEach var="Kategoria" items="${Kategoria}">
                <option value="${Kategoria.getId}">${Kategoria.getNimi}</option>
                </c:forEach>
            </select>   <br/>              
            Uusi kategoria:   <input type="text" name="kategoria_uusi" maxlength=30 /> <br/>    
            Tärkeysaste: <input type="radio" name=tarkeys VALUE="1" CHECKED>  
            <input type="radio" name=tarkeys VALUE="2">
            <input type="radio" name=tarkeys VALUE="3"> 
            <input type="radio" name=tarkeys VALUE="4"> 
            <input type="radio" name=tarkeys VALUE="5"> <br/>
            Teksti: <input type="text" name="teksti" size=250 /> <br/> 
            <input type="submit" value="Luo" />
        </form>
            
            <br/> 
            ____________________________________________________________________
            <br/> 
            
            <form name="Takaisin"
              action="${pageContext.request.contextPath}/muistio">
            <input type="submit" value="Takaisin" />
            </form>
            
    </body>
</html>
