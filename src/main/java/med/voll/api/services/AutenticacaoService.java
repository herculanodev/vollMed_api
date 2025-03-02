package med.voll.api.services;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class AutenticacaoService {

    private AuthenticationManager authenticationManager;

    public ResponseEntity<Object> login(String usuario, String senha) {
        var token = new UsernamePasswordAuthenticationToken(usuario, senha);
        Authentication auth = authenticationManager.authenticate(token);
        return new ResponseEntity<>(auth.getCredentials(), HttpStatus.OK);
    }
}
