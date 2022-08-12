package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.FornecedorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        fornecedor.setTelefone("45999807990");

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

   @Test
    public void isTelefoneMaior(){
       Fornecedor fornecedor = new Fornecedor();
       FornecedorService fornecedorService = new FornecedorService();

       fornecedor.setTelefone("12345678912");
       assertTrue(fornecedorService.isTelefoneMenor(fornecedor));
   }

   @Test
    public void isNomeNotNull() {
       Fornecedor fornecedor = new Fornecedor();
       FornecedorService fornecedorService = new FornecedorService();

       fornecedor.setNome("SKA");
       assertTrue(fornecedorService.isNomeNotNull(fornecedor));

   }


}
