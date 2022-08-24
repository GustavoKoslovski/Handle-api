package br.com.uniamerica.handleapi.repository;
import br.com.uniamerica.handleapi.entity.Cliente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;
    @Test
    @DisplayName("inserindo 1 cliente e listando")
    public void insertCliente() {

            Cliente cliente = new Cliente("gustavo","14183941903","45999056307");
            clienteRepository.save(cliente);

            Integer countCliente = clienteRepository.findAll().size();

            assertEquals(1, countCliente);

        }
    }

