package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.repository.CategoriaRepository;
import br.com.uniamerica.handleapi.repository.VendaProdutoRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = VendaProdutoController.class)
public class VendaProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    VendaProdutoRepository vendaProdutoRepository;
}
