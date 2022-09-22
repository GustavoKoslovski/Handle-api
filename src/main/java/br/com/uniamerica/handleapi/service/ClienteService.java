package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        return this.clienteRepository.findById(id).orElse(new Cliente());
    }

    public Page<Cliente> listAll(Pageable pageable){
        return this.clienteRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Cliente cliente){

        this.validarCadastro(cliente);
        this.clienteRepository.save(cliente);
    }

    @Transactional
    public void update (Long id, Cliente cliente){
        if (id == cliente.getId()){
            this.clienteRepository.save(cliente);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Cliente cliente){
        if (id == cliente.getId()){
            this.clienteRepository.desativar(cliente.getId());
        }else {
            throw new RuntimeException();
        }
    }

    //** Validacao de nome do Cliente **//

    //Valida se Nome do cliente nao e null ou empty
    public Boolean isNomeNotNull(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new RuntimeException("O nome não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

    //Valida Caracter Especial
    public Boolean isNomeCaracter(Cliente cliente) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < cliente.getNome().length(); i++) {
            char chr = cliente.getNome().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O nome fornecido nao e valido, favor insira um nome sem caracter especial");
                }
            }
        }
        return true;
    }

    //** Validacao de CPF do Cliente **//

    //Valida CPF not null e nao e empty
    public Boolean isCpfNotNull(Cliente cliente) {
        if (cliente.getCpf() != null || !cliente.getCpf().isEmpty()) {
           return true;
        } else {
            throw new RuntimeException("O CPF é nulo.");
        }
    }

    //Valida se CPF tem menos de 11 caracter
    public Boolean isCpfMenor(Cliente cliente) {
        if (cliente.getCpf().length() == 11) {
            return true;
        } else {
            throw new RuntimeException("Cliente é invalido");
        }
    }

    //Valida Caracter Especial do CPF
    public Boolean isCpfCaracter(Cliente cliente) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < cliente.getCpf().length(); i++) {
            char chr = cliente.getCpf().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O CPF fornecido nao e valido, favor insira um CPF sem caracter especial");
                }
            }
        }
        return true;
    }

    //** Validacao de Telefone do Cliente **//

    //Valida se Telefone do cliente nao e null ou empty
    public Boolean isTelefoneNotNull(Cliente cliente) {
        if (cliente.getTelefone() == null || cliente.getTelefone().isEmpty()) {
            throw new RuntimeException("O telefone não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

    //Valida se Telefone tem menos de 11 caracter
    public Boolean isTelefoneMenor(Cliente cliente) {
        if (cliente.getTelefone().length() == 11) {
            return true;
        } else {
            throw new RuntimeException("Telefone é invalido");
        }
    }

    //Valida Caracter Especial do Telefone
    public Boolean isTelefoneCaracter(Cliente cliente) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < cliente.getTelefone().length(); i++) {
            char chr = cliente.getTelefone().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O CPF fornecido nao e valido, favor insira um CPF sem caracter especial");
                }
            }
        }
        return true;
    }

    public boolean validarCadastro(Cliente cliente){
        if(this.isNomeNotNull(cliente) == true &&
                this.isNomeCaracter(cliente) == true &&
                this.isCpfCaracter(cliente) == true &&
                this.isCpfMenor(cliente) == true &&
                this.isTelefoneCaracter(cliente) == true &&
                this.isTelefoneMenor(cliente) == true &&
                this.isTelefoneNotNull(cliente) == true

        ){
            return true;

        }else{
            return false;
        }
    }



}
