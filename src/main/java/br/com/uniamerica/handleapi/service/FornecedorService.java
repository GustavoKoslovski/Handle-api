package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor findById(Long id) {
        return this.fornecedorRepository.findById(id).orElse(new Fornecedor());
    }

    public Page<Fornecedor> listAll(Pageable pageable) {
        return this.fornecedorRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Fornecedor fornecedor) {

        this.validarCadastro(fornecedor);
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

    // Valida se o nome é nulo ou vazio. //
    public Boolean isNomeNotNull(Fornecedor fornecedor) {
        if (fornecedor.getNome() == null || fornecedor.getNome().isEmpty()) {
            throw new RuntimeException("O nome não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

    // Valida se o nome contem caracter especiais. //
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

    // Valida se o telefone é nulo ou vazio. //
    public Boolean isTelefoneNotNull(Fornecedor fornecedor) {
        if (fornecedor.getTelefone() != null || fornecedor.getTelefone().isEmpty()) {
            throw new RuntimeException("Telefone é invalido");
        } else {
            return true;
        }
    }

    // Valida se o telefone informado tem o tamanho correto. //
    public Boolean isTelefoneMenor(Fornecedor fornecedor) {
        if (fornecedor.getTelefone().length() == 11) {
            return true;
        } else {
            throw new RuntimeException("Telefone é invalido");
        }
    }

    // Valida se o telefone tem caracter especiais. //
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

    // Valida se tem letras no telefone informado. //
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

    // Valida se o endereço informado é nulo ou vazio. //
    public Boolean isEnderecoNotNull(Fornecedor fornecedor) {
        if (fornecedor.getEndereco() == null || fornecedor.getEndereco().isEmpty()) {
            throw new RuntimeException("O endereco não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }
    //****//



    public boolean validarCadastro(Fornecedor fornecedor){
        if(this.isNomeNotNull(fornecedor) == true &&
                this.isNomeCaracter(fornecedor) == true &&
                this.isTelefoneCaracter(fornecedor) == true &&
                this.isTelefoneMenor(fornecedor) == true &&
                this.isTelefoneNotNull(fornecedor) == true &&
                this.isTelefoneNumber(fornecedor) == true &&
                this.isEnderecoNotNull(fornecedor) == true

        ){
            return true;

        }else{
            return false;
        }
    }
}