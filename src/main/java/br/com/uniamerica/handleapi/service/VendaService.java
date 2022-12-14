package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.*;
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

    VendaProdutoService vendaProdutoService = new VendaProdutoService();

    @Autowired
    private VendaRepository vendaRepository;

    public Venda findById(Long id){
        return this.vendaRepository.findById(id).orElse(new Venda());
    }

    public Page<Venda> listAll(Pageable pageable){
        return this.vendaRepository.findAll(pageable);
    }

    @Transactional
    public Venda insert(Venda venda){
        return this.vendaRepository.save(venda);
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
                    throw new RuntimeException("O nome do cliente fornecido n??o ?? v??lido, favor insira um nome sem caracter especial.");
                }
            }
        }
        return true;
    }





    public Boolean isRecebidoPositivo(Venda venda){
        if (venda.getValorRecebido().compareTo(BigDecimal.valueOf(0.0)) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor recebido ?? negativo, favor insira um valor v??lido.");
        }
    }

    public Boolean isRecebidoCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getValorRecebido().toString().length(); i++) {
            char chr = venda.getValorRecebido().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O valor recebido da venda n??o ?? v??lido, favor insira um valor sem caracter especial.");
                }
            }
        }
        return true;
    }

    public Boolean isRecebidoNotNull(Venda venda){
        if (venda.getValorRecebido() != null) {
            return true;
        } else {
            throw new RuntimeException("O valor recebido da venda n??o foi fornecido, favor insira um valor v??lido.");
        }
    }

    public Boolean isRecebidoMaiorQueTotal(Venda venda){
        if (venda.getValorRecebido().compareTo(venda.getValorTotal()) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor recebido ?? menor que o total, favor insira um valor v??lido.");
        }
    }

    public Boolean isTotalPositivo(Venda venda){
        if (venda.getValorTotal().compareTo(BigDecimal.valueOf(0.0)) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor total ?? negativo, favor insira um valor v??lido.");
        }
    }

    public Boolean isTotalCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getValorTotal().toString().length(); i++) {
            char chr = venda.getValorTotal().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O valor total da venda n??o ?? valido, favor insira um valor sem caracter especial.");
                }
            }
        }
        return true;
    }

    public Boolean isTotalNotNull(Venda venda){
        if (venda.getValorTotal() != null) {
            return true;
        } else {
            throw new RuntimeException("O valor total da venda n??o foi fornecido, favor insira um valor valido.");
        }
    }

    public Boolean isDescontoMaiorQueTotal(Venda venda){
        if (venda.getValorDesconto().compareTo(venda.getValorTotal()) == -1) {
            return true;
        } else {
            throw new RuntimeException("O valor de desconto ?? menor que o total, favor insira um valor valido.");
        }
    }

    public Boolean isDescontoPositivo(Venda venda){
        if (venda.getValorDesconto().compareTo(BigDecimal.valueOf(0.0)) != -1) {
            return true;
        } else {
            throw new RuntimeException("O valor de desconto e negativo, favor insira um valor valido.");
        }
    }

    public Boolean isDescontoCaracter(Venda venda) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getValorDesconto().toString().length(); i++) {
            char chr = venda.getValorDesconto().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O valor de desconto da venda n??o ?? v??lido, favor insira um valor sem caracter especial.");
                }
            }
        }
        return true;
    }

    public void setValorTotal(Venda venda, VendaProduto vendaProduto[]){
        for (int i = 0; i <= vendaProduto.length; i++){
            venda.setValorTotal(venda.getValorTotal().add(vendaProduto[i].getPrecoFinal()));
        }
    }

    public void setValorFinal(Venda venda){
        venda.setValorFinal(venda.getValorTotal().subtract(venda.getValorDesconto()));
    }

    public void setValorTroco(Venda venda){
        venda.setValorTroco(venda.getValorRecebido().subtract(venda.getValorFinal()));
    }

//    public boolean validarCadastro(Venda venda){
//        if(this.isClienteCaracter(venda) == true &&
//                this.isClienteNotNull(venda) == true &&
//                //this.isDataMenorQueAtual(venda) == true &&
//                this.isDescontoCaracter(venda) == true &&
//                this.isDescontoNotNull(venda) == true &&
//                this.isDescontoPositivo(venda) == true &&
//                this.isDescontoMaiorQueTotal(venda) == true &&
//                this.isTotalCaracter(venda) == true &&
//                this.isTotalNotNull(venda) == true &&
//                this.isTotalPositivo(venda) == true &&
//                this.isRecebidoCaracter(venda) == true &&
//                this.isRecebidoNotNull(venda) == true &&
//                this.isDescontoNotNull(venda) == true &&
//                this.isRecebidoCaracter(venda) == true &&
//                this.isRecebidoNotNull(venda) == true &&
//                this.isRecebidoMaiorQueTotal(venda) == true &&
//                this.isRecebidoPositivo(venda) == true
//        ){
//            return true;
//        }else{
//            return false;
//        }
//    }



}
