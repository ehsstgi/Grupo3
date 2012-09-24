/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Rota;
import interfacesBean.RotaBeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author vneiva
 */
@WebServlet (urlPatterns="/ComprarPassagem")
public class ComprarPassagem extends HttpServlet {

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
            out.println("<title>Servlet ComprarPassagem</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ComprarPassagem at " + request.getContextPath () + "</h1>");
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
        
        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        
        InitialContext ctx;
        RotaBeanInterface bean = null;
        List <Rota> rotas = null;
        
        try {
            ctx = new InitialContext();
            bean = (RotaBeanInterface)ctx.lookup("ejb/RotaBean");
            if((origem==null && destino==null) || origem.equals("Selecione") && destino.equals("Selecione"))
                rotas = bean.listar();
            else
                rotas = bean.listar(origem, destino);
        } catch (NamingException ex) {
            Logger.getLogger(ComprarPassagem.class.getName()).log(Level.SEVERE, null, ex);
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
            out.print("<table class ='tabelaPreco' width='625' border='1' style='text-align: center;'> "
                + "<tr> <td><b>Selecione</b></td> <td> <b>Data</b> </td> <td> <b>Horario</b></td> <td> <b>Origem</b> </td> <td> <b>Destino</b> </td> <td> <b>Poltronas Livres</b> </td> <td> <b>Preço</b> </td> </tr> <form action='ComprarSelecionado' method='post'>");
         for(int i=0;i<rotas.size();i++){
             String[] assentos = rotas.get(i).getNumeroAssentosOcupados().split(",");
             int totalAssentos;
             if(assentos[0].isEmpty())
                totalAssentos = 41 - assentos.length;
             else
                totalAssentos = 40 - assentos.length;
             String assentosRequest = "";
             for(int n=0; n<assentos.length; n++){
                 assentosRequest = assentosRequest+","+assentos[n];
             }
             
             out.print("<tr>"
             +"<td><input type='radio' name='selecionado' value='"+i+"'></td> <td> "+rotas.get(i).getDatas() +" </td> <td> "+rotas.get(i).getHorario() +"</td> <td> "+rotas.get(i).getOrigemRota()+" </td> <td> "+rotas.get(i).getDestinoRota()+" </td><td> "+totalAssentos+" </td> <td> "+rotas.get(i).getPreco()+" </td>"
             +"<input type='hidden' name='data_"+i+"' value='"+rotas.get(i).getDatas()+"'> <input type='hidden' name='horario_"+i+"' value='"+rotas.get(i).getHorario() +"'><input type='hidden' name='origem_"+i+"' value='"+rotas.get(i).getOrigemRota()+"'> <input type='hidden' name='destino_"+i+"' value='"+rotas.get(i).getDestinoRota()+"'> <input type='hidden' name='poltronas_"+i+"' value='"+assentosRequest+"'> <input type='hidden' name='preco_"+i+"' value='"+rotas.get(i).getPreco()+"'>"
             +"</tr>");
         }
           out.print("</table>");
           
           out.print("<input type='submit' value='Comprar Selecionado' ></form></p> </div></div> </body> </html>");
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
