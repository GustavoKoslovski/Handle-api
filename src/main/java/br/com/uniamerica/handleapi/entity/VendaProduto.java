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
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Getter @Setter
    @Column(name = "preco_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Getter @Setter
    @Column(name = "preco_final", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoFinal;

}
