package br.com.uniamerica.handleapi.entity;
import br.com.uniamerica.handleapi.service.ClienteService;
import br.com.uniamerica.handleapi.service.ProdutoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProdutoTest {

    @Test
    public void isNomeNotNull(){
        Produto produto = new Produto();
        ProdutoService produtoService = new ProdutoService();

        produto.setNome("Coca-cola");
        assertTrue(produtoService.isNomeNotNull(produto));
    }

    @Test
    public void isNomeCaracter() {
        Produto produto = new Produto();
        ProdutoService produtoService = new ProdutoService();

        produto.setNome("sad");
        assertTrue(produtoService.isNomeCaracter(produto));
    }

}






