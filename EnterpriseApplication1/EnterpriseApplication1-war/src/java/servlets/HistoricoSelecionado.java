/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author vneiva
 */
public class HistoricoSelecionado extends HttpServlet {

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
            out.println("<title>Servlet HistoricoSelecionado</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HistoricoSelecionado at " + request.getContextPath () + "</h1>");
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
        String indice = request.getParameter("selecionado");
        
        String codPassagem = request.getParameter("codPassagem_"+indice);
        String data = request.getParameter("data_"+indice);
        String horario = request.getParameter("horario_"+indice);
        String origem = request.getParameter("origem_"+indice);
        String destino = request.getParameter("destino_"+indice);
        String preco = request.getParameter("preco_"+indice);
        String poltrona = request.getParameter("poltrona_"+indice);
        String nome = request.getParameter("nome_"+indice);
        String rg = request.getParameter("rg_"+indice);
        
        request.setAttribute("codPassagem", codPassagem);
        request.setAttribute("preco", preco);
        request.setAttribute("poltronas", poltrona);
        request.setAttribute("data", data);
        request.setAttribute("horario", horario);
        request.setAttribute("origem", origem);
        request.setAttribute("destino", destino);
        request.setAttribute("nome", nome);
        request.setAttribute("rg", rg);
        
       
        RequestDispatcher rd;

        rd = getServletContext().getRequestDispatcher("/historicoSelecionado.jsp");
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
