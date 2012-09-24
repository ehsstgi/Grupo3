/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Cliente;
import entidades.Passagem;
import interfacesBean.ClienteBeanInterface;
import interfacesBean.PassagemBeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
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
public class RecuperarHistorico extends HttpServlet {

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
            out.println("<title>Servlet RecuperarHistorico</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecuperarHistorico at " + request.getContextPath () + "</h1>");
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
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        long rg = 0;
        
        if(Long.parseLong(request.getParameter("rg")) != 0)
            rg = Long.parseLong(request.getParameter("rg"));
        
        InitialContext ctx;
        ClienteBeanInterface bean = null;
        PassagemBeanInterface passagemBean = null;
        List <Passagem> historico =  null;
        boolean sucesso = false;
        Cliente cliente = null;
        try {
            ctx = new InitialContext();
            bean = (ClienteBeanInterface)ctx.lookup("ejb/ClienteBean");
            passagemBean = (PassagemBeanInterface) ctx.lookup("ejb/PassagemBean");
            sucesso = bean.validarCliente(rg);
            
            if(sucesso){
                cliente = bean.carregarCliente(rg, 0);
                historico = passagemBean.listarPassagensCliente(cliente);
            }
            
        } catch (NamingException ex) {
            Logger.getLogger(RecuperarHistorico.class.getName()).log(Level.SEVERE, null, ex);
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
                   + "<li><a href='comprar.jsp' title=''>Comprar</a></li>"
                   + "<li><a href='cadastro.jsp' title=''>Cadastro</a></li>"
                   + "<li><a href='autorizaHistorico.jsp' title='current'>Historico de Compras</a></li>"
                   + "<li><a href='previsao.jsp' title=''>Previsão do Tempo</a></li>"
                   + "<li><a href='sobre.jsp' title=''>Sobre</a></li>"
                   + "<li><a href='contato.jsp' title=''>Contato</a></li></ul></div>"
                   + "<div class='principal'><div style='margin-left: 10px;'><p class='contentText'>");
        if(sucesso){
            out.print("<h4>Selecione para imprimir histórico!</h4><br/>");
            out.print("<table class ='tabelaPreco' width='625' border='1' style='text-align: center;'> "
                + "<tr> <td><b>Selecione</b></td> <td> <b>Codigo da Passagem</b> </td> <td> <b>Data</b></td> <td> <b>Origem</b> </td> <td> <b>Destino</b> </td> <td> <b>Horário</b> </td> <td> <b>Poltrona</b> </td> <td> <b>Nome</b> </td> <td> <b>RG</b> </td> <td> <b>Preço</b> </td> </tr> <form action='HistoricoSelecionado' method='post'>");
            for(int i=0; i<historico.size(); i++){
                 out.print("<tr>"
             +"<td><input type='radio' name='selecionado' value='"+i+"'></td> <td> "+historico.get(i).getCodPassagem() +" </td> <td> "+historico.get(i).getDatas() +"</td> <td> "+historico.get(i).getOrigem()+" </td> <td> "+historico.get(i).getDestino()+" </td><td> "+historico.get(i).getHorario()+" </td> <td> "+historico.get(i).getNumeroAssento()+" </td> <td> "+cliente.getNomeCliente()+" </td> <td> "+cliente.getRgCliente()+" </td> <td> "+historico.get(i).getPreco()+" </td>"
             +"<input type='hidden' name='codPassagem_"+i+"' value='"+historico.get(i).getCodPassagem()+"'><input type='hidden' name='data_"+i+"' value='"+historico.get(i).getDatas()+"'> <input type='hidden' name='origem_"+i+"' value='"+historico.get(i).getOrigem() +"'><input type='hidden' name='destino_"+i+"' value='"+historico.get(i).getDestino()+"'> <input type='hidden' name='horario_"+i+"' value='"+historico.get(i).getHorario()+"'> <input type='hidden' name='poltrona_"+i+"' value='"+historico.get(i).getNumeroAssento()+"'> <input type='hidden' name='nome_"+i+"' value='"+cliente.getNomeCliente()+"'><input type='hidden' name='rg_"+i+"' value='"+cliente.getRgCliente()+"'> <input type='hidden' name='preco_"+i+"' value='"+historico.get(i).getPreco()+"'>"
             +"</tr>");
            }
           out.print("</table><input type='submit' value='Imprimir'> </form>");
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
