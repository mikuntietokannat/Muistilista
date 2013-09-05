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
            Nimi:       <input style="margin-left: 4em" type="text" name="nimi" maxlength=30 > <br/>   
            
            Kategoria: 
            <select name="kategoria">
                <c:forEach var="Kategoria" items="${kategorialista}">
                <option value="${Kategoria.id}">${Kategoria.nimi}</option>                             
                </c:forEach>
            </select>   <br/>   
            
            Uusi kategoria:   <input type="text" name="kategoria_uusi" maxlength=30 /> <br/>    
            Tärkeysaste: <input type="radio" name=tarkeys VALUE="1">1  
            <input type="radio" name=tarkeys VALUE="2">2
            <input type="radio" name=tarkeys VALUE="3" CHECKED>3
            <input type="radio" name=tarkeys VALUE="4">4 
            <input type="radio" name=tarkeys VALUE="5">5 <br/>
            <textarea name=teksti rows=16 cols=120 maxlength="5000">
muistiinpanosi
            </textarea> <br/> 
            <input type="submit" value="Luo" />
        </form>
            
        <br/> 
        
        <form name="Takaisin"
            action="${pageContext.request.contextPath}/muistio">
            <input type="submit" value="Peruuta" />
        </form>
            
    </body>
</html>


    <!--     
    select pitää muuttaa niin, että se lähettää eteenpäin kategoria.id:n eikä nimeä, muuten aivan liian virheherkkä systeemi
   
    -->