package br.com.uniamerica.handleapi.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "fornecedores", schema = "public")
public class Fornecedor extends AbstractEntity {

    @Getter @Setter
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Getter @Setter
    @Column(name = "telefone", nullable = false, length = 18)
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
