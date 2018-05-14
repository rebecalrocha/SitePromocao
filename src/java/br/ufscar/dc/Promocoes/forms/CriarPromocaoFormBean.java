package br.ufscar.dc.Promocoes.forms;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CriarPromocaoFormBean {

    private String CNPJ, URL, preco, dataInicial, dataFinal;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

  public List<String> validar() {
        List<String> mensagens = new ArrayList<String>();

        if (preco.trim().length() == 0) {
            mensagens.add("Preço não pode ser vazio!");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(dataInicial);
        } catch (ParseException pe) {
            mensagens.add("Data inicial deve estar no formato dd/mm/aaaa");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(dataFinal);
        } catch (ParseException pe) {
            mensagens.add("Data final deve estar no formato dd/mm/aaaa");
        }
          return (mensagens.isEmpty() ? null : mensagens);
      }

}
