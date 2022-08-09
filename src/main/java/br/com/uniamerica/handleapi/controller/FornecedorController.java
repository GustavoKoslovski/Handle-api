package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Fornecedor;
import br.com.uniamerica.handleapi.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;
    @GetMapping("/{idFornecedor}")
    public ResponseEntity<Fornecedor> findById(@PathVariable("idFornecedor") Long idFornecedor) {
        return ResponseEntity.ok().body(this.fornecedorService.findById(idFornecedor));
    }

    @GetMapping
    public ResponseEntity<Page<Fornecedor>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.fornecedorService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Fornecedor fornecedor) {
        try {
            this.fornecedorService.insert(fornecedor);
            return ResponseEntity.ok().body("Fornecedor cadastrado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idFornecedor}")
    public ResponseEntity<?> update(@PathVariable Long idFornecedor, @RequestBody Fornecedor fornecedor) {
        try {
            this.fornecedorService.update(idFornecedor, fornecedor);
            return ResponseEntity.ok().body("Fornecedor atualizado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idFornecedor}")
    public ResponseEntity<?> desativar(@PathVariable Long idFornecedor, @RequestBody Fornecedor fornecedor) {
        try {
            this.fornecedorService.desativar(idFornecedor, fornecedor);
            return ResponseEntity.ok().body("Fornecedor desativado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
