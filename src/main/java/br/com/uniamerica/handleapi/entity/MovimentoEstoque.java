package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@ToString
@Table(name = "movimento_estoque", schema = "public")
public class MovimentoEstoque extends AbstractEntity {

    @Getter @Setter
    @Column(name = "entrada", unique = true, nullable = false, length = 15)
    private Boolean entrada;

    @Getter @Setter
    @Column(name = "saida", unique = true, nullable = false, length = 15)
    private Boolean saida;

    @Getter @Setter
    @Column(name = "data", unique = true, nullable = false, length = 15)
    private LocalDateTime data;

    @Getter @Setter
    @Column(name = "valor", unique = true, nullable = false, length = 15)
    private Double valor;

    @Getter @Setter
    @Column(name = "quantidade", unique = true, nullable = false, length = 15)
    private Integer quantidade;

    @Getter @Setter
//    @OneToMany
    @Column(name = "produtos", unique = true, nullable = false, length = 15)
    private List<Produto> produtos = new ArrayList<>();
}
