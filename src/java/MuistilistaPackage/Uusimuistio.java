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
public class Uusimuistio extends Muistilistatoiminnot {
    //kutsutaan "/uusimuistio" liitteelläf

    @Override     //muokkauslomake  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!(sessiotarkistus(request, response))) {
            return;
        }
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        
        List<Kategoria> kategorialista = db.getKategoria(kayttaja.getId());
        request.setAttribute("kategorialista", kategorialista);
               
        long muistioid=Long.parseLong(request.getParameter("id"));
        request.setAttribute("muistio", db.getMuistio(muistioid, kayttaja.getId()));
             
        sivuSiirto("katso.jsp", request, response);
    }

    @Override     //luontilomake
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setAttribute("viesti", "joku viesti");
        if (!(sessiotarkistus(request, response))) {
            return;
        }       
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja"); 
        
        List<Kategoria> kategorialista = db.getKategoria(kayttaja.getId());
        request.setAttribute("kategorialista", kategorialista);
        
        sivuSiirto("uusitehtava.jsp", request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
