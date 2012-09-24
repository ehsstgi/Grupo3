/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vneiva
 */
public class ComprarSelecionado extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ComprarSelecionado</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComprarSelecionado at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {            
            out.close();
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
        Enumeration <String> i = request.getParameterNames();
        String indice = request.getParameter("selecionado");
        String data = request.getParameter("data_"+indice);
        String horario = request.getParameter("horario_"+indice);
        String origem = request.getParameter("origem_"+indice);
        String destino = request.getParameter("destino_"+indice);
        String preco = request.getParameter("preco_"+indice);
        String poltronas = request.getParameter("poltronas_"+indice);
        
        request.setAttribute("preco", preco);
        request.setAttribute("poltronas", poltronas);
        request.setAttribute("data", data);
        request.setAttribute("horario", horario);
        request.setAttribute("origem", origem);
        request.setAttribute("destino", destino);
        
        
        
        RequestDispatcher rd;

        rd = getServletContext().getRequestDispatcher("/comprarSelecionado.jsp");
        rd.forward(request, response);
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
