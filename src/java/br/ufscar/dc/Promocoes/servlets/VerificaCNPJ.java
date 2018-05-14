package br.ufscar.dc.Promocoes.servlets;
import br.ufscar.dc.Promocoes.dao.HotelDAO;
import br.ufscar.dc.Promocoes.beans.Hotel;
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

@WebServlet(name = "VerificaCNPJ", urlPatterns = {"/VerificaCNPJ"})
public class VerificaCNPJ extends HttpServlet {
    
    @Resource(name = "jdbc/PromocaoBD")
    DataSource dataSource;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        
        HotelDAO pdao = new HotelDAO(dataSource);
        String CNPJ = request.getParameter("CNPJ");
        String senha = request.getParameter("senha");
        
        List<Hotel> todosHoteis = null;
        todosHoteis = pdao.buscarHotelPromocao(CNPJ,senha);
        try {
            if(todosHoteis == null){
                request.getRequestDispatcher("Loggin_promocao_hotel.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("CadastroPromocao.jsp").forward(request, response);
            }

        } catch (IOException | ServletException e) {
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
            Logger.getLogger(VerificaCNPJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(VerificaCNPJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
