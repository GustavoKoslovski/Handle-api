package br.com.uniamerica.handleapi.repository;

import br.com.uniamerica.handleapi.entity.Funcionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // TESTA CPF DO FUNCIONARIO //
    @Test
    public void insertFuncionario() {
            Funcionario funcionario = new Funcionario("Ricardo", "55555555555", "09050114903", "0516546854321654", LocalDate.now(), "51564651654", 5800.55);
            funcionarioRepository.save(funcionario);

            Integer countFuncionario = funcionarioRepository.findAll().size();

            assertEquals(1, countFuncionario);

        }



    }
