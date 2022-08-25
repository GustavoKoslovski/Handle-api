package br.com.uniamerica.handleapi.entity;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Table(name = "fornecedores", schema = "public")
public class Fornecedor extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, length = 15)
    private String telefone;

    @Getter @Setter
    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;



    public Fornecedor(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
