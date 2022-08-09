package br.com.uniamerica.handleapi.controller;

import br.com.uniamerica.handleapi.service.MovimentoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
@RequestMapping("/api/movimento_stoque")
public class MovimentoEstoqueController {

    @Autowired
    MovimentoEstoqueService movimentoEstoqueService;
}
