package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.CategoriaService;
import br.com.uniamerica.handleapi.service.VendaProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendaProdutoTest {

    //VENDA

    //Testa se Venda nao e null
    @Test
    @DisplayName("Venda nao e nula - VendaProduto")
    public void isVendaNotNull() {
        VendaProduto vendaProduto = new VendaProduto();
        Venda venda = new Venda();
        VendaProdutoService vendaProdutoService = new VendaProdutoService();

        vendaProduto.setVenda(venda);
        assertTrue(vendaProdutoService.isVendaNotNull(vendaProduto));
    }

    //PRODUTO

    //Testa se Produto nao e null
    @Test
    @DisplayName("Produto nao e nula - VendaProduto")
    public void isProdutoNotNull() {
        VendaProduto vendaProduto = new VendaProduto();
        Produto produto = new Produto();
        VendaProdutoService vendaProdutoService = new VendaProdutoService();

        vendaProduto.setProduto(produto);
        assertTrue(vendaProdutoService.isProdutoNotNull(vendaProduto));
    }

    //QUANTIDADE

    //Testa se Quantidade nao e null
    @Test
    @DisplayName("Quantidade nao e nula - VendaProduto")
    public void isQuantidadeNotNull() {
        VendaProduto vendaProduto = new VendaProduto();
        VendaProdutoService vendaProdutoService = new VendaProdutoService();

        vendaProduto.setQuantidade(1);
        assertTrue(vendaProdutoService.isQuantidadeNotNull(vendaProduto));
    }

    //PRECO UNITARIO

    //Testa se PrecoUnitario nao e null
    @Test
    @DisplayName("PrecoUnitario nao e nula - VendaProduto")
    public void isPrecoUnitarioNotNull() {
        VendaProduto vendaProduto = new VendaProduto();
        VendaProdutoService vendaProdutoService = new VendaProdutoService();
        BigDecimal precoUnitario = new BigDecimal(0);

        vendaProduto.setPrecoUnitario(precoUnitario);
        assertTrue(vendaProdutoService.isPrecoUnitarioNotNull(vendaProduto));
    }

    @Test
    public void precoFinalTest(){
        VendaProduto vendaProduto = new VendaProduto();
        VendaProdutoService vendaProdutoService = new VendaProdutoService();
        Produto produto = new Produto();
        produto.setValorVenda(BigDecimal.valueOf(5));
        vendaProduto.setProduto(produto);
        vendaProduto.setQuantidade(5);
        vendaProdutoService.setPrecoUnitario(vendaProduto);
        vendaProdutoService.setPrecoFinal(vendaProduto);

        System.out.println(vendaProduto.getPrecoFinal());

    }


}




