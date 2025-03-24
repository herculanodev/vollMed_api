package med.voll.api.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import med.voll.api.configuration.DadosTokenJWT;
import med.voll.api.domain.entities.usuario.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AutenticacaoService {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<Object> login(String usuario, String senha) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(usuario, senha);
            Authentication auth = authenticationManager.authenticate(authenticationToken);

            Usuario user = (Usuario) auth.getPrincipal();
            System.out.println("✅ Usuário autenticado: " + user.getLogin());

            var jwtToken = tokenService.generateToken(user);
            System.out.println("🟢 Token gerado: " + jwtToken);

            return ResponseEntity.ok(new DadosTokenJWT(jwtToken));
        } catch (Exception e) {
            System.err.println("❌ Erro ao autenticar usuário: " + e.getMessage());
            return ResponseEntity.status(401).body("Credenciais inválidas!");
        }
    }


}