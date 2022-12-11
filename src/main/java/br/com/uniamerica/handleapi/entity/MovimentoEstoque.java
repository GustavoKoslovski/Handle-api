package br.com.uniamerica.handleapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@ToString
@Table(name = "movimento_estoque", schema = "public")
public class MovimentoEstoque extends AbstractEntity {

    @Getter @Setter
    @Column(name = "tipo_movimento", nullable = false)
    private Boolean tipoMovimento;

    @Getter @Setter
    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Getter @Setter
    @Column(name = "valor", nullable = false)
    private Double valor;

    @Getter @Setter
    @Column(name = "quantidade_total", nullable = false)
    private Integer quantidadeTotal;

}
