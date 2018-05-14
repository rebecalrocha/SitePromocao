package br.ufscar.dc.Promocoes.servlets;
import br.ufscar.dc.Promocoes.dao.HotelDAO;
import br.ufscar.dc.Promocoes.forms.CadastroHotelFormBean;
import br.ufscar.dc.Promocoes.beans.Hotel;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "GravarHotelServlet", urlPatterns = {"/GravarHotelServlet"})
public class GravarHotelServlet extends HttpServlet {

    @Resource(name="jdbc/PromocaoBD")
    DataSource dataSource;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CadastroHotelFormBean npfb = (CadastroHotelFormBean) request.getSession().getAttribute("CadastroHotelServlet");
        request.getSession().removeAttribute("CadastroHotelServlet");
        HotelDAO mdao = new HotelDAO(dataSource);

        try {
            Hotel h = new Hotel();
            h.setCNPJ(npfb.getCNPJ());
            h.setNome(npfb.getNome());
            h.setCidade(npfb.getCidade());
            h.setSenha(npfb.getSenha());
            h = mdao.gravarHotel(h);
            request.setAttribute("mensagem", "Hotel registrado com sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getLocalizedMessage());
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
