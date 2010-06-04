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

    public double getCustoMedioMensal() {
        return custoMedioMensal;
    }

    public void setCustoMedioMensal(double custoMedioMensal) {
        this.custoMedioMensal = custoMedioMensal;
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
}

