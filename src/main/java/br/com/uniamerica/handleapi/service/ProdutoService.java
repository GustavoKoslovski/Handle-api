package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.Produto;
import br.com.uniamerica.handleapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id){
        return this.produtoRepository.findById(id).orElse(new Produto());
    }

    public Page<Produto> listAll(Pageable pageable){
        return this.produtoRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Produto produto){

        this.validarCadastro(produto);
        this.quantidadeNull(produto);
        this.produtoRepository.save(produto);
    }

    @Transactional
    public void update (Long id, Produto produto){
        if (id == produto.getId()){
            this.produtoRepository.save(produto);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, Produto produto){
        if (id == produto.getId()){
            this.produtoRepository.desativar(produto.getId());
        }else {
            throw new RuntimeException();
        }
    }

    //Valida se Nome do produto nao e null ou empty
    public Boolean isNomeNotNull(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isEmpty()) {
            throw new RuntimeException("O nome não foi fornecido, favor insira um nome valido.");
        } else {
            return true;
        }
    }

    //Valida Caracter Especial
    public Boolean isNomeCaracter(Produto produto) {
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < produto.getNome().length(); i++) {
            char chr = produto.getNome().charAt(i);
            for (int j = 0; j < charSearch.length; j++) {
                if (charSearch[j] == chr) {
                    throw new RuntimeException("O nome fornecido nao e valido, favor insira um nome sem caracter especial");
                }
            }
        }
        return true;
    }

    //CATEGORIA

    //Validacao NotNull Categoria
    public Boolean isCategoriaNotNull(Produto produto) {
        if (produto.getCategoria() == null) {
            throw new RuntimeException("A categoria nao foi fornecida.");
        } else {
            return true;
        }
    }

    //CÓD. DE BARRA
    //Validação NotNull Código
    public Boolean isCodigoBarraNotNull(Produto produto){
        if(produto.getCodigoDeBarras() != null){
            return true;
        } else {
            throw new RuntimeException("O Codigo de barra não foi fornecida.");
        }
    }

    //Validação 13 carácter
    public Boolean isCodigoBarraMenor(Produto produto) {
        if (produto.getCodigoDeBarras().length() != 13) {
            return true;
        } else {
            throw new RuntimeException("Código de Barras é invalido");
        }
    }

    //Caracter especial
    public Boolean isCodigoBarrasCaracter(Produto produto){
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < produto.getCodigoDeBarras().length(); i++){
            char chr = produto.getCodigoDeBarras().charAt(i);
            for (int j = 0; j < charSearch.length; j++){
                if (charSearch[j] == chr){
                    throw new RuntimeException("O numero de categoria fornecido nao é valido, favor insira um codigo de barras sem caracter especial");
                }
            }
        }
        return true;
    }

    //Verificar se o Fornecedor é nulo
    public Boolean isFornecedorNotNull(Produto produto){
        if(produto.getFornecedor() != null){
            return true;
        } else {
            throw new RuntimeException("O Fornecedor não foi fornecida.");
        }
    }

    public Boolean isFornecedorCaracter(Produto produto){
        char[] charSearch = {'[', '@', '_', '!', '#', '$', '%', '^', '&', '*', '(', ')', '<', '>', '?', '/', '|', '}', '{', '~', ':', ']'};
        for (int i = 0; i < produto.getFornecedor().getId().toString().length(); i++){
            char chr = produto.getFornecedor().getId().toString().charAt(i);
            for (int j = 0; j < charSearch.length; j++){
                if (charSearch[j] == chr){
                    throw new RuntimeException("Favor insira um fornecedor sem caracter especial");
                }
            }
        }
        return true;
    }



    public boolean validarCadastro(Produto produto){
        if(this.isNomeNotNull(produto) == true &&
              this.isNomeCaracter(produto) == true &&
                this.isCategoriaNotNull(produto) == true &&
                this.isCodigoBarraNotNull(produto) == true &&
                this.isCodigoBarrasCaracter(produto) == true &&
                this.isCodigoBarraMenor(produto) == true &&
                this.isFornecedorNotNull(produto) == true &&
                this.isFornecedorCaracter(produto) == true &&
                this.valorDeVendaMenor(produto) == true
        ){
            return true;

        }else{
            return false;
        }
    }


    public void quantidadeNull (Produto produto){
        if(produto.getQuantidade()==null){
            produto.setQuantidade(0);
        }
    }

    public Boolean valorDeVendaMenor (Produto produto) {
        if (produto.getValorVenda().compareTo(produto.getValorCusto()) == 0 || produto.getValorVenda().compareTo(produto.getValorCusto()) == -1) {
            return true;
        }else{
            throw new RuntimeException("O valor de venda não pode ser menor ou igual ao de custo");
        }

    }
}
