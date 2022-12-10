package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Venda;
import br.com.uniamerica.handleapi.entity.VendaProduto;
import br.com.uniamerica.handleapi.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    VendaService vendaService;
    @GetMapping("/{idVenda}")
    public ResponseEntity<Venda> findById(@PathVariable("idVenda") Long idVenda) {
        return ResponseEntity.ok().body(this.vendaService.findById(idVenda));
    }

    @GetMapping
    public ResponseEntity<Page<Venda>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.vendaService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestParam(required = false, name = "venda") Venda venda , @RequestParam(required = false, name = "vendaProduto") VendaProduto[] vendaProdutos) {
        try {
            this.vendaService.insert(venda, vendaProdutos);

            return ResponseEntity.ok().body("Venda cadastrada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idVenda}")
    public ResponseEntity<?> update(@PathVariable Long idVenda, @RequestBody Venda venda) {
        try {
            this.vendaService.update(idVenda, venda);
            return ResponseEntity.ok().body("Venda atualizada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idVenda}")
    public ResponseEntity<?> desativar(@PathVariable Long idVenda, @RequestBody Venda venda) {
        try {
            this.vendaService.desativar(idVenda, venda);
            return ResponseEntity.ok().body("Venda desativada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
