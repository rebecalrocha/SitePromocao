package br.ufscar.dc.Promocoes.servlets;
import br.ufscar.dc.Promocoes.dao.PromocaoDAO;
import br.ufscar.dc.Promocoes.beans.Promocao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "VisualizarPromocaoSiteServlet", urlPatterns = {"/VisualizarPromocaoSiteServlet"})
public class VisualizarPromocaoSiteServlet extends HttpServlet {
    
    @Resource(name = "jdbc/PromocaoBD")
    DataSource dataSource;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        
        PromocaoDAO pdao = new PromocaoDAO(dataSource);
        String URL = request.getParameter("URL");
        String senha = request.getParameter("senha");

        List<Promocao>todasPromocoes = null;
        todasPromocoes = pdao.listarTodasPromocoesPorSite(URL,senha);
        
        try {
            if(todasPromocoes == null){
                request.getRequestDispatcher("EscolherSite.jsp").forward(request, response);
            }else{
            request.setAttribute("listaPromocoes", todasPromocoes);
            request.getRequestDispatcher("listaPromocoesSite.jsp").forward(request, response);
            }            
        } 
        catch (IOException | ServletException e) {
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(VisualizarPromocaoSiteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(VisualizarPromocaoSiteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
