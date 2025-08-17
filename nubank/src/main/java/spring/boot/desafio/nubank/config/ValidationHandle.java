package spring.boot.desafio.nubank.config;

import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe responsável por tratar exceções globais relacionadas à validação
 * de argumentos nos controllers da aplicação.
 *
 * <p>Quando um método de um controller recebe parâmetros inválidos (violando
 * anotações de validação como {@code @NotNull}, {@code @Size}, etc.),
 * essa classe intercepta a exceção e retorna uma resposta padronizada
 * com os erros encontrados.</p>
 */
@RestControllerAdvice
public class ValidationHandle {

    /**
     * Trata exceções do tipo {@link MethodArgumentNotValidException}, que ocorrem
     * quando parâmetros de requisições não atendem às regras de validação.
     *
     * @param ex exceção lançada automaticamente pelo Spring ao detectar falha de validação
     * @return um {@link ResponseEntity} contendo um mapa com os campos inválidos e suas mensagens de erro,
     * retornando o status {@code 400 BAD_REQUEST}.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

}
