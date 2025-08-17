package spring.boot.desafio.nubank.mapper;

import org.springframework.stereotype.Component;
import spring.boot.desafio.nubank.dto.*;
import spring.boot.desafio.nubank.model.*;

/**
 * Classe responsável por realizar a conversão (mapeamento)
 * entre entidades do domínio ({@link Clientes}, {@link Contatos})
 * e seus respectivos DTOs ({@link ClientesDTO}, {@link ClientesResponseDTO},
 * {@link ContatosDTO}, {@link ContatosResponseDTO}).
 *
 * <p>Esse mapper garante a separação entre a camada de persistência
 * e a camada de exposição da API, evitando que entidades do banco
 * sejam retornadas diretamente.</p>
 */
@Component
public class ClienteMapper {

    /**
     * Converte um objeto {@link ClientesDTO} em uma entidade {@link Clientes}.
     *
     * @param dto DTO contendo os dados de um cliente
     * @return entidade {@link Clientes} pronta para ser persistida
     */
    public Clientes toEntity(ClientesDTO dto) {
        Clientes cliente = new Clientes();
        cliente.setNome(dto.getNome());

        if (dto.getContatos() != null && !dto.getContatos().isEmpty()) {
            cliente.setContatos(dto.getContatos().stream()
                .map(c -> toContatoEntity(c, cliente))
                .toList());
        }
        return cliente;
    }

    /**
     * Converte um objeto {@link ContatosResponseDTO} em uma entidade {@link Contatos}.
     *
     * @param dto DTO de resposta contendo dados de contato
     * @param cliente cliente ao qual o contato será vinculado
     * @return entidade {@link Contatos}
     */
    public Contatos toContatoEntity(ContatosResponseDTO dto, Clientes cliente) {
        Contatos contato = new Contatos();
        contato.setTelefone(dto.getTelefone());
        contato.setEmail(dto.getEmail());
        contato.setClientes(cliente);
        return contato;
    }

    /**
     * Converte um objeto {@link ContatosDTO} em uma entidade {@link Contatos}.
     *
     * @param dto DTO contendo os dados de contato
     * @param cliente cliente ao qual o contato será vinculado
     * @return entidade {@link Contatos}
     */
    public Contatos toContatoEntity(ContatosDTO dto, Clientes cliente) {
        Contatos contato = new Contatos();
        contato.setTelefone(dto.getTelefone());
        contato.setEmail(dto.getEmail());
        contato.setClientes(cliente);
        return contato;
    }

    /**
     * Converte uma entidade {@link Clientes} em um objeto {@link ClientesResponseDTO}.
     *
     * @param cliente entidade do cliente
     * @return DTO contendo os dados do cliente e seus contatos
     */
    public ClientesResponseDTO toDto(Clientes cliente) {
        ClientesResponseDTO dto = new ClientesResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        if (cliente.getContatos() != null) {
            dto.setContatos(cliente.getContatos().stream()
                .map(this::toContatoDto)
                .toList());
        }
        return dto;
    }

    /**
     * Converte uma entidade {@link Contatos} em um objeto {@link ContatosResponseDTO}.
     *
     * @param contato entidade do contato
     * @return DTO contendo os dados do contato
     */
    public ContatosResponseDTO toContatoDto(Contatos contato) {
        ContatosResponseDTO dto = new ContatosResponseDTO();
        dto.setId(contato.getId());
        dto.setTelefone(contato.getTelefone());
        dto.setEmail(contato.getEmail());
        return dto;
    }
}
