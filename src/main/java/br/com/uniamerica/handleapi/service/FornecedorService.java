package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.repository.FornecedorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRespository fornecedorRepository;

    public Fornecedor findById(Long id){
        return this.fornecedorRepository.findById(id).orElse(new Fornecedor());
    }

    public Page<Fornecedor> listAll(Pageable pageable){
        return this.fornecedorRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Fornecedor fornecedor){
        this.fornecedorRepository.save(fornecedor);
    }

    @Transactional
    public void update (Long id, Fornecedor fornecedor){
        if (id == fornecedor.getId()){
            this.fornecedorRepository.save(fornecedor);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Fornecedor fornecedor){
        if (id == fornecedor.getId()){
            this.fornecedorRepository.desativar(fornecedor.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
