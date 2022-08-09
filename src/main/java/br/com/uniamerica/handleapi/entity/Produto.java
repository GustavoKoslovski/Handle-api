package br.com.uniamerica.handleapi.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    @ManyToOne
    private Categoria categoria;

    @Getter @Setter
    @ManyToOne
    private Fornecedor fornecedor;

    @Getter @Setter
    @Column(name = "codigo_de_barras", nullable = false, unique = true, length = 13)
    private Long codigoDeBarras;

    @Getter @Setter
    @Column(name = "valor_custo", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorCusto;

    @Getter @Setter
    @Column(name = "valor_venda", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorVenda;

    @Getter @Setter
    @Column(name = "disponivel", nullable = false, columnDefinition = "bool default true")
    private Boolean disponivel;

}
