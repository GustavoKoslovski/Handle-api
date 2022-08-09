package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Produto;
import br.com.uniamerica.handleapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> findById(@PathVariable("idProduto") Long idProduto) {
        return ResponseEntity.ok().body(this.produtoService.findById(idProduto));
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.produtoService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Produto produto) {
        try {
            this.produtoService.insert(produto);
            return ResponseEntity.ok().body("Produto cadastrado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<?> update(@PathVariable Long idProduto, @RequestBody Produto produto) {
        try {
            this.produtoService.update(idProduto, produto);
            return ResponseEntity.ok().body("Produto atualizado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idProduto}")
    public ResponseEntity<?> desativar(@PathVariable Long idProduto, @RequestBody Produto produto) {
        try {
            this.produtoService.desativar(idProduto, produto);
            return ResponseEntity.ok().body("Produto desativado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
