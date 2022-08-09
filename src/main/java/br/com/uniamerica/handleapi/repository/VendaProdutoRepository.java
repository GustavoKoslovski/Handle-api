package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaProdutoRepository extends JpaRepository<VendaProduto,Long> {

    @Modifying
    @Query("UPDATE VendaProduto vendaProduto " +
            "SET vendaProduto.ativo = false " +
            "WHERE vendaProduto.id = :vendaProduto")
    public void desativar(@Param("vendaProduto") Long idVendaProduto);

}
