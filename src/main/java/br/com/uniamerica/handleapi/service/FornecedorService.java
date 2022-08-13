package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.repository.FornecedorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Array;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRespository fornecedorRepository;

    public Fornecedor findById(Long id) {
        return this.fornecedorRepository.findById(id).orElse(new Fornecedor());
    }

    public Page<Fornecedor> listAll(Pageable pageable) {
        return this.fornecedorRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Fornecedor fornecedor) {
        this.fornecedorRepository.save(fornecedor);
    }

    @Transactional
    public void update(Long id, Fornecedor fornecedor) {
        if (id == fornecedor.getId()) {
            this.fornecedorRepository.save(fornecedor);
        } else {
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Fornecedor fornecedor) {
        if (id == fornecedor.getId()) {
            this.fornecedorRepository.desativar(fornecedor.getId());
        } else {
            throw new RuntimeException();
        }
    }

    //** Validação de nome do Fornecedor **//

    public Boolean isNomeNotNull(Fornecedor fornecedor) {
        if (fornecedor.getNome() == null || fornecedor.getNome().isEmpty()) {
            throw new RuntimeException("O nome não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

    public Boolean isNomeCaracter(Fornecedor fornecedor) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < fornecedor.getNome().length(); i++) {
            char chr = fornecedor.getNome().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O nome fornecido nao e valido, favor insira um nome sem caracter especial");
                }
            }
        }
        return true;
    }

    //****//

    //** Validação de telefone do Fornecedor **//

    public Boolean isTelefoneNotNull(Fornecedor fornecedor) {
        if (fornecedor.getTelefone() != null || fornecedor.getTelefone().isEmpty()) {
            throw new RuntimeException("Telefone é invalido");
        } else {
            return true;
        }
    }

    public Boolean isTelefoneMenor(Fornecedor fornecedor) {
        if (fornecedor.getTelefone().length() == 11) {
            return true;
        } else {
            throw new RuntimeException("Telefone é invalido");
        }
    }

    public Boolean isTelefoneCaracter(Fornecedor fornecedor) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < fornecedor.getTelefone().length(); i++) {
            char chr = fornecedor.getTelefone().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O telefone fornecido nao e valido, favor insira um telefone sem caracter especial.");
                }
            }
        }
        return true;
    }

    public Boolean isTelefoneNumber(Fornecedor fornecedor){
            char[] charSearch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
            for (int i = 0; i < fornecedor.getTelefone().length(); i++) {
                char chr = fornecedor.getTelefone().charAt(i);
                for (int j = 0; j < charSearch.length; j++) {
                    if (charSearch[j] == chr) {
                        return true;
                    }
                }
            }
        throw new RuntimeException("O telefone contem letras.");
    }
    //****//

    //** Validação de endereço do Fornecedor **//

    public Boolean isEnderecoNotNull(Fornecedor fornecedor) {
        if (fornecedor.getEndereco() == null || fornecedor.getEndereco().isEmpty()) {
            throw new RuntimeException("O endereco não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }
    //****//

}