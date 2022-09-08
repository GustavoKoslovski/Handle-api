package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "mov_estoque_produto", schema = "public")
public class MovEstoqueProduto extends AbstractEntity{

    @Getter @Setter
    @JoinColumn(name= "idProduto")
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    @Getter @Setter
    @JoinColumn(name= "idMovimentoEstoque")
    @ManyToOne(fetch = FetchType.EAGER)
    private MovimentoEstoque movimentoEstoque;

    @Getter @Setter
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
}
