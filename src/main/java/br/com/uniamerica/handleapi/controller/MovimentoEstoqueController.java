package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.MovEstoqueProduto;
import br.com.uniamerica.handleapi.entity.MovimentoEstoque;
import br.com.uniamerica.handleapi.service.MovimentoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/movimentos_estoque")
public class MovimentoEstoqueController {

    @Autowired
    MovimentoEstoqueService movimentoEstoqueService;

    @GetMapping("/{idMovimentoEstoque}")
    public ResponseEntity<MovimentoEstoque> findById(@PathVariable("idMovimentoEstoque") Long idMovimentoEstoqueService) {
        return ResponseEntity.ok().body(this.movimentoEstoqueService.findById(idMovimentoEstoqueService));
    }

    @GetMapping
    public ResponseEntity<Page<MovimentoEstoque>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.movimentoEstoqueService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody MovimentoEstoque movimentoEstoque) {
        try {
            return ResponseEntity.ok().body(this.movimentoEstoqueService.insert(movimentoEstoque));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idMovimentoEstoque}")
    public ResponseEntity<?> update(@PathVariable Long idMovimentoEstoque, @RequestBody MovimentoEstoque movimentoEstoque) {
        try {
            this.movimentoEstoqueService.update(idMovimentoEstoque, movimentoEstoque);
            return ResponseEntity.ok().body("atualizado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idMovimentoEstoque}")
    public ResponseEntity<?> desativar(@PathVariable Long idMovimentoEstoque, @RequestBody MovimentoEstoque movimentoEstoque) {
        try {
            this.movimentoEstoqueService.desativar(idMovimentoEstoque, movimentoEstoque);
            return ResponseEntity.ok().body(" desativado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
