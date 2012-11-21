package MuistilistaPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        
        String nimi=nimiTarkistus(request.getParameter("nimi"));
        int tarkeys=Integer.parseInt(request.getParameter("tarkeys"));        
        String teksti=request.getParameter("teksti"); 
        Kategoria kategoria=kategoriaTarkistus(request);
        
        db.lisaaMuistio(new Muistio(kategoria, kayttaja.getId(), tarkeys, teksti, nimi));
        request.setAttribute("viesti", "Muistio '" + nimi + "' luotu");
        sivuSiirto("/muistio",request, response);
    }
    
    // Muokkaa
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!(sessiotarkistus(request, response))) {
            return;
        }
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        
        String nimi=nimiTarkistus(request.getParameter("nimi"));
        int tarkeys=Integer.parseInt(request.getParameter("tarkeys"));        
        String teksti=request.getParameter("teksti"); 
        long muistioid=Long.parseLong(request.getParameter("id"));
        Kategoria kategoria=kategoriaTarkistus(request);
      
        //db.muokkaaMuistio2(muistioid, kategorid, kayttaja.getId(), nimi,tarkeys, teksti);
        Muistio muokattava=db.getMuistio(muistioid, kayttaja.getId());
        muokattava.setKategoria(kategoria);muokattava.setKuvaus(teksti);muokattava.setTarkeys(tarkeys);muokattava.setNimi(nimi);
        db.muokkaaMuistio(muokattava);
        request.setAttribute("viesti", "Muutokset muistioon '" + nimi + "' tallennettu");
        sivuSiirto("/muistio",request, response);
    }
    
    protected Kategoria kategoriaTarkistus(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        Kategoria kategoria;
        
        if (!request.getParameter("kategoria_uusi").equals("") && !request.getParameter("kategoria_uusi").equals(" ") && !request.getParameter("kategoria_uusi").equals("  ") ) {
            kategoria = new Kategoria(kayttaja.getId(), request.getParameter("kategoria_uusi"));
            db.lisaaKategoria(kategoria);
        }       
        else if (request.getParameter("kategoria")!=null && !request.getParameter("kategoria").equals("")) {     
            long kategorid=Long.parseLong(request.getParameter("kategoria"));
            kategoria=db.getKategoria(kategorid);
        }
        else {          
            kategoria = new Kategoria(kayttaja.getId(), "Yleinen [oletus]");
            db.lisaaKategoria(kategoria);       
        }
        return kategoria;
    }
    
    protected String nimiTarkistus(String nimi) {
        if (nimi==null || nimi.equalsIgnoreCase("") || nimi.equalsIgnoreCase(" ") || nimi.equalsIgnoreCase("  ") || nimi.equalsIgnoreCase("   ")) {
            nimi="Nimeämätön";
            return nimi;
        }
        else {
            return nimi;
        }
    }
}
