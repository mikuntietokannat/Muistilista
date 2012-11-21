/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MuistilistaPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miimaija
 */
public class Poista extends Muistilistatoiminnot {
    // kutustaan nimellä /poista
    
    //Poista muistio
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!sessiotarkistus(request, response)) {
            return;
        }
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        Muistio poisto=db.getMuistio(Long.parseLong(request.getParameter("muistioid")), kayttaja.getId());
        
        String nimi=poisto.getNimi();
        Kategoria poistoKat=poisto.getKategoria();
        
        db.poistaMuistio(poisto);
        if (poistoKat.getMuistiot().isEmpty()) {
            db.poistaKategoria(poistoKat);
        }
               
        request.setAttribute("viesti", "Muistio '" + nimi + "' on poistettu");
        sivuSiirto("/muistio",request, response);
    }
    
    //Poista kategoria??! vai onko automaattista jos tyhjä kategoria?
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
