package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CategoriaController.class)
public class CategoriaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CategoriaRepository categoriaRepository;

    @Test
    public void findAllCategorias() throws Exception {
        Categoria categoria = new Categoria("teste");
        List<Categoria> categoriaList = List.of(categoria);
        when(categoriaRepository.findAll()).thenReturn(categoriaList);
        this.mockMvc.perform(get("/categorias"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("teste")));

    }
}
