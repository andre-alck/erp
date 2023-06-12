package com.me.erp.controller.participante.interno.funcionario.estagiario.estagiariodeti;

import com.me.erp.participante.interno.funcionario.estagiario.Documentacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estagiariodeti")
public class EstagiarioDeTiController {

  @PostMapping("/documentar")
  public ResponseEntity documentar(@RequestBody Documentacao documentacao) {
    return ResponseEntity.status(200).build();
  }
}
