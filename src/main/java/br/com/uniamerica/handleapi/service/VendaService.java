package br.com.uniamerica.handleapi.service;
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

}
