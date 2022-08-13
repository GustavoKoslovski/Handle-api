package br.com.uniamerica.handleapi.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "funcionarios", schema = "public")
public class Funcionario extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Getter @Setter
    @Column(name = "rg", unique = true, nullable = false, length = 15)
    private String rg;

    @Getter @Setter
    @Column(name = "cpf", unique = true, nullable = false, length = 15)
    private String cpf;

    @Getter @Setter
    @Column(name = "pis", unique = true, nullable = false, length = 25)
    private String pis;

    @Getter @Setter
    @Column(name = "data_admissao" )
    private String dataAdmissao;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Getter @Setter
    @Column(name = "salario", nullable = false, precision = 10, scale = 2)
    private Double salario;

}
