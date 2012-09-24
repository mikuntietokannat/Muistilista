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
public class Kirjautumistarkistus extends HttpServlet {
    Tietokanta db=new Tietokanta();

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //kutsutaan "/Kirjautumistarkistus" liitteellä
        
        String tunnus=request.getParameter("tunnus");
        String salasana=request.getParameter("salasana");
        Boolean loytyyko=false;
        List<Kayttaja> tunnuslista=db.getKayttajat();
        for (int i=0 ; tunnuslista.size()>i; i++) {
           if (tunnuslista.get(i).getTunnus().equals(tunnus)) {
               if (tunnuslista.get(i).getSalasana().equals(salasana)) {
                   request.setAttribute("viesti", "Hei "+ tunnus + "!");
                   
                   HttpSession session = request.getSession(true);
                   session.setAttribute("kayttaja_id", tunnuslista.get(i).getId());               //Siirrä tietokantaan
                   
                   request.getRequestDispatcher("/tehtavat").forward(request, response);  //tunnus löytyy tietokannasta ja salasana täsmää, jatketaan eteenpäin
                   loytyyko=true;                                                         //sessio on käyttäjä id
               }
               else {
                   request.setAttribute("viesti", "Väärä käyttäjätunnus tai salasana");
                   RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                   dispatcher.forward(request, response);           //Väärä salasana, kirjaudu uudestaan
                   loytyyko=true;
               }
           } 
        }
        if (!loytyyko) {
            request.setAttribute("viesti", "Tunnusta ei löydy, oletko rekisteröitynyt?");
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);           //tunnusta ei löydy, rekisteröidy
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