package br.com.uniamerica.handleapi.service;
import br.com.uniamerica.handleapi.entity.VendaProduto;
import br.com.uniamerica.handleapi.repository.VendaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class VendaProdutoService {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    public VendaProduto findById(Long id){
        return this.vendaProdutoRepository.findById(id).orElse(new VendaProduto());
    }

    public Page<VendaProduto> listAll(Pageable pageable){
        return this.vendaProdutoRepository.findAll(pageable);
    }

    @Transactional
    public void insert(VendaProduto vendaProduto){

        this.validarCadastro(vendaProduto);
        this.vendaProdutoRepository.save(vendaProduto);
    }

    @Transactional
    public void update (Long id, VendaProduto vendaProduto){
        if (id == vendaProduto.getId()){
            this.vendaProdutoRepository.save(vendaProduto);
        }
        else{
            throw new RuntimeException();
        }
    }

    @Transactional
    public void desativar(Long id, VendaProduto vendaProduto){
        if (id == vendaProduto.getId()){
            this.vendaProdutoRepository.desativar(vendaProduto.getId());
        }else {
            throw new RuntimeException();
        }
    }

    //VENDA

    //Validacao NotNull Venda
    public Boolean isVendaNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getVenda() == null) {
            throw new RuntimeException("A Venda nao foi fornecida.");
        } else {
            return true;
        }
    }

    //PRODUTO

    //Validacao NotNull Venda
    public Boolean isProdutoNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getProduto() == null) {
            throw new RuntimeException("O Produto nao foi fornecida.");
        } else {
            return true;
        }
    }

    //QUANTIDADE

    //Validacao NotNull Quantidade
    public Boolean isQuantidadeNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getQuantidade() == null) {
            throw new RuntimeException("A Quantidade não foi fornecido");
        } else {
            return true;
        }
    }

    //PRECO UNITARIO

    //Validacao NotNull PrecoUnitario
    public Boolean isPrecoUnitarioNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getPrecoUnitario() == null) {
            throw new RuntimeException("O Preco Unitario não foi fornecido");
        } else {
            return true;
        }
    }

    //PRECO TOTAL BRUTO

    //Validacao NotNull PrecoTotalBruto
    public Boolean isPrecoTotalBrutoNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getPrecoTotalBruto() == null) {
            throw new RuntimeException("O Preco Total Bruto não foi fornecido");
        } else {
            return true;
        }
    }

    //DESCONTO

    //Validacao NotNull Desconto
    public Boolean isDescontoNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getValorDesconto() == null) {
            throw new RuntimeException("O Desconto não foi fornecido");
        } else {
            return true;
        }
    }

    //PRECO COM DESCONTO

    //Validacao NotNull PrecoComDesconto
    public Boolean isPrecoComDescontoNotNull(VendaProduto vendaProduto) {
        if (vendaProduto.getPrecoComDesconto() == null) {
            throw new RuntimeException("O PrecoComDesconto não foi fornecido");
        } else {
            return true;
        }
    }


    public Boolean validaQuantidade(VendaProduto vendaProduto) {
        if (vendaProduto.getQuantidade() <= vendaProduto.getProduto().getQuantidade()) {
            return true;
        } else {
            throw new RuntimeException("Quantidade de " + vendaProduto.getProduto().getNome() + " informada insuficiente em estoque");

        }
    }

    public boolean validarCadastro(VendaProduto vendaProduto){
        if(this.validaQuantidade(vendaProduto) == true
        ){
            return true;

        }else{
            return false;
        }
    }
}

