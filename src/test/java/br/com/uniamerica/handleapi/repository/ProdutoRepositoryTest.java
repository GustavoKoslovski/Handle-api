package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    public void insertProduto() {

        Categoria categoria = new Categoria("refrigerante");
        categoriaRepository.save(categoria);

        Fornecedor fornecedor = new Fornecedor("daks","45999056307", "ksoadkas");
        fornecedorRepository.save(fornecedor);

        Produto produto = new Produto();

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
