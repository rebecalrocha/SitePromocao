package br.ufscar.dc.Promocoes.dao;
import br.ufscar.dc.Promocoes.beans.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.naming.NamingException;

public class HotelDAO {
    private final static String CRIAR_HOTEL_SQL = "insert into Hotel"
            + "(CNPJ, nome, senha, cidade)"
            + "values (?,?,?,?)";

    private final static String BUSCAR_HOTEL_SQL = "select *"
            + " from Hotel"
            + " where CNPJ = ?";
    
    
    private final static String BUSCAR_HOTEL_PROMOCAO_SQL = "select *"
            + " from Hotel"
            + " where CNPJ = ? and senha = ?";
    
     private final static String LISTAR_HOTEL_SQL = "select *"
            + "from Hotel";
     
     private final static String LISTAR_HOTEL_CIDADE_SQL = "select * "
            + "from Hotel "
            + "where cidade = ?";
    
    DataSource dataSource;

    public HotelDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public Hotel gravarHotel(Hotel h) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_HOTEL_SQL);) {
            ps.setString(1, h.getCNPJ());
            ps.setString(2, h.getNome());
            ps.setString(3, h.getSenha());
            ps.setString(4, h.getCidade());
            ps.execute();
            
        }
        return h;
    }

    public Hotel buscarHotel(String CNPJ) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_HOTEL_SQL);) {
            ps.setString(1, CNPJ);

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                Hotel u = new Hotel();
                u.setCNPJ(rs.getString("CNPJ"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setCidade(rs.getString("cidade"));
                return u;
            }
        }
    }
    
    public List<Hotel> buscarHotelPromocao(String CNPJ, String senha) throws SQLException, NamingException {
        List<Hotel> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_HOTEL_PROMOCAO_SQL)) {
            ps.setString(1, CNPJ);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                Hotel h = new Hotel();
                h.setCNPJ(rs.getString("CNPJ"));
                h.setNome(rs.getString("nome"));
                h.setSenha(rs.getString("senha"));
                h.setCidade(rs.getString("cidade"));

            }catch(Exception e){
                e.printStackTrace();
                ret = null;
            }
        }
        return ret;
    }
    
    public List<Hotel> listarTodosHoteis() throws SQLException, NamingException {
        List<Hotel> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_HOTEL_SQL)) {


            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel h = new Hotel();
                    h.setCNPJ(rs.getString("CNPJ"));
                    h.setNome(rs.getString("nome"));
                    h.setCidade(rs.getString("cidade"));
                    ret.add(h);
                }
            }
        }
        return ret;
    }
    
    public List<Hotel> listarHoteisPorCidade(String cidade) throws SQLException {
        List<Hotel> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_HOTEL_CIDADE_SQL)) {
            ps.setString(1, cidade);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Hotel h = new Hotel();
                    h.setCNPJ(rs.getString("CNPJ"));
                    h.setNome(rs.getString("nome"));
                    h.setCidade(rs.getString("cidade"));
                    ret.add(h);               
                }
            }
        }
        return ret;
    }
}