package spring.boot.desafio.nubank.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) utilizado para transferência de dados
 * relacionados a um cliente durante operações de criação ou atualização.
 *
 * <p>Esse objeto é usado para receber dados da camada de entrada (ex: requisições HTTP)
 * e repassá-los para a camada de serviço, garantindo separação entre a entidade
 * {@link spring.boot.desafio.nubank.model.Clientes} e a API exposta.</p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientesDTO {

    /**
     * Nome do cliente.
     */
    private String nome;

    /**
     * Lista de contatos associados ao cliente.
     * Representada por objetos {@link ContatosDTO}.
     */
    private List<ContatosDTO> contatos;

}
