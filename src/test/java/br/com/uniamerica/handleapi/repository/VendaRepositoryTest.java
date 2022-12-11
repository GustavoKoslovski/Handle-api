package br.com.uniamerica.handleapi.repository;

import br.com.uniamerica.handleapi.entity.Venda;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VendaRepositoryTest {

    @Autowired
    private VendaRepository vendaRepository;

    @Test
    public void insertVenda(Venda venda){
        vendaRepository.save(venda);
        Integer countVenda = vendaRepository.findAll().size();
        assertEquals(1, countVenda);


    }
}
