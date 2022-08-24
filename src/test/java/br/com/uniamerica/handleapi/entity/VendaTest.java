package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.VendaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VendaTest {

    @Test
    @DisplayName("Cliente da venda nao e nulo")
    public void isClienteNotNull() {
        Venda venda = new Venda();
        Cliente cliente = new Cliente();
        VendaService vendaService = new VendaService();
        venda.setCliente(cliente);
        assertTrue(vendaService.isClienteNotNull(venda));
    }

    @Test
    @DisplayName("Cliente da venda contem caracter especial")
    public void isClienteCaracter() {
        Venda venda = new Venda();
        Cliente cliente = new Cliente();
        VendaService vendaService = new VendaService();
        cliente.setNome("sad");
        venda.setCliente(cliente);
        assertTrue(vendaService.isClienteCaracter(venda));
    }

    @Test
    @DisplayName("Data da venda nao e nula")
    public void isDataNotNull() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setData(LocalDateTime.of(2020, 4, 18, 20, 20));
        assertTrue(vendaService.isDataNotNull(venda));
    }

    @Test
    @DisplayName("Data da venda contém caracter especial")
    public void isDataCaracter() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setData(LocalDateTime.of(2020, 4, 18, 20, 20));
        assertTrue(vendaService.isDataCaracter(venda));
    }

    @Test
    @DisplayName("Data da venda e menor que a atual")
    public void isDataMenorQueAtual() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setData(LocalDateTime.of(2022, 4, 18, 20, 20));
        assertTrue(vendaService.isDataMenorQueAtual(venda));
    }

    @Test
    @DisplayName("Valor recebido da venda e positivo")
    public void isRecebidoPositivo() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setRecebido(BigDecimal.valueOf(20));
        assertTrue(vendaService.isRecebidoPositivo(venda));
    }

    @Test
    @DisplayName("Valor recebido da venda tem caracter especial")
    public void isRecebidoCaracter() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setRecebido(BigDecimal.valueOf(20));
        assertTrue(vendaService.isRecebidoCaracter(venda));
    }

    @Test
    @DisplayName("Valor recebido da venda nao e nulo")
    public void isRecebidoNotNull() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setRecebido(BigDecimal.valueOf(20));
        assertTrue(vendaService.isRecebidoNotNull(venda));
    }

    @Test
    @DisplayName("Valor recebido da venda e maior que o valor total")
    public void isRecebidoMaiorQueTotal() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setTotal(BigDecimal.valueOf(30));
        venda.setRecebido(BigDecimal.valueOf(30));
        assertTrue(vendaService.isRecebidoMaiorQueTotal(venda));
    }

    @Test
    @DisplayName("Valor total da venda e positivo")
    public void isTotalPositivo() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setTotal(BigDecimal.valueOf(20));
        assertTrue(vendaService.isTotalPositivo(venda));
    }

    @Test
    @DisplayName("Valor total da venda tem caracter especial")
    public void isTotalCaracter() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setTotal(BigDecimal.valueOf(20));
        assertTrue(vendaService.isTotalCaracter(venda));
    }

    @Test
    @DisplayName("Valor total da venda nao e nulo")
    public void isTotalNotNull() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setTotal(BigDecimal.valueOf(20));
        assertTrue(vendaService.isTotalNotNull(venda));
    }

    @Test
    @DisplayName("Valor de desconto da venda e maior que o valor total")
    public void isDescontoMaiorQueTotal() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setTotal(BigDecimal.valueOf(30.0));
        venda.setDesconto(BigDecimal.valueOf(20.0));
        assertTrue(vendaService.isDescontoMaiorQueTotal(venda));
    }

    @Test
    @DisplayName("Valor de desconto da venda e positivo")
    public void isDescontoPositivo() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setDesconto(BigDecimal.valueOf(20));
        assertTrue(vendaService.isDescontoPositivo(venda));
    }

    @Test
    @DisplayName("Valor de desconto da venda tem caracter especial")
    public void isDescontoCaracter() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setDesconto(BigDecimal.valueOf(20));
        assertTrue(vendaService.isDescontoCaracter(venda));
    }

    @Test
    @DisplayName("Valor de desconto da venda nao e nulo")
    public void isDescontoNotNull() {
        Venda venda = new Venda();
        VendaService vendaService = new VendaService();
        venda.setDesconto(BigDecimal.valueOf(20));
        assertTrue(vendaService.isDescontoNotNull(venda));
    }
}