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
        
          <!-- 
        <c:choose>
            <c:when test="${empty muistiolista}">
                <p>Sinulla ei ole yhtään muistiota (kat)</p>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="Kategoria" items="${kategorialista}">
                        <li><a href="uusimuistio?id=${Muistio.id}">${Kategoria.nimi} Tärkeys: ${Muistio.tarkeys} Kategoria: ${Muistio.kategoria}</a></li> 
                    </c:forEach>
                </ul>  
            </c:otherwise>
        </c:choose>    
              -->  
          
        <c:choose>
            <c:when test="${empty muistiolista}">
                <p>Sinulla ei ole yhtään muistiota</p>
            </c:when>
            <c:otherwise>
                <ul>
                    <c:forEach var="Muistio" items="${muistiolista}">
                        <li>${Muistio.nimi} [Tärkeys: ${Muistio.tarkeys}] [Kategoria: ${Muistio.kategoria.nimi}]<a href="uusimuistio?id=${Muistio.id}"> Avaa </a></li> 
                    </c:forEach>
                </ul>  
            </c:otherwise>
        </c:choose>
                
        <form name="jarjesta" 
              action="${pageContext.request.contextPath}/muistio" method="post">
            <input type="submit" value="Järjestä uudelleen" />
            <select name="setjarjestys">              
                <c:if test="${jarjesta==2}">
                    <option value=1 >Nimi </option>                              
                    <option value=2 selected="selected">Tärkeys </option>                           
                </c:if>
                <c:if test="${jarjesta==1}">
                    <option value=1 selected="selected">Nimi </option>                              
                    <option value=2>Tärkeys </option>                           
                </c:if>                   
            </select>          
        </form>
        
        <form name="uusi muistio"
              action="${pageContext.request.contextPath}/uusimuistio" method="post">
            <input type="submit" value="Luo uusi muistio" />
        </form>
         
        <br/> 
            
        <form name="kirjaudu ulos"
              action="${pageContext.request.contextPath}/Kirjautumistarkistus" method="get">
            <input type="submit" value="Kirjaudu ulos" />
        </form>
            
    </body>
</html>

   <!--    
  <<< ${lista.oletus ? 'checked="checked"' : ''}
   <li><a href="lista?lista=${muistio.id}">${muistio.nimi}</a></li>
   
   <li>${Muistio.id}>${Muistio.nimi}<a href="muistio">[katso]</a></li>
   
   <a href="uusimuistio?muistio=${Muistio.muistioid}">[katso]</a>
   
   
   
    --> 