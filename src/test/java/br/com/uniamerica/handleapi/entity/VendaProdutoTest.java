package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.VendaProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendaProdutoTest {

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

}


