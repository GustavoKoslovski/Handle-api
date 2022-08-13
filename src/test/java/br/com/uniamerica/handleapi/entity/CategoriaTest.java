package br.com.uniamerica.handleapi.entity;
import br.com.uniamerica.handleapi.service.CategoriaService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoriaTest {

    //** Teste de nome da Categoria **//
    @Test
    public void isNomeNotNull() {
        Categoria categoria = new Categoria();
        CategoriaService categoriaService = new CategoriaService();

        categoria.setNome("fhbds");
        assertTrue(categoriaService.isNomeNotNull(categoria));
    }

    @Test
    public void isNomeCaracter() {
        Categoria categoria = new Categoria();
        CategoriaService categoriaService = new CategoriaService();

        categoria.setNome("sad");
        assertTrue(categoriaService.isNomeCaracter(categoria));
    }
    //****//
}
