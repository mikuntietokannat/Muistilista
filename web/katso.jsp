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
        <title>${Muistio.nimi}</title>
    </head>
    <body>
        <br/> 
        trolol tyhjä?
        <br/> 
        
        ${Muistio.kuvaus}
        <br/> 
        ${Muistio.tarkeys}
        <br/> 
        
        <form name="Takaisin"
            action="${pageContext.request.contextPath}/muistio">
            <input type="submit" value="Takaisin" />
        </form>
          
        <br/>     
    </body>
</html>
