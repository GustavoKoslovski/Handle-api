package br.com.uniamerica.handleapi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FornecedorTest {

    //teste ricardo
    @Test
    public void FornecedorNomeTest() {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome("vithor");

        assertEquals("vithor", fornecedor.getNome());
        assertTrue(fornecedor.toString().contains(("Fornecedor{")));

    }

    @Test
    public void FornecedorTelefoneTest() {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setTelefone("4599807990");

        assertTrue(fornecedor.toString().contains(("Fornecedor{")));
        assertEquals(10, fornecedor.getTelefone().length());
    }

    @Test
    public void FornecedorEnderecoTest() {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setEndereco("rua casa");

        assertTrue(fornecedor.toString().contains(("Fornecedor{")));
        assertEquals(10, fornecedor.getEndereco().length());
    }

    
}
