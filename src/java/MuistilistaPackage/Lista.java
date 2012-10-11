package MuistilistaPackage;

import java.io.IOException;
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
public class Lista extends Muistilistatoiminnot {
    Tietokanta db=new Tietokanta();
    //kutsutaan "/muistio" liitteellä
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!sessiotarkistus(request, response)) {
            return;
        }
        sivuSiirto("lista.jsp", request, response);
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!sessiotarkistus(request, response)) {
            return;
        }        
        sivuSiirto("lista.jsp", request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
