/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MuistilistaPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miimaija
 */
public class Tehtavalista extends HttpServlet {
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
        //kutsutaan "/tehtavat" liitteellä
        
        /*
        Tietokanta testi=new Tietokanta();
        testi.lisaaKayttaja(new Kayttaja("Mikko", "joku"));
        testi.lisaaKayttaja(new Kayttaja("Esko", "Jou"));
        
        request.setAttribute("lista", testi.getKayttajat());
        */        
               

        RequestDispatcher dispatcher = request.getRequestDispatcher("lista.jsp");
        dispatcher.forward(request, response);



        /* response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Tehtavalista</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet Tehtavalista at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
        
        } finally {            
        out.close();
        } */
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
