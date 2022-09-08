package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.repository.ClienteRepository;
import br.com.uniamerica.handleapi.repository.FuncionarioRepository;
import br.com.uniamerica.handleapi.repository.ProdutoRepository;
import br.com.uniamerica.handleapi.repository.VendaRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = VendaController.class)
public class VendaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    VendaRepository vendaRepository;
    

}
