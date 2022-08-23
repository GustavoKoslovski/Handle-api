package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Cliente;
import br.com.uniamerica.handleapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> findById(@PathVariable("idCliente") Long idCliente) {
        return ResponseEntity.ok().body(this.clienteService.findById(idCliente));
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.clienteService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Cliente cliente) {
        try {
            this.clienteService.insert(cliente);
            return ResponseEntity.ok().body("Cliente cadastrado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<?> update(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        try {
            this.clienteService.update(idCliente, cliente);
            return ResponseEntity.ok().body("Cliente atualizado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idCliente}")
    public ResponseEntity<?> desativar(@PathVariable Long idCliente, @RequestBody Cliente cliente) {
        try {
            this.clienteService.desativar(idCliente, cliente);
            return ResponseEntity.ok().body("Cliente desativado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 2c4c4e6ffdec176cd210e56d2458d1d16c3f579c
}
