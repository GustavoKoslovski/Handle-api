package br.com.uniamerica.handleapi.service;

import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.entity.Funcionario;
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
        this.validarCadastro(movimentoEstoque);
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
        if (movimentoEstoque.getTipoMovimento() != null) {
            return true;
        } else {
            throw new RuntimeException("Tipo do Movimento nao informado");
        }
    }

    //VALIDA QUANTIDADE TOTAL MVESTOQUE NAO E NULL OU 0
    public Boolean isMvEstoqueQtdNotNull(MovimentoEstoque movimentoEstoque) {
        if (movimentoEstoque.getQuantidadeTotal() != null && movimentoEstoque.getQuantidadeTotal() > 0) {
            return true;
        }else {
            throw new RuntimeException("Quantidade informada invalida");
        }
    }

    //VALIDA VALOR NAO PODE SER NULL
    public Boolean isMvEstoqueValorNotNull(MovimentoEstoque movimentoEstoque) {
        if (movimentoEstoque.getValor() != null && movimentoEstoque.getValor() > 0) {
            return true;
        }else {
            throw new RuntimeException("Valor informado invalido");
        }
    }

    public Boolean validarCadastro(MovimentoEstoque movimentoEstoque){
        if(this.isMvEstoqueNotNull(movimentoEstoque) == true &&
                this.isMvEstoqueValorNotNull(movimentoEstoque) == true &&
                this.isMvEstoqueQtdNotNull(movimentoEstoque) == true){
            return true;
        }else{
            return false;
        }
    }

}
