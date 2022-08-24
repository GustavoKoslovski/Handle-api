package br.com.uniamerica.handleapi.repository;

import br.com.uniamerica.handleapi.entity.Fornecedor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FornecedorRepositoryTest {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Test
    @DisplayName("inserindo 1 fornecedor e listando")
    public void insertFornecedor() {

        Fornecedor fornecedor = new Fornecedor("gustavo", "998387234", "soadj");
        fornecedorRepository.save(fornecedor);

        Integer countFornecedor = fornecedorRepository.findAll().size();

        assertEquals(1, countFornecedor);

    }


}
