package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    @Modifying
    @Query("UPDATE Categoria categoria " +
            "SET categoria.ativo = false " +
            "WHERE categoria.id = :categoria")
    public void desativar(@Param("categoria") Long idCategoria);

}
