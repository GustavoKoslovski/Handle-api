package br.com.uniamerica.handleapi.repository;

import br.com.uniamerica.handleapi.entity.MovEstoqueProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovEstoqueProdutoRepository extends JpaRepository<MovEstoqueProduto, Long> {
    @Modifying
    @Query("UPDATE MovEstoqueProduto movEstoqueProduto" +
            " SET movEstoqueProduto.ativo = false " +
            "WHERE movEstoqueProduto.id = :movEstoqueProduto")
    public void desativar(@Param("movEstoqueProduto") Long idMovEstoqueProduto);

}
