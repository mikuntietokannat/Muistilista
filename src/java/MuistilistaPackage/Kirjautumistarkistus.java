package MuistilistaPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class Kirjautumistarkistus extends Muistilistatoiminnot {
    //kutsutaan "/Kirjautumistarkistus" liitteellä

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String tunnus=request.getParameter("tunnus");
        String salasana=request.getParameter("salasana");
        List<Kayttaja> tunnuslista=db.getKayttajat();
        for (int i=0 ; tunnuslista.size()>i; i++) {
           if (tunnuslista.get(i).getTunnus().equals(tunnus)) {
               if (tunnuslista.get(i).getSalasana().equals(salasana)) {
                   HttpSession session = request.getSession(true);
                   //session.setAttribute("kayttaja_id", tunnuslista.get(i).getId());
                   session.setAttribute("kayttaja", tunnuslista.get(i).getKayttaja());
                   request.setAttribute("viesti", "Hei "+ tunnus + "!");
                   sivuSiirto("/muistio", request, response);
                   return;                                                 
               }
               else {
                   request.setAttribute("viesti", "Väärä käyttäjätunnus tai salasana");
                   sivuSiirto("index.jsp", request, response);
                   return;
               }
           } 
        }
        request.setAttribute("viesti", "Tunnusta ei löydy, oletko rekisteröitynyt?");
        sivuSiirto("index.jsp", request, response);
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.invalidate();
        sivuSiirto("index.jsp", request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
