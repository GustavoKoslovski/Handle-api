package br.com.uniamerica.handleapi.entity;

import br.com.uniamerica.handleapi.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProdutoTest {

    @Test
    @DisplayName("Testa se o nome do produto é nulo")
    public void isNomeNotNull(){
        Produto produto = new Produto();
        ProdutoService produtoService = new ProdutoService();

        produto.setNome("Coca-cola");
        assertTrue(produtoService.isNomeNotNull(produto));
    }

    @Test
    @DisplayName("Testa se o nome do produto contém caracter especial")
    public void isNomeCaracter() {
        Produto produto = new Produto();
        ProdutoService produtoService = new ProdutoService();

        produto.setNome("sad");
        assertTrue(produtoService.isNomeCaracter(produto));
    }

    //CATEGORIA
    @Test
    @DisplayName("Testa se a categoria é nula")
    public void isCategoriaNotNull(){
        Produto produto = new Produto();
        Categoria categoria = new Categoria();
        ProdutoService produtoService = new ProdutoService();

        produto.setCategoria(categoria);
        assertTrue(produtoService.isCategoriaNotNull(produto));
    }

    //CODIGO DE BARRA
    //Validação se é NotNull
    @Test
    @DisplayName("Testa se o código de barras é nulo")
    public void isCodigoBarraNotNull(){
        Produto produto = new Produto();
        ProdutoService produtoService = new ProdutoService();

        produto.setCodigoDeBarras("1234523457897");
        assertTrue(produtoService.isCodigoBarraNotNull(produto));

    }

    @Test
    @DisplayName("Testa se o código de barras contém 13 caracteres")
    public void isCodigoBarraMenor(){
        Produto produto = new Produto();
        ProdutoService produtoService = new ProdutoService();

        produto.setCodigoDeBarras("12345678912");
        assertTrue(produtoService.isCodigoBarraMenor(produto));
    }

    @Test
    @DisplayName("Testa se o código de barras contém caracter especial")
    public void isCodigoBarrasCaracter() {
        Produto produto = new Produto();
        ProdutoService produtoService = new ProdutoService();

        produto.setCodigoDeBarras("222222222222!");
//        produto.setCodigoDeBarras("222222222222");
        assertTrue(produtoService.isCodigoBarrasCaracter(produto));
    }
    @Test
    @DisplayName("Testa se o Fornecedor não é nulo")
    public void isFornecedorNotNull(){
        Produto produto = new Produto();
        Fornecedor fornecedor = new Fornecedor();
        ProdutoService produtoService = new ProdutoService();

        produto.setFornecedor(fornecedor);
        assertTrue(produtoService.isFornecedorNotNull(produto));
    }

    @Test
    @DisplayName("Testa se o fornecedor contém caracter especial")
    public void isFornecedorCaracter() {
        Produto produto = new Produto();
        Fornecedor fornecedor = new Fornecedor();
        ProdutoService produtoService = new ProdutoService();
        fornecedor.setId(1L);
        produto.setFornecedor(fornecedor);
        assertTrue(produtoService.isFornecedorCaracter(produto));
    }


}






