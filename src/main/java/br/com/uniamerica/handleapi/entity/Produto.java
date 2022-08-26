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
@Table(name = "produtos", schema = "public")
public class Produto extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;

    @Getter @Setter
    @JoinColumn(name= "idCategoria")
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

    @Getter @Setter
    @JoinColumn(name= "idFornecedor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fornecedor fornecedor;

    @Getter @Setter
    @Column(name = "codigo_de_barras", nullable = false, unique = true, length = 13)
    private String codigoDeBarras;

    @Getter @Setter
    @Column(name = "valor_custo", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorCusto;

    @Getter @Setter
    @Column(name = "valor_venda", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorVenda;

    @Getter @Setter
    @Column(name = "disponivel", nullable = false, columnDefinition = "bool default true")
    private Boolean disponivel;

    public Produto(String nome, Categoria categoria, Fornecedor fornecedor, String codigoDeBarras, BigDecimal valorCusto, BigDecimal valorVenda, Boolean disponivel) {
        this.nome = nome;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.codigoDeBarras = codigoDeBarras;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.disponivel = disponivel;
    }
}
