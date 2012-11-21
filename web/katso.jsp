<%-- 
    Document   : muokkaa
    Created on : 15-Oct-2012, 16:23:05
    Author     : miimaija
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${muistio.nimi}</title>
    </head>
    <body>
        <b>${muistio.nimi}</b>
        <br/> 
        <br/> 
        <form action="${pageContext.request.contextPath}/muokkaa"
              method="post" name="muokkaus">
            Nimi:<input type="text" name="nimi" maxlength=30 value="${muistio.nimi}"> <br/>   
            <textarea name=teksti rows=16 cols=120 maxlength="5000">
${muistio.kuvaus}
            </textarea>            
            <br/>                           
            Muuta tärkeyttä: 
            <c:if test="${muistio.tarkeys==1}">
                <input type="radio" name=tarkeys VALUE="1" CHECKED>1
                <input type="radio" name=tarkeys VALUE="2">2
                <input type="radio" name=tarkeys VALUE="3">3
                <input type="radio" name=tarkeys VALUE="4">4 
                <input type="radio" name=tarkeys VALUE="5">5 
            </c:if>
            <c:if test="${muistio.tarkeys==2}">
                <input type="radio" name=tarkeys VALUE="1">1
                <input type="radio" name=tarkeys VALUE="2" CHECKED>2
                <input type="radio" name=tarkeys VALUE="3">3
                <input type="radio" name=tarkeys VALUE="4">4 
                <input type="radio" name=tarkeys VALUE="5">5                                     
            </c:if>
            <c:if test="${muistio.tarkeys==3}">
                <input type="radio" name=tarkeys VALUE="1">1
                <input type="radio" name=tarkeys VALUE="2">2
                <input type="radio" name=tarkeys VALUE="3" CHECKED>3
                <input type="radio" name=tarkeys VALUE="4">4 
                <input type="radio" name=tarkeys VALUE="5">5                                     
            </c:if>
            <c:if test="${muistio.tarkeys==4}">
                <input type="radio" name=tarkeys VALUE="1">1
                <input type="radio" name=tarkeys VALUE="2">2
                <input type="radio" name=tarkeys VALUE="3">3
                <input type="radio" name=tarkeys VALUE="4" CHECKED>4 
                <input type="radio" name=tarkeys VALUE="5">5                                     
            </c:if>
            <c:if test="${muistio.tarkeys==5}">
                <input type="radio" name=tarkeys VALUE="1">1
                <input type="radio" name=tarkeys VALUE="2">2
                <input type="radio" name=tarkeys VALUE="3">3
                <input type="radio" name=tarkeys VALUE="4">4 
                <input type="radio" name=tarkeys VALUE="5" CHECKED>5                                     
            </c:if>
            <br/>
            Muuta kategoriaa: <select name="kategoria" >              
                <c:forEach var="Kategoria" items="${kategorialista}">
                    <c:if test="${muistio.kategoria.id == Kategoria.id}">
                         <option value="${Kategoria.id}" selected="selected"> ${Kategoria.nimi} </option>                        
                    </c:if>  
                </c:forEach>                                        
                <c:forEach var="Kategoria" items="${kategorialista}">
                    <option value="${Kategoria.id}">${Kategoria.nimi}  </option>                             
                </c:forEach>
            </select>   
            <input type="text" name="kategoria_uusi" maxlength=30 />   
            <br/> 
            <input type="text" name="id" value="${muistio.id}" hidden="hidden"/>
            <input type="submit" value="Tallenna muutokset" />
        </form>
            
        <br/>
        <form name="Takaisin"
            action="${pageContext.request.contextPath}/muistio">
            <input type="submit" value="Takaisin" />
        </form>
        <br/><br/>
        
        <form name="Poista muistio"
            action="${pageContext.request.contextPath}/poista" method="get">
            <input type="text" name="muistioid" value="${muistio.id}" hidden="hidden"/>
            <input type="submit" value="Poista muistio" />
        </form>
        <br/><br/>        
        
        Tärkeys: ${muistio.tarkeys}
        <br/> 
        Kategoria: ${muistio.kategoria.nimi}         
    </body>
</html>
