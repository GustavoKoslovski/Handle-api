package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.entity.Produto;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Test
    public void insertProduto() {


        Categoria categoria = new Categoria();
        categoria.setNome("bobo");

        Fornecedor fornecedor = new Fornecedor("Vinicius", "45998383259", "RuaEvaristodaVeiga");

        this.fornecedorRepository.save(fornecedor);

        Produto produto = new Produto("CocaCola", categoria, fornecedor, "1233211233211", BigDecimal.valueOf(20.0), BigDecimal.valueOf(30.0), true);

        produtoRepository.save(produto);

    }

}
