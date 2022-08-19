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
            throw new RuntimeException("O cliente não foi fornecido, favor insira um cliente válido.");
        }
    }

    //public Boolean existsCliente(Venda venda) {}

    public Boolean isClienteCaracter(Venda venda) {

        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getCliente().getNome().length(); i++) {
            char chr = venda.getCliente().getNome().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O nome do cliente fornecido nao e válido, favor insira um nome sem caracter especial");
                }
            }
        }
        return true;
    }

    public Boolean isDataNotNull(Venda venda) {
        if (venda.getData() != null) {
            return true;
        } else {
            throw new RuntimeException("A data da venda não foi fornecida, favor insira uma data válida.");
        }
    }

    public Boolean isDataCaracter(Venda venda) {

        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < venda.getData().toString().length(); i++) {
            char chr = venda.getData().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("A data da venda fornecida nao e válida, favor insira uma data sem caracter especial.");
                }
            }
        }
        return true;
    }
}
