package br.com.uniamerica.handleapi.service;

import br.com.uniamerica.handleapi.entity.Produto;
import br.com.uniamerica.handleapi.entity.Venda;
import br.com.uniamerica.handleapi.entity.VendaProduto;
import br.com.uniamerica.handleapi.repository.VendaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class VendaProdutoService {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    public VendaProduto findById(Long id){
        return this.vendaProdutoRepository.findById(id).orElse(new VendaProduto());
    }

    public Page<VendaProduto> listAll(Pageable pageable){
        return this.vendaProdutoRepository.findAll(pageable);
    }

    @Transactional
    public void insert(VendaProduto vendaProduto){
        this.vendaProdutoRepository.save(vendaProduto);
    }

    @Transactional
    public void update (Long id, VendaProduto vendaProduto){
        if (id == vendaProduto.getId()){
            this.vendaProdutoRepository.save(vendaProduto);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, VendaProduto vendaProduto){
        if (id == vendaProduto.getId()){
            this.vendaProdutoRepository.desativar(vendaProduto.getId());
        }else {
            throw new RuntimeException();
        }
    }

    //VENDA

    //Validacao NotNull Venda
    public Boolean isVendaNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getVenda() == null) {
            throw new RuntimeException("A categoria nao foi fornecida.");
        } else {
            return true;
        }
    }


}

