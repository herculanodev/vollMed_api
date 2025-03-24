package med.voll.api.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.api.configuration.DadosTokenJWT;
import med.voll.api.domain.entities.usuario.DadosAutenticacao;
import med.voll.api.services.AutenticacaoService;
import med.voll.api.services.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AutenticacaoController {

    private final TokenService tokenService;
    private final AutenticacaoService authenticateService;

    @PostMapping
    public ResponseEntity<Object> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        return authenticateService.login(dados.login(), dados.senha());
    }


}
