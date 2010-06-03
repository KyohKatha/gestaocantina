/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Katha
 */
public class ACP {

    private ArrayList<Produto> produtos;

    public ACP() {
        produtos = new ArrayList<Produto>();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void gerarABC() {
        double valorTotalEstoque = 0;
        //calcula a media mensal de quantidade comprada de cada produto
        for (int i = 0; i < produtos.size(); i++) {
            ArrayList<DadosMes> h = produtos.get(i).getHistorico();
            int qtdMedia = 0;
            for (int j = 0; j < h.size(); j++) {
                qtdMedia += h.get(j).getQtdCompra();
            }
            qtdMedia /= h.size();
            produtos.get(i).setQtdMediaMensal(qtdMedia);
            System.out.println("Produto1: " + produtos.get(i).getNome());
            valorTotalEstoque += produtos.get(i).valorProdutoEstoque();
        }
        //calcular a porcentagem de cada produto no estoque
        for (int i = 0; i < produtos.size(); i++) {
            double porcentagem = produtos.get(i).valorProdutoEstoque() / valorTotalEstoque;
            produtos.get(i).setPorcentagem(porcentagem);
        }
        //ordena os produtos pela porcentagem
        Collections.sort(produtos, new Comparator() {

            public int compare(Object o1, Object o2) {
                Produto p1 = (Produto) o1;
                Produto p2 = (Produto) o2;
                return p1.getPorcentagem() < p2.getPorcentagem() ? +1 : (p1.getPorcentagem() > p2.getPorcentagem() ? -1 : 0);
            }
        });
        /*for(int i = 0; i < produtos.size(); i++){
        System.out.println("Produto2: "+produtos.get(i).getNome()+"porcentagem: "+produtos.get(i).getPorcentagem());
        }*/

        double numProdTipoA = produtos.size() * 0.2;
        double numProdTipoB = produtos.size() * 0.3;
        double numProdTipoC = produtos.size() * 0.5;
        System.out.println("A: " + numProdTipoA + "B: " + numProdTipoB + "C: " + numProdTipoC);
        int i = 0;
        while (i < numProdTipoA) {
            produtos.get(i).setTipo(0);
            i++;
        }
        while (i < numProdTipoB + numProdTipoA) {
            produtos.get(i).setTipo(1);
            i++;
        }
        while (i < numProdTipoC + numProdTipoB + numProdTipoA) {
            produtos.get(i).setTipo(2);
            i++;
        }
        for (i = 0; i < produtos.size(); i++) {
            System.out.println("Produto2: " + produtos.get(i).getNome() + " Tipo: " + produtos.get(i).getTipo());
        }
    }

    public void MRP() {
    }

    public void loteEconomicoPedidos() {
    }

    public void revisaoContinua() {
    }

    public void sistemasRevisaoPeriodica() {
    }
}

