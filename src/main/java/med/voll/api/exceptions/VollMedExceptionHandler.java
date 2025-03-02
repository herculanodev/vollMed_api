package med.voll.api.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class VollMedExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarErros404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErrosValidacao>> tratarErros400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors()
                .stream()
                .map(DadosErrosValidacao::new)
                .toList();
        return ResponseEntity.badRequest().body(erros);
    }

    private record DadosErrosValidacao(String campo, String mensagem) {
        public DadosErrosValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
