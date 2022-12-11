package br.com.uniamerica.handleapi.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "categorias", schema = "public")
public class Categoria extends AbstractEntity{

    @Getter @Setter
    @Column(name = "nome", unique = true, length = 50)
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }
}