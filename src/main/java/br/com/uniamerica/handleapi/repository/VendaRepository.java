package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long> {

    @Modifying
    @Query("UPDATE Venda venda " +
            "SET venda.ativo = false " +
            "WHERE venda.id = :venda")
    public void desativar(@Param("venda") Long idVenda);

}
