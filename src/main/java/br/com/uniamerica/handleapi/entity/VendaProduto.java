package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "vendas_produtos", schema = "public")
public class VendaProduto extends AbstractEntity{

    @Getter @Setter
    @ManyToOne
    private Venda venda;

    @Getter @Setter
    @ManyToOne
    private Produto produto;

    @Getter @Setter
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Getter @Setter
    @Column(name = "precoUnitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Getter @Setter
    @Column(name = "precoTotalBruto", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoTotalBruto;

    @Getter @Setter
    @Column(name = "desconto", nullable = false, precision = 10, scale = 2)
    private BigDecimal desconto;

    @Getter @Setter
    @Column(name = "precoComDesconto", nullable = false, precision = 10, scale = 2)
    private BigDecimal precoComDesconto;

}
