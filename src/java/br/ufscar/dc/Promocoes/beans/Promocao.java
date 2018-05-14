package br.ufscar.dc.Promocoes.beans;
import java.util.Date;

public class Promocao {

    private Hotel Hotel;
    private Site Site;
    private String preco;
    private Date dataInicial, dataFinal;

    public Hotel getHotel() {
        return Hotel;
    }

    public void setHotel(Hotel Hotel) {
        this.Hotel = Hotel;
    }

    public Site getSite() {
        return Site;
    }

    public void setSite(Site Site) {
        this.Site = Site;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
}