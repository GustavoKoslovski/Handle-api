package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Produto;
import br.com.uniamerica.handleapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id){
        return this.produtoRepository.findById(id).orElse(new Produto());
    }

    public Page<Produto> listAll(Pageable pageable){
        return this.produtoRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Produto produto){
        this.produtoRepository.save(produto);
    }

    @Transactional
    public void update (Long id, Produto produto){
        if (id == produto.getId()){
            this.produtoRepository.save(produto);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Produto produto){
        if (id == produto.getId()){
            this.produtoRepository.desativar(produto.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
