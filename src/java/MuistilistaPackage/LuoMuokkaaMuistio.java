package MuistilistaPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miimaija
 */
public class LuoMuokkaaMuistio extends Muistilistatoiminnot {
    // kutsutaan nimellä /muokkaa
    
    // Luo
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!(sessiotarkistus(request, response))) {
            return;
        }
        String nimi=request.getParameter("nimi");
        int tarkeys=Integer.parseInt(request.getParameter("tarkeys"));        
        String teksti=request.getParameter("teksti"); 
        String kat=request.getParameter("kategoria");
        String kat_uusi=request.getParameter("kategoria_uusi");
        long kategorid;
        
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        
        if (!kat_uusi.equals("") || !kat_uusi.equals(" ") || !kat_uusi.equals("  ") ) {
            Kategoria kategoria = new Kategoria(kayttaja.getId(), nimi);
            db.lisaaKategoria(kategoria);
            kategorid = kategoria.getId();
        }
        else {
            kategorid = db.getKategorId(kat);
            
        }
        db.lisaaMuistio(new Muistio(kategorid, kayttaja.getId(), tarkeys, teksti, nimi));
        sivuSiirto("/muistio",request, response);
    }
    
    // Muokkaa
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!(sessiotarkistus(request, response))) {
            return;
        }
    }
}
