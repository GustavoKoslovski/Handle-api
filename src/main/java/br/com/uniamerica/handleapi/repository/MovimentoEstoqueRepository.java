package br.com.uniamerica.handleapi.repository;

import br.com.uniamerica.handleapi.entity.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque,Long> {
    @Modifying
    @Query("UPDATE MovimentoEstoque movimentoEstoque" +
            " SET movimentoEstoque.ativo = false " +
            "WHERE movimentoEstoque.id = :movimentoEstoque")
    public void desativar(@Param("movimentoEstoque") Long idMovimentoEstoque);
}
