package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.ClienteService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    //** Teste de nome do Cliente **//

    //Testa se nome nao e null
    @Test
    public void isNomeNotNull() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setNome("Ricardo");
        assertTrue(clienteService.isNomeNotNull(cliente));
    }

    //Testa Caracter Especial
    @Test
    public void isNomeCaracter() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setNome("sad");
        assertTrue(clienteService.isNomeCaracter(cliente));
    }

    //** Teste de CPF do Cliente **//

    //Testa se CPF nao e null
    @Test
    public void isCpfNotNull() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setCpf("");
        assertTrue(clienteService.isCpfNotNull(cliente));
    }

    //Testa se CPF tem menos de 11 caracteres
    @Test
    public void isCpfMenor() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setCpf("12349567892");
        assertTrue(clienteService.isCpfMenor(cliente));
    }

    //Testa se CPF tem caracter especial
    @Test
    public void isCpfCaracter() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setCpf("222222222222!");
        assertTrue(clienteService.isCpfCaracter(cliente));
    }

    //Testa se Telefone e null ou empty
    @Test
    public void isTelefoneNotNull() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setTelefone("");
        assertTrue(clienteService.isTelefoneNotNull(cliente));

    }

    //Testa se Telefone tem menos de 11 caracteres
    @Test
    public void isTelefoneMenor() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setTelefone("222");
        assertTrue(clienteService.isTelefoneMenor(cliente));
    }

    //Testa se Telefone tem Caracter especial
    @Test
    public void isTelefoneCaracter() {
        Cliente cliente = new Cliente();
        ClienteService clienteService = new ClienteService();

        cliente.setTelefone("255");
        assertTrue(clienteService.isTelefoneCaracter(cliente));
        }
    }
