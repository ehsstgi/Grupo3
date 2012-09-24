/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;



import interfacesBean.BeanInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
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
 * @author Lucas Russo e Vinicius Neiva
 */
@WebServlet(urlPatterns="/CalculaMaioridade")
public class CalculaMaioridade extends HttpServlet{

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
            out.println("<title>Servlet CalculaMarioridade</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculaMarioridade at " + request.getContextPath () + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
            
        String nome = request.getParameter("nome");
        String dataNascimento = request.getParameter("data");

        InitialContext ctx;
        BeanInterface bean = null;
        boolean verifica = false;
        
        try {
            ctx = new InitialContext();
            bean = (BeanInterface)ctx.lookup("ejb/VerificaMaioridade");
            verifica = bean.verificarMaioridade(nome, dataNascimento);
        } catch (NamingException ex) {
            Logger.getLogger(CalculaMaioridade.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            if(verifica){ 
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Calculando Maioridade</title>");  
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Calculando Maioridade</h1>");
                out.println("<br /><font-color:blue> Você é maior de idade</font>");
                out.println("<br /> <a href='proximo.jsp'>Listar todos</a> ");
                out.println("</body>");
                out.println("</html>");
           }else{
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Calculando Maioridade</title>");  
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Calculando Maioridade</h1>");
                out.println("<br /><font-color:red> Você não é maior de idade</font>");
                out.println("</body>");
                out.println("</html>");
            
            }
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
*/
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
