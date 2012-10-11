package MuistilistaPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miimaija
 */
public class Muistilistatoiminnot extends HttpServlet {
    Tietokanta db=new Tietokanta();
    
    protected boolean sessiotarkistus(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        if (kayttaja != null) {
           request.setAttribute("kayttaja", kayttaja);
           return true;
        }
        request.setAttribute("viesti", "istuntosi katkesi, kirjaudu sisään uudelleen");
        sivuSiirto("index.jsp", request, response);
        return false;
    }
    
    protected void servletSiirto (String sivu, HttpServletResponse response ) throws IOException {
        response.sendRedirect(sivu);
    }
    
    protected void sivuSiirto(String sivu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(sivu);
        dispatcher.forward(request, response);
    }


            
}
