package br.ufscar.dc.Promocoes.servlets;
import br.ufscar.dc.Promocoes.forms.CriarPromocaoFormBean;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "CriarPromocaoServlet", urlPatterns = {"/CriarPromocaoServlet"})

public class CriarPromocaoServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        
        request.setCharacterEncoding("UTF-8");
        CriarPromocaoFormBean npfb = new CriarPromocaoFormBean();
        BeanUtils.populate(npfb, request.getParameterMap());
        request.getSession().setAttribute("CriarPromocaoServlet", npfb);
        List<String> mensagens = npfb.validar();
        
        if (mensagens == null) {
            request.getRequestDispatcher("ConfirmarPromocao.jsp").forward(request, response);
        } else {
            request.setAttribute("mensagens", mensagens);
            request.getRequestDispatcher("CadastroPromocao.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(CadastroHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(CadastroHotelServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
