package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "vendas_produtos", schema = "public")
public class VendaProduto extends AbstractEntity{

    @Getter @Setter
    @JoinColumn(name= "idVenda")
    @ManyToOne(fetch = FetchType.EAGER)
    private Venda venda;

    @Getter @Setter
    @JoinColumn(name= "idProduto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    @Getter @Setter
    @Column(name = "quantidade")
    private Integer quantidade;

    @Getter @Setter
    @Column(name = "preco_unitario", precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Getter @Setter
    @Column(name = "preco_final", precision = 10, scale = 2)
    private BigDecimal precoFinal;

    public VendaProduto(Venda venda, Produto produto, Integer quantidade, BigDecimal precoUnitario, BigDecimal precoFinal) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoFinal = precoFinal;
    }
}
