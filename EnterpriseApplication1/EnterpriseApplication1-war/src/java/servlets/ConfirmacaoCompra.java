/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Cliente;
import entidades.Rota;
import entidades.Venda;
import interfacesBean.ClienteBeanInterface;
import interfacesBean.RotaBeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vneiva
 */
public class ConfirmacaoCompra extends HttpServlet {

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
            out.println("<title>Servlet ConfirmacaoCompra</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmacaoCompra at " + request.getContextPath () + "</h1>");
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
        String rgCliente = (String) request.getParameter("rg");
        long rg = Long.parseLong(rgCliente);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        InitialContext ctx;
        ClienteBeanInterface clienteBean = null;
        RotaBeanInterface rotaBean = null;
        List <Cliente> clientes = null;
        boolean existeCliente = false;
        Cliente cliente = new Cliente();
        try {
            ctx = new InitialContext();
            clienteBean = (ClienteBeanInterface)ctx.lookup("ejb/ClienteBean");
            rotaBean = (RotaBeanInterface)ctx.lookup("ejb/RotaBean");
            
            if((rg!=0)){
                existeCliente = clienteBean.validarCliente(rg);
            }
            else{
                existeCliente = false;
            }
        } catch (NamingException ex) {
            Logger.getLogger(CalculaMaioridade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(existeCliente){
            Enumeration <String> i = request.getParameterNames();
            String assento = request.getParameter("bi0");
            String data = request.getParameter("data");
            String horario = request.getParameter("horario");
            String origem = request.getParameter("origem");
            String destino = request.getParameter("destino");
            
            request.setAttribute("data", data);
            request.setAttribute("horario", horario);
            request.setAttribute("origem", origem);
            request.setAttribute("destino", destino);
            request.setAttribute("assento", assento);
                   
            Rota rota = rotaBean.carregarRota(origem, destino, horario, data);
            cliente = clienteBean.carregarCliente(rg,0);
            
            boolean sucesso = false;
            if(cliente.getCodCliente()!= null){
                rotaBean.escolherPoltrona(assento, rota);
                sucesso = clienteBean.efetuarCompraOnline(cliente, rota, assento);
            }
            if(sucesso){
                RequestDispatcher rd;

                rd = getServletContext().getRequestDispatcher("/vendaSucesso.jsp");
                rd.forward(request, response);
            }
            
        }else{
                RequestDispatcher rd;

                rd = getServletContext().getRequestDispatcher("/vendaFalha.jsp");
                rd.forward(request, response);
        }
        
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
