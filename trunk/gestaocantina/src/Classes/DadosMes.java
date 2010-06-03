/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author Katha
 */
public class DadosMes {
    private String mes;
    private int ano;
    private double valorUnitCusto;
    private double valorUnitVenda;
    private int qtdCompra;
    private int qtdVenda;

    public int getQtdCompra() {
        return qtdCompra;
    }

    public void setQtdCompra(int qtdCompra) {
        this.qtdCompra = qtdCompra;
    }

    public int getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(int qtdVenda) {
        this.qtdVenda = qtdVenda;
    }

    public double getValorUnitCusto() {
        return valorUnitCusto;
    }

    public void setValorUnitCusto(double valorCusto) {
        this.valorUnitCusto = valorCusto;
    }

    public double getValorUnitVenda() {
        return valorUnitVenda;
    }

    public void setValorUnitVenda(double valorVenda) {
        this.valorUnitVenda = valorVenda;
    }

    /**
     * @return the mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

}
