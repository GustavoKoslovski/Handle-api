package br.com.uniamerica.handleapi.controller;
import br.com.uniamerica.handleapi.entity.Categoria;
import br.com.uniamerica.handleapi.service.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable("idCategoria") Long idCategoria) {
        return ResponseEntity.ok().body(this.categoriaService.findById(idCategoria));
    }

    @GetMapping
    public ResponseEntity<Page<Categoria>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.categoriaService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Categoria categoria) {
        try {
            this.categoriaService.insert(categoria);
            return ResponseEntity.ok().body("Categoria cadastrada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<?> update(@PathVariable Long idCategoria, @RequestBody Categoria categoria) {
        try {
            this.categoriaService.update(idCategoria, categoria);
            return ResponseEntity.ok().body("Categoria atualizada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idCategoria}")
    public ResponseEntity<?> desativar(@PathVariable Long idCategoria, @RequestBody Categoria categoria) {
        try {
            this.categoriaService.desativar(idCategoria, categoria);
            return ResponseEntity.ok().body("Categoria desativada com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
