package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.VendaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendaTest {

    @Test
    @DisplayName("Testa se o cliente da venda não é nulo")
    public void isClienteNotNull() {
        Venda venda = new Venda();
        Cliente cliente = new Cliente();
        VendaService vendaService = new VendaService();
        venda.setCliente(cliente);
        assertTrue(vendaService.isClienteNotNull(venda));
    }


    @Test
    @DisplayName("Testa se o nome do cliente da venda contém caracter especial")
    public void isClienteCaracter() {
        Venda venda = new Venda();
        Cliente cliente = new Cliente();
        VendaService vendaService = new VendaService();

        cliente.setNome("sad");
        venda.setCliente(cliente);
        assertTrue(vendaService.isClienteCaracter(venda));
    }

}
