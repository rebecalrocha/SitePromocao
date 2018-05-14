package br.ufscar.dc.Promocoes.forms;
import java.util.ArrayList;
import java.util.List;

public class UsuarioFormBean {

  
  private String  prenome, sobrenome, login, senha;
  private Boolean permissao;

    public String getPrenome() {
        return prenome;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getPermissao() {
        return permissao;
    }

    public void setPermissao(Boolean permissao) {
        this.permissao = permissao;
    }



    public List<String> validar() {
        List<String> mensagens = new ArrayList<String>();
        if (login.equals("")) {
            mensagens.add("Login não pode ser vazio!");
        }
        if (senha.equals("")) {
            mensagens.add("Senha não pode ser vazia!");
        }
        return (mensagens.isEmpty() ? null : mensagens);
    }

}
