package br.com.uniamerica.handleapi.service;

import br.com.uniamerica.handleapi.entity.MovimentoEstoque;
import br.com.uniamerica.handleapi.repository.MovimentoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

}
