package spring.boot.desafio.nubank.service;

import org.springframework.stereotype.Service;
import spring.boot.desafio.nubank.mapper.ClienteMapper;
import spring.boot.desafio.nubank.repository.ClientesRepository;
import spring.boot.desafio.nubank.dto.*;
import spring.boot.desafio.nubank.model.Clientes;

import java.util.List;

/**
 * Serviço responsável pela regra de negócio relacionada à entidade {@link Clientes}.
 *
 * <p>Essa classe intermedia a comunicação entre os controllers e o repositório,
 * garantindo que as operações de clientes sejam realizadas de forma consistente
 * e aplicando validações de negócio quando necessário.</p>
 */
@Service
public class ClientesService {

    private final ClientesRepository clientesRepository;
    private final ClienteMapper clienteMapper;

    public ClientesService(ClientesRepository clientesRepository, ClienteMapper clienteMapper) {
        this.clientesRepository = clientesRepository;
        this.clienteMapper = clienteMapper;
    }

    /**
     * Salva um novo cliente no banco de dados.
     *
     * @param dto objeto {@link ClientesDTO} contendo os dados do cliente
     * @return entidade {@link Clientes} persistida
     */
    public Clientes salvarCliente(ClientesDTO dto) {
        Clientes cliente = clienteMapper.toEntity(dto);
        return clientesRepository.save(cliente);
    }

    /**
     * Lista todos os clientes cadastrados no sistema.
     *
     * @return lista de {@link ClientesResponseDTO} representando os clientes
     */
    public List<ClientesResponseDTO> listarTodos() {
        return clientesRepository.findAll().stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    /**
     * Lista todos os contatos vinculados a um cliente específico.
     *
     * @param clienteId identificador único do cliente
     * @return lista de {@link ContatosResponseDTO} representando os contatos do cliente
     * @throws RuntimeException se o cliente não for encontrado
     */
    public List<ContatosResponseDTO> listarContatosPorCliente(Long clienteId) {
        Clientes cliente = clientesRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return cliente.getContatos().stream()
                .map(clienteMapper::toContatoDto)
                .toList();
    }
}
