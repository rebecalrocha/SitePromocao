package br.ufscar.dc.Promocoes.servlets;
import br.ufscar.dc.Promocoes.beans.Hotel;
import br.ufscar.dc.Promocoes.dao.PromocaoDAO;
import br.ufscar.dc.Promocoes.dao.SiteDAO;
import br.ufscar.dc.Promocoes.dao.HotelDAO;
import br.ufscar.dc.Promocoes.forms.CriarPromocaoFormBean;
import br.ufscar.dc.Promocoes.beans.Promocao;
import br.ufscar.dc.Promocoes.beans.Site;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "GravarPromocaoServlet", urlPatterns = {"/GravarPromocaoServlet"})
public class GravarPromocaoServlet extends HttpServlet {

    @Resource(name="jdbc/PromocaoBD")
    DataSource dataSource;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CriarPromocaoFormBean cpfb = (CriarPromocaoFormBean) request.getSession().getAttribute("CriarPromocaoServlet");

        PromocaoDAO pdao = new PromocaoDAO(dataSource);
        HotelDAO hdao = new HotelDAO(dataSource);
        SiteDAO sdao = new SiteDAO(dataSource);


        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date dataInicial = null;
        Date dataFinal = null;
        
        try {
            dataInicial = sdf.parse(cpfb.getDataInicial());
            dataFinal = sdf.parse(cpfb.getDataFinal());
        } catch (ParseException e) {
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
                
        try {
            Promocao p = new Promocao();
            Site s = sdao.buscarSite(cpfb.getURL());
            Hotel h = hdao.buscarHotel(cpfb.getCNPJ());
            p.setHotel(h);
            p.setSite(s);
            p.setPreco(cpfb.getPreco());
            p.setDataInicial(dataInicial);
            p.setDataFinal(dataFinal);
            pdao.gravarPromocao(p);
            request.setAttribute("mensagem", "Promocao registrada com sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getLocalizedMessage());
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
