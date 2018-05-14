package br.ufscar.dc.Promocoes.dao;
import br.ufscar.dc.Promocoes.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.NamingException;

public class UsuarioDAO {

    private final static String BUSCAR_USUARIO_SQL = "SELECT "
            + " u.prenome, u.sobrenome, u.login, u.senha, u.permissao"
            + " FROM Usuario u"
            + " WHERE login=? AND senha=?";
    

    
    DataSource dataSource;

    public UsuarioDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Usuario buscarUsuario(Usuario u) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_USUARIO_SQL)) {
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                Usuario h = new Usuario();
                h.setPrenome(rs.getString("prenome"));
                h.setSobrenome(rs.getString("sobrenome"));
                h.setLogin(rs.getString("login"));
                h.setSenha(rs.getString("senha"));
                h.setPermissao(rs.getBoolean("permissao"));

                return h;
            }
        }
    }

}