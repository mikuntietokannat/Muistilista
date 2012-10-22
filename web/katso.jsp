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
        <br/> 
        trolol tee tästä lomake ja laite VALUE=entiset arvot + nappula tallenna muutokset :)
        <br/> 
        
        ${muistio.kuvaus}
        <br/> 
        ${muistio.tarkeys}
        <br/> 
        ${muistio.kategoria}
        <br/> 
        
        <form name="Takaisin"
            action="${pageContext.request.contextPath}/muistio">
            <input type="submit" value="Takaisin" />
        </form>
          
        <br/>     
    </body>
</html>
