package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.FornecedorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FornecedorTest {

    //** Teste iniciais do Fornecedor **//
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
    //****//

    //** Teste de nome do Fornecedor **//
    @Test
    public void isNomeNotNull() {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorService fornecedorService = new FornecedorService();

        fornecedor.setNome("fds");
        assertTrue(fornecedorService.isNomeNotNull(fornecedor));
    }

    @Test
    public void isNomeCaracter() {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorService fornecedorService = new FornecedorService();

        fornecedor.setNome("sad");
        assertTrue(fornecedorService.isNomeCaracter(fornecedor));
    }
    //****//

    //** Teste de telefone do Fornecedor **//
   @Test
    public void isTelefoneMaior(){
       Fornecedor fornecedor = new Fornecedor();
       FornecedorService fornecedorService = new FornecedorService();

       fornecedor.setTelefone("12345678912");
       assertTrue(fornecedorService.isTelefoneMenor(fornecedor));
   }

    @Test
    public void isTelefonNotNull(){
        Fornecedor fornecedor = new Fornecedor();
        FornecedorService fornecedorService = new FornecedorService();

        fornecedor.setTelefone("SDA");
        assertTrue(fornecedorService.isTelefoneNotNull(fornecedor));
    }

    @Test
    public void isTelefoneCaracter() {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorService fornecedorService = new FornecedorService();

        fornecedor.setTelefone("sad");
        assertTrue(fornecedorService.isTelefoneCaracter(fornecedor));
    }

    @Test
    public void isTelefoneNumber() {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorService fornecedorService = new FornecedorService();

        fornecedor.setTelefone("dsaf");
        assertTrue(fornecedorService.isTelefoneNumber(fornecedor));
    }
    //****//

    //** Teste de endereço do Fornecedor **//
    @Test
    public void isEnderecoNotNull() {
        Fornecedor fornecedor = new Fornecedor();
        FornecedorService fornecedorService = new FornecedorService();

        fornecedor.setNome("fds");
        assertTrue(fornecedorService.isEnderecoNotNull(fornecedor));
    }
    //****//


}
