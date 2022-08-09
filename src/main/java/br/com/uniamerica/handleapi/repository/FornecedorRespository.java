package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRespository extends JpaRepository<Fornecedor,Long> {

    @Modifying
    @Query("UPDATE Fornecedor fornecedor " +
            "SET fornecedor.ativo = false " +
            "WHERE fornecedor.id = :fornecedor")
    public void desativar(@Param("fornecedor") Long idFornecedor);

}
