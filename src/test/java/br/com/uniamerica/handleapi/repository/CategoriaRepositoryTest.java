package br.com.uniamerica.handleapi.repository;

import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.entity.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @DisplayName("inserindo 1 categoria e listando")
    public void insertCategoria() {

        Categoria categoria = new Categoria("gustavo");
        categoriaRepository.save(categoria);

        Integer countCategoria = categoriaRepository.findAll().size();

        assertEquals(1, countCategoria);

    }

}
