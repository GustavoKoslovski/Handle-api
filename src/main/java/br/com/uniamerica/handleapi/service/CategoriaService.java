package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Long id){
        return this.categoriaRepository.findById(id).orElse(new Categoria());
    }

    public Page<Categoria> listAll(Pageable pageable){
        return this.categoriaRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Categoria categoria){
        this.categoriaRepository.save(categoria);
    }

    @Transactional
    public void update (Long id, Categoria categoria){
        if (id == categoria.getId()){
            this.categoriaRepository.save(categoria);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Categoria categoria){
        if (id == categoria.getId()){
            this.categoriaRepository.desativar(categoria.getId());
        }else {
            throw new RuntimeException();
        }
    }

}
