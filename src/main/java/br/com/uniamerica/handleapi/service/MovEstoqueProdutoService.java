package br.com.uniamerica.handleapi.service;

import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.entity.MovEstoqueProduto;
import br.com.uniamerica.handleapi.repository.MovEstoqueProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MovEstoqueProdutoService {

    @Autowired
    public MovEstoqueProdutoRepository movEstoqueProdutoRepository;

    public MovEstoqueProduto findById(Long id){
        return this.movEstoqueProdutoRepository.findById(id).orElse(new MovEstoqueProduto());
    }

    public Page<MovEstoqueProduto> listAll(Pageable pageable){
        return this.movEstoqueProdutoRepository.findAll(pageable);
    }

    @Transactional
    public void insert(MovEstoqueProduto movEstoqueProduto){
        this.movEstoqueProdutoRepository.save(movEstoqueProduto);
    }

    @Transactional
    public void update (Long id, MovEstoqueProduto movEstoqueProduto){
        if (id == movEstoqueProduto.getId()){
            this.movEstoqueProdutoRepository.save(movEstoqueProduto);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, MovEstoqueProduto movEstoqueProduto){
        if (id == movEstoqueProduto.getId()){
            this.movEstoqueProdutoRepository.desativar(movEstoqueProduto.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
