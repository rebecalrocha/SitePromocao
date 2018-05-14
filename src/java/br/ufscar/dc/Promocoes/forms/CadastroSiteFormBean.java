package br.ufscar.dc.Promocoes.forms;
import java.util.ArrayList;
import java.util.List;

public class CadastroSiteFormBean {

    private String  URL, nome, senha, telefone;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

  public List<String> validar() {
          List<String> mensagens = new ArrayList<String>();
          if (URL.trim().length() == 0) {
            mensagens.add("URL não pode ser vazia!");
          }
          if (nome.trim().length() == 0) {
              mensagens.add("Nome não pode ser vazio!");
          }
          if (senha.trim().length() == 0) {
              mensagens.add("Senha não pode ser vazia!");
          }
          if (telefone.trim().length() == 0) {
              mensagens.add("Telefone não pode ser vazio!");
          }
          return (mensagens.isEmpty() ? null : mensagens);
      }

}
