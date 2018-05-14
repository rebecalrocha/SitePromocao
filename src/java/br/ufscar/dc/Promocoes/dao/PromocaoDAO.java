package br.ufscar.dc.Promocoes.dao;
import br.ufscar.dc.Promocoes.beans.Promocao;
import br.ufscar.dc.Promocoes.beans.Hotel;
import br.ufscar.dc.Promocoes.beans.Site;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.naming.NamingException;

public class PromocaoDAO {
    private final static String CRIAR_PROMOCAO_SQL = "insert into Promocao"
            + " (Hotel, Site, preco, dataInicial, dataFinal) "
            + " values (?,?,?,?,?)";
    
   private final static String LISTAR_PROMOCAO_POR_SITE_SQL = "select "
            + " h.CNPJ, s.URL, p.preco, p.dataInicial, p.dataFinal"
            + " from Promocao p"
            + " join Site s on p.Site = s.URL"
            + " join Hotel h on p.Hotel = h.CNPJ"
            + " where s.URL = ? and s.senha = ?";

   private final static String LISTAR_PROMOCAO_POR_HOTEL_SQL = "select "
            + " h.CNPJ, s.URL, p.preco, p.dataInicial, p.dataFinal"
            + " from Promocao p"
            + " join Site s on p.Site = s.URL"
            + " join Hotel h on p.Hotel = h.CNPJ"
            + " where h.CNPJ = ? and h.senha = ?";
    
    DataSource dataSource;


    public PromocaoDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void gravarPromocao(Promocao p) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(CRIAR_PROMOCAO_SQL);) {
            ps.setString(1, p.getHotel().getCNPJ());
            ps.setString(2, p.getSite().getURL());
            ps.setString(3, p.getPreco());
            ps.setDate(4, new java.sql.Date(p.getDataInicial().getTime()));
            ps.setDate(5, new java.sql.Date(p.getDataFinal().getTime()));
            ps.execute();
        }
    }

     public List<Promocao> listarTodasPromocoesPorSite(String URL, String senha) throws SQLException, NamingException  {
        List<Promocao> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_PROMOCAO_POR_SITE_SQL)) {
            
            ps.setString(1, URL);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Promocao p = new Promocao();
                    Hotel h = new Hotel();
                    Site s = new Site();
                    h.setCNPJ(rs.getString("CNPJ"));
                    s.setURL(rs.getString("URL"));
                    p.setHotel(h);
                    p.setSite(s);
                    p.setPreco(rs.getString("Preco"));
                    p.setDataInicial(rs.getDate("dataInicial"));
                    p.setDataFinal(rs.getDate("dataFinal"));    
                    ret.add(p);                
                }
            }
        }
        return ret;
    }
     public List<Promocao> listarTodasPromocoesPorHotel(String CNPJ, String senha) throws SQLException, NamingException  {
        List<Promocao> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_PROMOCAO_POR_HOTEL_SQL);) {
            
            ps.setString(1, CNPJ);
            ps.setString(2, senha);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Promocao p = new Promocao();
                    Hotel h = new Hotel();
                    Site s = new Site();
                    h.setCNPJ(rs.getString("CNPJ"));
                    s.setURL(rs.getString("URL"));
                    p.setHotel(h);
                    p.setSite(s);
                    p.setPreco(rs.getString("Preco"));
                    p.setDataInicial(rs.getDate("dataInicial"));
                    p.setDataFinal(rs.getDate("dataFinal"));  
                    ret.add(p);                
                }
            }
        }
        return ret;
    }
   
}