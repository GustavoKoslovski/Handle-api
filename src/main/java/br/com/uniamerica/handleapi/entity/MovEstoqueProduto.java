package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "mov_estoque_produto", schema = "public")
public class MovEstoqueProduto extends AbstractEntity{

    @Getter @Setter
    @ManyToOne
    private Produto produto;

    @Getter @Setter
    @ManyToOne
    private MovimentoEstoque movimentoEstoque;

    @Getter @Setter
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
}
