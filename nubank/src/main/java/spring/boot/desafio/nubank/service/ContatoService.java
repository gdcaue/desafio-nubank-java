package spring.boot.desafio.nubank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.boot.desafio.nubank.dto.ContatosDTO;
import spring.boot.desafio.nubank.model.Clientes;
import spring.boot.desafio.nubank.model.Contatos;
import spring.boot.desafio.nubank.repository.ClientesRepository;
import spring.boot.desafio.nubank.repository.ContatosRepository;

/**
 * Serviço responsável pela regra de negócio relacionada à entidade {@link Contatos}.
 *
 * <p>Essa classe intermedia a comunicação entre os controllers e os repositórios,
 * garantindo que os contatos sejam corretamente associados a clientes já existentes
 * no sistema.</p>
 */
@Service
public class ContatoService {

    @Autowired
    private ContatosRepository contatosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    /**
     * Cria um novo contato vinculado a um cliente existente.
     *
     * @param dto objeto {@link ContatosDTO} contendo os dados do contato
     * @return entidade {@link Contatos} persistida no banco de dados
     * @throws IllegalArgumentException caso o cliente informado não seja encontrado
     */
    public Contatos criarContato(ContatosDTO dto) {
        Clientes cliente = clientesRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        Contatos contato = new Contatos();
        contato.setTelefone(dto.getTelefone());
        contato.setEmail(dto.getEmail());
        contato.setClientes(cliente);

        return contatosRepository.save(contato);
    }
}
