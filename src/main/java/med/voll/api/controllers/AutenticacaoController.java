package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.entities.usuario.UserDetailsServiceImpl;
import med.voll.api.domain.entities.usuario.DadosAutenticacao;
import med.voll.api.services.AutenticacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private AutenticacaoService authenticateService;

    public AutenticacaoController(AutenticacaoService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        return authenticateService.login(dados.login(), dados.senha());
    }
}
