package br.ufscar.dc.Promocoes.forms;
import java.util.ArrayList;
import java.util.List;

public class CadastroHotelFormBean {

    private String CNPJ, nome, senha, cidade;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
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

    public String getCidade() {
      return cidade;
    }

    public void setCidade(String cidade) {
      this.cidade = cidade;
    }

      public List<String> validar() {
              List<String> mensagens = new ArrayList<String>();
              if (CNPJ.trim().length() == 0) {
                  mensagens.add("CNPJ não pode ser vazio!");
              }
              if (nome.trim().length() == 0) {
                  mensagens.add("Nome não pode ser vazio!");
              }
              if (cidade.trim().length() == 0) {
                  mensagens.add("Cidade não pode ser vazia!");
              }
              if (senha.trim().length() == 0) {
                  mensagens.add("Senha não pode ser vazia!");
              }
              return (mensagens.isEmpty() ? null : mensagens);
      }





}
