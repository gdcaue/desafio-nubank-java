package spring.boot.desafio.nubank.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) utilizado para receber dados de entrada
 * referentes a um contato de cliente.
 *
 * <p>Esse objeto é usado principalmente em requisições de criação
 * de contatos, garantindo que as informações necessárias sejam
 * validadas antes de chegar à camada de serviço.</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatosDTO {

    /**
     * Número de telefone do contato.
     * <p>Campo obrigatório.</p>
     */
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    /**
     * Endereço de e-mail do contato.
     * <p>Campo obrigatório.</p>
     */
    @NotBlank(message = "Email é obrigatório")
    private String email;

    /**
     * Identificador do cliente ao qual o contato está vinculado.
     */
    private Long clienteId;
}
