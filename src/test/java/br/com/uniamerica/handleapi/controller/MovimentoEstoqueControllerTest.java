package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.repository.MovimentoEstoqueRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MovimentoEstoqueController.class)
public class MovimentoEstoqueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MovimentoEstoqueRepository movimentoEstoqueRepository;
}
