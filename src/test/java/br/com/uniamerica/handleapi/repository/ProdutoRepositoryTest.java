package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.entity.Produto;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@WebMvcTest()
public class ProdutoRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoRepository produtoRepository;

    @MockBean
    private CategoriaRepository categoriaRepository;

    @MockBean
    private FornecedorRepository fornecedorRepository;

    @Test
    public void insertProduto() {
        Produto produto = new Produto();

        Categoria categoria = new Categoria("bobo");
        categoriaRepository.save(categoria);

        Fornecedor fornecedor = new Fornecedor("Vinicius", "45998383259", "RuaEvaristodaVeiga");
        fornecedorRepository.save(fornecedor);


        produto.setNome("CocaCola");
        produto.setCategoria(categoria);
        produto.setFornecedor(fornecedor);
        produto.setCodigoDeBarras("1233211233211");
        produto.setValorCusto(BigDecimal.valueOf(20.0));
        produto.setValorVenda(BigDecimal.valueOf(30.0));
        produto.setDisponivel(true);

        produtoRepository.save(produto);

        int countProduto = produtoRepository.findAll().size();
        assertEquals(1, countProduto);

    }

}
