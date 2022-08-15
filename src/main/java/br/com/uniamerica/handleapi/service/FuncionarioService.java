package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.entity.Funcionario;
import br.com.uniamerica.handleapi.repository.FuncionarioRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario findById(Long id){
        return this.funcionarioRepository.findById(id).orElse(new Funcionario());
    }

    public Page<Funcionario> listAll(Pageable pageable){
        return this.funcionarioRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Funcionario funcionario){
        this.funcionarioRepository.save(funcionario);
    }

    @Transactional
    public void update (Long id, Funcionario funcionario){
        if (id == funcionario.getId()){
            this.funcionarioRepository.save(funcionario);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Funcionario funcionario){
        if (id == funcionario.getId()){
            this.funcionarioRepository.desativar(funcionario.getId());
        }else {
            throw new RuntimeException();
        }
    }

    //******* Validação de nome do Funcionario *******//

    // Valida se o nome é nulo ou vazio. //
    public Boolean isNomeNotNull(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().isEmpty()) {
            throw new RuntimeException("O nome não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

    // Valida se o nome tem caracter especial. //
    public Boolean isNomeCaracter(Funcionario funcionario) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < funcionario.getNome().length(); i++) {
            char chr = funcionario.getNome().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O nome fornecido nao e valido, favor insira um nome sem caracter especial");
                }
            }
        }
        return true;
    }
    //****//

    //******* Validação de telefone do Funcionario *******//

    public Boolean isTelefoneNotNull(Funcionario funcionario) {
        if (funcionario.getTelefone() != null || funcionario.getTelefone().isEmpty()) {
            throw new RuntimeException("Telefone é invalido");
        } else {
            return true;
        }
    }

    // Valida se o telefone tem o tamanho correto de numeros. //
    public Boolean isTelefoneMenor(Funcionario funcionario) {
        if (funcionario.getTelefone().length() == 11) {
            return true;
        } else {
            throw new RuntimeException("Telefone é invalido");
        }
    }

    // Valida se o telefone possui caracter especial. //
    public Boolean isTelefoneCaracter(Funcionario funcionario) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < funcionario.getTelefone().length(); i++) {
            char chr = funcionario.getTelefone().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O telefone fornecido nao e valido, favor insira um telefone sem caracter especial.");
                }
            }
        }
        return true;
    }

    // Valida se o telefone informado possui letras. //
    public Boolean isTelefoneNumber(Funcionario funcionario){
        char[] charSearch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (int i = 0; i < funcionario.getTelefone().length(); i++) {
            char chr = funcionario.getTelefone().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    return true;
                }
            }
        }
        throw new RuntimeException("O telefone contem letras.");
    }
    //****//

    //******* Validação de salario do Funcionario *******//

    public Boolean isSalarioNotNull(Funcionario funcionario) {
        if (funcionario.getTelefone() != null || funcionario.getTelefone().isEmpty()) {
            throw new RuntimeException("Salario e invalido");
        } else {
            return true;
        }
    }

    // Valida se o salário possui caracter especial. //
    public Boolean isSalarioCaracter(Funcionario funcionario) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < funcionario.getTelefone().length(); i++) {
            char chr = funcionario.getTelefone().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O salario fornecido nao e valido, favor insira um salario sem caracter especial.");
                }
            }
        }
        return true;
    }

    // Valida se o salário informado é negativo. //
    public Boolean isSalarioNegativo(Funcionario funcionario){
        if(funcionario.getSalario() > 0){
            return true;
        }else {
            throw new RuntimeException("O salario nao pode ser negativo.");
        }
    }

    //** Validacao de CPF do Funcionario **//

    //Valida CPF not null e nao e empty
    public Boolean isCpfNotNull(Funcionario funcionario) {
        if (funcionario.getCpf() == null || funcionario.getCpf().isEmpty()) {
            throw new RuntimeException("O CPF não foi fornecido, favor insira um CPF valido.");
        } else {
            return true;
        }
    }

    //Valida se CPF tem menos de 11 caracter
    public Boolean isCpfMenor(Funcionario funcionario) {
        if (funcionario.getCpf().length() == 11) {
            return true;
        } else {
            throw new RuntimeException("Cliente é invalido");
        }
    }

    //Valida Caracter Especial do CPF
    public Boolean isCpfCaracter(Funcionario funcionario) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < funcionario.getCpf().length(); i++) {
            char chr = funcionario.getCpf().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O CPF fornecido nao e valido, favor insira um CPF sem caracter especial");
                }
            }
        }
        return true;
    }

    //** Validaçao da Data_Admissao **//

    //Valida se a data informada é mais do que 2 anos no futuro.
    public Boolean isDataMaior(Funcionario funcionario){
        LocalDate datafutura = LocalDate.now().plusYears(2);

        if(funcionario.getDataAdmissao().isBefore(datafutura)){
            return true;
        }else {throw new RuntimeException("A data informada é maior que o permitido");}
    }


}
