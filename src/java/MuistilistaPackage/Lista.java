package MuistilistaPackage;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miimaija
 */
public class Lista extends Muistilistatoiminnot {
    Tietokanta db=new Tietokanta();
    //kutsutaan "/muistio" liitteellä
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        if (!sessiotarkistus(request, response)) {
            return;
        }        
        sivuSiirto("lista.jsp", request, response);
        */
        doPost(request, response);
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!sessiotarkistus(request, response)) {
            return;
        }
        HttpSession session = request.getSession(false);
        Kayttaja kayttaja=(Kayttaja)session.getAttribute("kayttaja");
        List<Muistio> muistiolista = db.getMuistiot(kayttaja.getId());
        request.setAttribute("muistiolista", muistiolista);
        List<Kategoria> kategorialista = db.getKategoriat(kayttaja.getId());
        request.setAttribute("kategorialista", kategorialista);
        
        int jarjestys;
        try {
            jarjestys=Integer.parseInt(request.getParameter("setjarjestys")); 
        } catch (NullPointerException e) {
            jarjestys=2;
        }
        request.setAttribute("jarjesta", jarjestys); // lista jspssä kysy variable "jarjesta"
        
        sivuSiirto("lista.jsp", request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
