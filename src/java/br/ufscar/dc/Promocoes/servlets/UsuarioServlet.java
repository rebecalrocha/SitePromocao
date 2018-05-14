package br.ufscar.dc.Promocoes.servlets;
import br.ufscar.dc.Promocoes.beans.Usuario;
import br.ufscar.dc.Promocoes.dao.UsuarioDAO;
import br.ufscar.dc.Promocoes.forms.UsuarioFormBean;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {
    
    @Resource(name = "jdbc/PromocaoBD")
    DataSource dataSource;
    private Object mensagens;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioFormBean npfb = new UsuarioFormBean();
        try {
            BeanUtils.populate(npfb, request.getParameterMap());
            request.getSession().setAttribute("usuario", npfb);
            
            UsuarioDAO udao = new UsuarioDAO(dataSource);
                
            Usuario u = new Usuario();
            u.setLogin(npfb.getLogin());
            u.setSenha(npfb.getSenha());
            u.setPermissao(npfb.getPermissao());
            u = udao.buscarUsuario(u); 
                
            if (u.getPermissao() && "http://localhost:8080/Promocoes/Loggin_sites_admin.jsp".equals(request.getHeader("referer"))) 
            {
                request.getRequestDispatcher("CadastroSite.jsp").forward(request, response);           
            }
            else if(u.getPermissao() && "http://localhost:8080/Promocoes/Loggin_hoteis_admin.jsp".equals(request.getHeader("referer")))
            {
                request.getRequestDispatcher("CadastroHotel.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("mensagem", "Você não tem permissão para cadastrar.");
                request.getRequestDispatcher("index.jsp").forward(request, response); 
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
