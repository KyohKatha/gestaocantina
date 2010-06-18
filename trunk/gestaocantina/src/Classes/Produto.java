/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Katha
 */
public class Produto {

    private ArrayList<DadosMes> historico;
    private String nome;
    private int qtdAtual;
    private int qtdSeguranca;
    private int qtdMediaMensal;
    private double custoMedioMensal;
    private double custoSistema;

    public double getCustoSistema() {
        return custoSistema;
    }

    public void setCustoSistema(double custoSistema) {
        this.custoSistema = custoSistema;
    }

    // MRP
    private String sTipoLote;
    private String sLeadTime;
    private int iDemanda;
    private int iRecPrevisto;
    private int iEstoque;
    private int iNecLiquida;
    private int iQtdOF_OC;

    public double getCustoMedioMensal() {
        return custoMedioMensal;
    }

    public void setCustoMedioMensal(double custoMedioMensal) {
        this.custoMedioMensal = custoMedioMensal;
    }

    public void calcularCustoMedioMensal(){
        double soma = 0.0;
        for (int i = 0; i < historico.size(); i++) {
            soma += historico.get(i).getQtdCompra();
        }
        soma /= historico.size();
        this.setCustoMedioMensal(soma);
    }

    //Calcula a demanda
    public double calcularDemanda(int t) {
        double demanda = 0.0;

        for (int i = 1; i <= t; i++) {
            demanda += historico.get(historico.size() - i).getQtdVenda();
        }
        return demanda;
    }

    //Calculo da demanda médio no tempo de espera
    public double calcularDemandaMedia(int t) {
        double demanda = 0.0;

        for (int i = 1; i <= t; i++) {
            demanda += historico.get(historico.size() - i).getQtdVenda();
        }
        demanda /= t;
        return demanda;
    }

    // Calulo do desvio padrao da demanda no tempo de espera
    public double calcularDesvioPadraoDemanda(int t){
        double dp = 0.0;
        double media = this.calcularDemandaMedia(t);

        for (int i = 1; i <= t; i++) {
            dp += Math.pow(historico.get(historico.size() - i).getQtdVenda() - media, 2);
        }

        dp /= (t - 1);

        return Math.sqrt(dp);
    }

    //tipo: A = 0 B = 1 C = 2
    private double porcentagem;

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }
    private int tipo;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double valorProdutoEstoque() {
        return custoMedioMensal * qtdMediaMensal;
    }

    public int getQtdMediaMensal() {
        return qtdMediaMensal;
    }

    public void setQtdMediaMensal(int qtdMediaMensal) {
        this.qtdMediaMensal = qtdMediaMensal;
    }

    public Produto(){
        historico = new ArrayList<DadosMes>();
    }
    
    public ArrayList<DadosMes> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<DadosMes> historico) {
        this.historico = historico;
    }

    public void addHistorico(DadosMes dadosMes) {

        this.historico.add(dadosMes);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public int getQtdSeguranca() {
        return qtdSeguranca;
    }

    public void setQtdSeguranca(int qtdSeguranca) {
        this.qtdSeguranca = qtdSeguranca;
    }

    public String getsTipoLote() {
        return sTipoLote;
    }

    public String getsLeadTime() {
        return sLeadTime;
    }

    public void setsLeadTime(String sLeadTime) {
        this.sLeadTime = sLeadTime;
    }

    /**
     * @return the iDemanda
     */
    public int getiDemanda() {
        return iDemanda;
    }

    /**
     * @param iDemanda the iDemanda to set
     */
    public void setiDemanda(int iDemanda) {
        this.iDemanda = iDemanda;
    }

    /**
     * @return the iRecPrevisto
     */
    public int getiRecPrevisto() {
        return iRecPrevisto;
    }

    /**
     * @param iRecPrevisto the iRecPrevisto to set
     */
    public void setiRecPrevisto(int iRecPrevisto) {
        this.iRecPrevisto = iRecPrevisto;
    }

    /**
     * @return the iEstoque
     */
    public int getiEstoque() {
        return iEstoque;
    }

    /**
     * @param iEstoque the iEstoque to set
     */
    public void setiEstoque(int iEstoque) {
        this.iEstoque = iEstoque;
    }

    /**
     * @return the iNecLiquida
     */
    public int getiNecLiquida() {
        return iNecLiquida;
    }

    /**
     * @param iNecLiquida the iNecLiquida to set
     */
    public void setiNecLiquida(int iNecLiquida) {
        this.iNecLiquida = iNecLiquida;
    }

    /**
     * @return the iQtdOF_OC
     */
    public int getiQtdOF_OC() {
        return iQtdOF_OC;
    }

    /**
     * @param iQtdOF_OC the iQtdOF_OC to set
     */
    public void setiQtdOF_OC(int iQtdOF_OC) {
        this.iQtdOF_OC = iQtdOF_OC;
    }

    /**
     * @param sTipoLote the sTipoLote to set
     */
    public void setsTipoLote(String sTipoLote) {
        this.sTipoLote = sTipoLote;
    }
}

