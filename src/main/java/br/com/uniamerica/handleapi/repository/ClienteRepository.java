package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Modifying
    @Query("UPDATE Cliente cliente " +
            "SET cliente.ativo = false " +
            "WHERE cliente.id = :cliente")
    public void desativar(@Param("cliente") Long idCliente);

        public Cliente findClienteByCpf(String cpf);

}
