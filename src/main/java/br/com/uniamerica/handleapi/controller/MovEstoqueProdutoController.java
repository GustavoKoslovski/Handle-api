package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Funcionario;
import br.com.uniamerica.handleapi.entity.MovEstoqueProduto;
import br.com.uniamerica.handleapi.service.FuncionarioService;
import br.com.uniamerica.handleapi.service.MovEstoqueProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/mov_estoque_produto")
public class MovEstoqueProdutoController {

    @Autowired
    MovEstoqueProdutoService movEstoqueProdutoService;
    @GetMapping("/{idMovEstoqueProduto}")
    public ResponseEntity<MovEstoqueProduto> findById(@PathVariable("idMovEstoqueProdutoService") Long idMovEstoqueProdutoService) {
        return ResponseEntity.ok().body(this.movEstoqueProdutoService.findById(idMovEstoqueProdutoService));
    }

    @GetMapping
    public ResponseEntity<Page<MovEstoqueProduto>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.movEstoqueProdutoService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody MovEstoqueProduto movEstoqueProdutoService) {
        try {
            this.movEstoqueProdutoService.insert(movEstoqueProdutoService);
            return ResponseEntity.ok().body("cadastrado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idMovEstoqueProduto}")
    public ResponseEntity<?> update(@PathVariable Long idMovEstoqueProduto, @RequestBody MovEstoqueProduto movEstoqueProduto) {
        try {
            this.movEstoqueProdutoService.update(idMovEstoqueProduto, movEstoqueProduto);
            return ResponseEntity.ok().body("atualizado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idMovEstoqueProduto}")
    public ResponseEntity<?> desativar(@PathVariable Long idMovEstoqueProduto, @RequestBody MovEstoqueProduto movEstoqueProduto) {
        try {
            this.movEstoqueProdutoService.desativar(idMovEstoqueProduto, movEstoqueProduto);
            return ResponseEntity.ok().body(" desativado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
