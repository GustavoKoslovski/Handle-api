package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.entity.Funcionario;
import br.com.uniamerica.handleapi.entity.Venda;
import br.com.uniamerica.handleapi.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda findById(Long id){
        return this.vendaRepository.findById(id).orElse(new Venda());
    }

    public Page<Venda> listAll(Pageable pageable){
        return this.vendaRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Venda venda){
        this.vendaRepository.save(venda);
    }

    @Transactional
    public void update (Long id, Venda venda){
        if (id == venda.getId()){
            this.vendaRepository.save(venda);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Venda venda){
        if (id == venda.getId()){
            this.vendaRepository.desativar(venda.getId());
        }else {
            throw new RuntimeException();
        }
    }

    public Boolean isClienteNotNull(Venda venda) {
        if (venda.getCliente() != null) {
            return true;
        } else {
            throw new RuntimeException("O cliente nao foi fornecido, favor insira um cliente valido.");
        }
    }

    //public Boolean existsCliente(Venda venda) {}

    public Boolean isClienteCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getCliente().getNome().length(); i++) {
            char chr = venda.getCliente().getNome().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O nome do cliente fornecido nao e valido, favor insira um nome sem caracter especial");
                }
            }
        }
        return true;
    }

    public Boolean isDataNotNull(Venda venda) {
        if (venda.getData() != null) {
            return true;
        } else {
            throw new RuntimeException("A data da venda não foi fornecida, favor insira uma data valida.");
        }
    }

    public Boolean isDataCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ']'};
        for (int i = 0; i < venda.getData().toString().length(); i++) {
            char chr = venda.getData().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("A data da venda fornecida nao e valida, favor insira uma data sem caracter especial.");
                }
            }
        }
        return true;
    }

    public Boolean isDataMenorQueAtual(Venda venda) {
        LocalDateTime dataAtual = LocalDateTime.now();
        if (venda.getData().isBefore(dataAtual)) {
            return true;
        } else {
            throw new RuntimeException("A data da venda e maior que a atual, favor insira uma data valida.");
        }
    }

    public Boolean isRecebidoPositivo(Venda venda){
        if (venda.getRecebido().compareTo(BigDecimal.valueOf(0.0)) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor recebido e negativo, favor insira um valor valido.");
        }
    }

    public Boolean isRecebidoCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getRecebido().toString().length(); i++) {
            char chr = venda.getRecebido().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O valor recebido da venda nao e valido, favor insira um valor sem caracter especial.");
                }
            }
        }
        return true;
    }

    public Boolean isRecebidoNotNull(Venda venda){
        if (venda.getRecebido() != null) {
            return true;
        } else {
            throw new RuntimeException("O valor recebido da venda não foi fornecido, favor insira um valor valido.");
        }
    }

    public Boolean isRecebidoMaiorQueTotal(Venda venda){
        if (venda.getRecebido().compareTo(venda.getTotal()) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor recebido é menor que o total, favor insira um valor valido.");
        }
    }

    public Boolean isTotalPositivo(Venda venda){
        if (venda.getTotal().compareTo(BigDecimal.valueOf(0.0)) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor total e negativo, favor insira um valor valido.");
        }
    }

    public Boolean isTotalCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getTotal().toString().length(); i++) {
            char chr = venda.getTotal().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O valor total da venda nao e valido, favor insira um valor sem caracter especial.");
                }
            }
        }
        return true;
    }

    public Boolean isTotalNotNull(Venda venda){
        if (venda.getTotal() != null) {
            return true;
        } else {
            throw new RuntimeException("O valor total da venda não foi fornecido, favor insira um valor valido.");
        }
    }

    public Boolean isDescontoMaiorQueTotal(Venda venda){
        if (venda.getDesconto().compareTo(venda.getTotal()) == -1) {
            return true;
        } else {
            throw new RuntimeException("O valor de desconto é menor que o total, favor insira um valor valido.");
        }
    }

    public Boolean isDescontoPositivo(Venda venda){
        if (venda.getDesconto().compareTo(BigDecimal.valueOf(0.0)) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor de desconto e negativo, favor insira um valor valido.");
        }
    }

    public Boolean isDescontoCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getDesconto().toString().length(); i++) {
            char chr = venda.getDesconto().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O valor de desconto da venda nao e valido, favor insira um valor sem caracter especial.");
                }
            }
        }
        return true;
    }

    public Boolean isDescontoNotNull(Venda venda){
        if (venda.getDesconto() != null) {
            return true;
        } else {
            throw new RuntimeException("O valor de desconto da venda não foi fornecido, favor insira um valor valido.");
        }
    }



}
