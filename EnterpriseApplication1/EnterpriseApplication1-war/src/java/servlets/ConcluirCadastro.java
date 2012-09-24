/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Cliente;
import interfacesBean.ClienteBeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vneiva
 */
public class ConcluirCadastro extends HttpServlet {

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
            out.println("<title>Servlet ConcluirCadastro</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConcluirCadastro at " + request.getContextPath () + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String nome = request.getParameter("nome");
        long rg = Long.parseLong(request.getParameter("rg"));
        long cpf = Long.parseLong(request.getParameter("cpf"));
        long telefone = Long.parseLong(request.getParameter("telefone"));
        long cartaoCredito = Long.parseLong(request.getParameter("cartaoCredito"));
        String endereco = request.getParameter("endereco");
        
        Cliente cliente = new Cliente(nome, rg, cpf, endereco, telefone, cartaoCredito);
        
        InitialContext ctx;
        ClienteBeanInterface bean = null;
        boolean sucesso = false;
        try {
            ctx = new InitialContext();
            bean = (ClienteBeanInterface)ctx.lookup("ejb/ClienteBean");
            sucesso = bean.cadastrarCliente(cliente);
            
        } catch (NamingException ex) {
            Logger.getLogger(CalculaMaioridade.class.getName()).log(Level.SEVERE, null, ex);
        }
        out.print("<html> <head> <title>Inicio - Nome da Empresa Transportes</title>");
        out.print("<meta http-equiv='Content-Type' content='text/html; charset=utf-8' /> <meta name='title' content='Web site' />"
               + "<meta name='description' content='Site description here' />"
               + "<meta name='keywords' content='keywords here' />"
               + "<meta name='language' content='en' />"
               + "<meta name='subject' content='Site subject here' />"
               + "<meta name='robots' content='All' />"
               + "<meta name='copyright' content='Your company'/>"
               + "<meta name='abstract' content='Site description here' />"
               + "<meta name='MSSmartTagsPreventParsing' content='true' />"
               + "<link id='theme'rel='stylesheet' type='text/css' href='style.css' title='theme' />"
               + "</head>");
        out.print("<body> <div class='header' style='text-align: center'> </div>"
                   + "	<div class='nav1'><ul id='menu'>"
                   + "<li><a href='index.jsp' title='' >Início</a></li>"
                   + "<li><a href='agencias.jsp' title=''>Agências</a></li>"
                   + "<li><a href='comprar.jsp' title='' class='current'>Comprar</a></li>"
                   + "<li><a href='cadastro.jsp' title=''>Cadastro</a></li>"
                   + "<li><a href='autorizaHistorico.jsp' title=''>Historico de Compras</a></li>"
                   + "<li><a href='previsao.jsp' title=''>Previsão do Tempo</a></li>"
                   + "<li><a href='sobre.jsp' title=''>Sobre</a></li>"
                   + "<li><a href='contato.jsp' title=''>Contato</a></li></ul></div>"
                   + "<div class='principal'><div style='margin-left: 10px;'><p class='contentText'>");
        if(sucesso){
            out.print("<h3>Usuário cadastrado com sucesso!</h3><br/>"
                    + "<img src='images/onibus xavante.jpg' style='margin-left:45px; 'alt= 'Xavante' width='300' height='150' title='xavante' align='bottom' /><br/> "
                    + "<h3>Clique <a href='comprar.jsp'>Aqui</a> para comprar sua passagem.</h3>");
        }else{
            out.print("<h3>Usuário não foi cadastrado ou Usuário já está cadastrado</h3><br/>"
                    + "<img src='images/onibus xavante.jpg' style='margin-left:45px; 'alt= 'Xavante' width='300' height='150' title='xavante' align='bottom' /><br/> "
                    + "<h3>Clique <a href='comprar.jsp'>Aqui</a> para comprar sua passagem.</h3>");
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
