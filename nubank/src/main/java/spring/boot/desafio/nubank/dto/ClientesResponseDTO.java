package spring.boot.desafio.nubank.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) utilizado para retornar informações
 * de clientes na camada de resposta da API.
 *
 * <p>Esse objeto encapsula os dados que serão enviados ao consumidor da API,
 * garantindo que apenas as informações necessárias do cliente e seus contatos
 * sejam expostas.</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesResponseDTO {

    /**
     * Identificador único do cliente.
     */
    private Long id;

    /**
     * Nome do cliente.
     */
    private String nome;

    /**
     * Lista de contatos associados ao cliente.
     * Representada por objetos {@link ContatosResponseDTO}.
     */
    private List<ContatosResponseDTO> contatos;

}
