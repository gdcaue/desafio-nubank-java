package spring.boot.desafio.nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) utilizado para retornar informações
 * de contatos na camada de resposta da API.
 *
 * <p>Esse objeto encapsula os dados que serão enviados ao consumidor
 * da API, garantindo que apenas as informações relevantes do contato
 * sejam expostas.</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatosResponseDTO {

    /**
     * Identificador único do contato.
     */
    private Long id;

    /**
     * Endereço de e-mail do contato.
     */
    private String email;

    /**
     * Número de telefone do contato.
     */
    private String telefone;

}
