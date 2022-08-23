package br.com.uniamerica.handleapi.service;

import br.com.uniamerica.handleapi.entity.MovEstoqueProduto;
import br.com.uniamerica.handleapi.entity.MovimentoEstoque;
import br.com.uniamerica.handleapi.repository.MovimentoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MovimentoEstoqueService {

    @Autowired
    public MovimentoEstoqueRepository movimentoEstoqueRepository;

    public MovimentoEstoque findById(Long id){
        return this.movimentoEstoqueRepository.findById(id).orElse(new MovimentoEstoque());
    }

    public Page<MovimentoEstoque> listAll(Pageable pageable){
        return this.movimentoEstoqueRepository.findAll(pageable);
    }

    @Transactional
    public void insert(MovimentoEstoque movimentoEstoque){
        this.movimentoEstoqueRepository.save(movimentoEstoque);
    }

    @Transactional
    public void update (Long id, MovimentoEstoque movimentoEstoque){
        if (id == movimentoEstoque.getId()){
            this.movimentoEstoqueRepository.save(movimentoEstoque);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, MovimentoEstoque movimentoEstoque){
        if (id == movimentoEstoque.getId()){
            this.movimentoEstoqueRepository.desativar(movimentoEstoque.getId());
        }else {
            throw new RuntimeException();
        }
    }

    // TESTES MOVIMENTO ESTOQUE //

    //VALIDA SE ENTRADA DO ESTOQUE NAO E NULL
    public Boolean isMvEstoqueNotNull(MovimentoEstoque movimentoEstoque) {
        if (movimentoEstoque.getEntrada() == null) {
            throw new RuntimeException("Favor insira uma entrada.");
        } else {
            return true;
        }
    }

}
