package br.ufscar.dc.Promocoes.servlets;
import br.ufscar.dc.Promocoes.dao.SiteDAO;
import br.ufscar.dc.Promocoes.forms.CadastroSiteFormBean;
import br.ufscar.dc.Promocoes.beans.Site;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "GravarSiteServlet", urlPatterns = {"/GravarSiteServlet"})
public class GravarSiteServlet extends HttpServlet {

    @Resource(name="jdbc/PromocaoBD")
    DataSource dataSource;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
        CadastroSiteFormBean npfb = (CadastroSiteFormBean) request.getSession().getAttribute("CadastroSiteServlet");
        request.getSession().removeAttribute("CadastroSiteServlet");
        SiteDAO pdao = new SiteDAO(dataSource);

        try {
            Site p = new Site();
            p.setURL(npfb.getURL());
            p.setNome(npfb.getNome());
            p.setTelefone(npfb.getTelefone());
            p.setSenha(npfb.getSenha());
            p = pdao.gravarSite(p);
            request.setAttribute("mensagem", "Site registrado com sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
