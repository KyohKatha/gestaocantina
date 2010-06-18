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

    private final double S = 0.3;
    private final double H = 0.1;
    private final double C = 0.15; // custo anual de manutenção do estoque cicíclo
    private final double L = 0.3;

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
            int qtdMediaCompra = 0;
            double qtdMediaCusto = 0;
            for (int j = 0; j < h.size(); j++) {
                qtdMediaCompra += h.get(j).getQtdCompra();
                qtdMediaCusto += h.get(j).getValorUnitCusto();
            }
            qtdMediaCompra /= h.size();
            qtdMediaCusto /= h.size();
            produtos.get(i).setQtdMediaMensal(qtdMediaCompra);
            produtos.get(i).setCustoMedioMensal(qtdMediaCusto);
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
        float acumulada = 0;
        while (i < produtos.size()) {
            acumulada += produtos.get(i).getPorcentagem()*100;
            if(acumulada < 80)
                produtos.get(i).setTipo(0);
            else if(acumulada < 95)
                produtos.get(i).setTipo(1);
            else
                produtos.get(i).setTipo(2);
            i++;
        }
        for (i = 0; i < produtos.size(); i++) {
            System.out.println("Produto2: " + produtos.get(i).getNome() + " Tipo: " + produtos.get(i).getTipo());
        }
    }

    public void MRP() {
    }

    public float calcularDemandaMRP(float fAQuantidade, float fA_OF_OC_Pai){
        return fAQuantidade * fA_OF_OC_Pai;
    }

    public int calcularNecessidadeLiquidaMRP(int iADemanda, int iAEstoqueInicial, int iAEstoqueSeguranca){
        return iADemanda - iAEstoqueInicial + iAEstoqueSeguranca;
    }

    public int calcularEstoqueAtualMRP(int iAEstoqueInicial, int iARecPrevisto, int iADemanda){
        return iAEstoqueInicial + iARecPrevisto - iADemanda;
    }

    public void loteEconomicoPedidos() {
        double demanda;
        double lep;
        Produto produto;

        for(int i = 0; i < produtos.size(); i++){

            produto = produtos.get(i);
            //12 pq eh por ano
            demanda = produto.calcularDemanda(12);

            double preco = produto.getHistorico().get(11).getValorUnitVenda();

            lep = Math.sqrt((2 * demanda * (S * preco)) / (H * preco));


            produto.setCustoSistema(lep);
        }





    }

    public void revisaoContinua() {
        Produto produto;
        double q;
        double demanda;
        double rc;

        for(int i = 0; i < produtos.size(); i++){
            produto = produtos.get(i);

            q = produto.getHistorico().get(11).getQtdCompra();
            double preco = produto.getHistorico().get(11).getValorUnitVenda();
            double hSigmaL = produto.calcularDesvioPadraoDemanda(12) * Math.sqrt(L * 12);

            //12 pq eh por ano
            demanda = produto.calcularDemanda(12);
            rc = (q / 2.0) * (H * preco) + (demanda / q) * (S * preco) + (H * preco * hSigmaL);

            produto.setCustoSistema(rc);
        }


    }

    public void sistemasRevisaoPeriodica() {
        double rp;
        Produto produto;
        double demandaPeriodo;
        double demanda;

        for(int i = 0; i < produtos.size(); i++){
            produto = produtos.get(i);

            double preco = produto.getHistorico().get(11).getValorUnitVenda();
            double hSigmaL = produto.calcularDesvioPadraoDemanda(12) * Math.sqrt(L * 12);

            //12 pq eh por ano
            demandaPeriodo = produto.calcularDemandaMedia(12);
            demanda = produto.calcularDemandaMedia(12);
            rp = (demandaPeriodo / 2.0) * (H * preco) + (demanda / demandaPeriodo) * (S * preco) + (H * preco * hSigmaL);

            produto.setCustoSistema(rp);
        }
    }
}

