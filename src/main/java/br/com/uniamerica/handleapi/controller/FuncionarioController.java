package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.entity.Funcionario;
import br.com.uniamerica.handleapi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;
    @GetMapping("/{idFuncionario}")
    public ResponseEntity<Funcionario> findById(@PathVariable("idFuncionario") Long idFuncionario) {
        return ResponseEntity.ok().body(this.funcionarioService.findById(idFuncionario));
    }

    @GetMapping
    public ResponseEntity<Page<Funcionario>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.funcionarioService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Funcionario funcionario) {
        try {
            this.funcionarioService.insert(funcionario);
            return ResponseEntity.ok().body("Funcionário cadastrado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{idFuncionario}")
    public ResponseEntity<?> update(@PathVariable Long idFuncionario, @RequestBody Funcionario funcionario) {
        try {
            this.funcionarioService.update(idFuncionario, funcionario);
            return ResponseEntity.ok().body("Funcionário atualizado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/desativar/{idFuncionario}")
    public ResponseEntity<?> desativar(@PathVariable Long idFuncionario, @RequestBody Funcionario funcionario) {
        try {
            this.funcionarioService.desativar(idFuncionario, funcionario);
            return ResponseEntity.ok().body("Funcionário desativado com sucesso.");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
