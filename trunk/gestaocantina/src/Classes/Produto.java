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

