package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Categoria;
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
    //** Validação de nome da Categoria **//

    public Boolean isNomeNotNull(Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new RuntimeException("O nome não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

    public Boolean isNomeCaracter(Categoria categoria) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < categoria.getNome().length(); i++) {
            char chr = categoria.getNome().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O nome fornecido nao e valido, favor insira um nome sem caracter especial");
                }
            }
        }
        return true;
    }

}
