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

/**
 *
 * @author miimaija
 */
public class Lisaakayttaja extends Muistilistatoiminnot {
    Tietokanta lisaaja= new Tietokanta();
    boolean vapaa=true;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //kutsutaan "/lisaaKayttaja" liitteellä
       
        vapaa=true;
        String tunnus=request.getParameter("tunnus");
        String salasana=request.getParameter("salasana");
        
        if (tunnus.equals("") || tunnus.equals(" ") || tunnus.equals("  ") || salasana.equals("") || salasana.equals(" ") || salasana.equals("   ")) {
            request.setAttribute("viesti", "Tunnus tai salasana ei kelvollinen, yritä uudelleen");
            sivuSiirto("uusikayttaja.jsp", request, response);
            return;
        }    
        List<Kayttaja> tarkistus=lisaaja.getKayttajat();      //Tarkistaa onko tunnus vapaa
        for (int i=0 ; tarkistus.size()>i; i++) {
            if (tarkistus.get(i).getTunnus().equals(tunnus)) {
                vapaa=false;
                break;
            }
        }
        if (vapaa) {
            lisaaja.lisaaKayttaja(new Kayttaja(tunnus, salasana));         
            request.setAttribute("viesti", "Kirjaudu sisään uudella tunnuksellasi");
            sivuSiirto("index.jsp", request, response);
            return;
        }
        if (!vapaa) {
            request.setAttribute("viesti", "Käyttäjätunnus varattu");
            sivuSiirto("uusikayttaja.jsp", request, response);
                    
        }  
         
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
