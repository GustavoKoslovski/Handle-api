package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.VendaProduto;
import br.com.uniamerica.handleapi.service.VendaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/vendas_produtos")
public class VendaProdutoController {

    @Autowired
    VendaProdutoService vendaProdutoService;
    @GetMapping("/{idVendaProduto}")
    public ResponseEntity<VendaProduto> findById(@PathVariable("idVendaProduto") Long idVendaProduto) {
        return ResponseEntity.ok().body(this.vendaProdutoService.findById(idVendaProduto));
    }

    @GetMapping
    public ResponseEntity<Page<VendaProduto>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.vendaProdutoService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody VendaProduto vendaProduto) {
        try {
            this.vendaProdutoService.insert(vendaProduto);
            return ResponseEntity.ok().body("VendaProduto cadastrada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idVendaProduto}")
    public ResponseEntity<?> update(@PathVariable Long idVendaProduto, @RequestBody VendaProduto vendaProduto) {
        try {
            this.vendaProdutoService.update(idVendaProduto, vendaProduto);
            return ResponseEntity.ok().body("VendaProduto atualizada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idVendaProduto}")
    public ResponseEntity<?> desativar(@PathVariable Long idVendaProduto, @RequestBody VendaProduto vendaProduto) {
        try {
            this.vendaProdutoService.desativar(idVendaProduto, vendaProduto);
            return ResponseEntity.ok().body("VendaProduto desativada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
