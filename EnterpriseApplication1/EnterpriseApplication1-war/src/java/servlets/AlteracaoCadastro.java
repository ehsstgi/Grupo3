/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Cliente;
import interfacesBean.ClienteBeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AlteracaoCadastro extends HttpServlet {

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
            out.println("<title>Servlet AlteracaoCadastro</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlteracaoCadastro at " + request.getContextPath () + "</h1>");
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
        PrintWriter out = response.getWriter();
        
        long rg = 0;
        long cpf = 0;
        
        if(!request.getParameter("rg").equals(""))
            rg = Long.parseLong(request.getParameter("rg"));
        if(!request.getParameter("cpf").equals(""))
            cpf = Long.parseLong(request.getParameter("cpf"));
        
        InitialContext ctx;
        ClienteBeanInterface clienteBean = null;
        Cliente cliente = null;
        try {
            ctx = new InitialContext();
            clienteBean = (ClienteBeanInterface)ctx.lookup("ejb/ClienteBean");
            
            if(rg!=0)
                cliente = clienteBean.carregarCliente(rg,0);
            else if(cpf!=0)
                cliente = clienteBean.carregarCliente(0,cpf);
            
        } catch (NamingException ex) {
            Logger.getLogger(AlteracaoCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean sucesso = false;
        
        if(cliente!=null){
            request.setAttribute("nome", cliente.getNomeCliente());
            request.setAttribute("rg", cliente.getRgCliente());
            request.setAttribute("rgAntigo", cliente.getRgCliente());
            request.setAttribute("endereco", cliente.getEnderecoCliente());
            request.setAttribute("cpf", cliente.getCpfCliente());
            request.setAttribute("cartaoCredito", cliente.getCartaoCredito());
            request.setAttribute("telefone", cliente.getTelCliente());
            sucesso = true;
        }
        if(sucesso){
                RequestDispatcher rd;

                rd = getServletContext().getRequestDispatcher("/cadastro_1.jsp");
                rd.forward(request, response);
        }else{
                RequestDispatcher rd;

                rd = getServletContext().getRequestDispatcher("/erro.jsp");
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
