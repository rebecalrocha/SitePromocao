package br.ufscar.dc.Promocoes.dao;
import br.ufscar.dc.Promocoes.beans.Site;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.naming.NamingException;

public class SiteDAO {
    private final static String CRIAR_SITE_SQL = "insert into Site"
            + " (URL, nome, senha, telefone) "
            + " values (?,?,?,?)";


    private final static String BUSCAR_SITE_SQL = "select *"
            + " from Site";

     private final static String LISTAR_SITE_SQL = "select *"
            + " from Site";
    
    DataSource dataSource;


    public SiteDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Site gravarSite(Site u) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_SITE_SQL);) {
            ps.setString(1, u.getURL());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getTelefone());
            ps.execute();
        }
        return u;
    }


    public Site buscarSite(String URL) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_SITE_SQL);) {


            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                Site u = new Site();
                u.setURL(rs.getString("URL"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setTelefone(rs.getString("telefone"));
                return u;
            }
        }
    }
    
         public List<Site> listarTodosSites() throws SQLException, NamingException {
        List<Site> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_SITE_SQL);) {


            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Site h = new Site();
                    h.setURL(rs.getString("URL"));
                    h.setNome(rs.getString("nome"));
                    h.setSenha(rs.getString("senha"));
                    h.setTelefone(rs.getString("telefone"));
                    ret.add(h);
                }
            }
        }
        return ret;
    }
}
