package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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

}
