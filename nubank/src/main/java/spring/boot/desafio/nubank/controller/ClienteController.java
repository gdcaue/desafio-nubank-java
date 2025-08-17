package spring.boot.desafio.nubank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.desafio.nubank.dto.ClientesDTO;
import spring.boot.desafio.nubank.dto.ClientesResponseDTO;
import spring.boot.desafio.nubank.dto.ContatosResponseDTO;
import spring.boot.desafio.nubank.model.Clientes;
import spring.boot.desafio.nubank.service.ClientesService;

/**
 * Controller responsável por gerenciar as operações relacionadas
 * aos clientes da aplicação.
 *
 * <p>Expõe endpoints para criação de clientes, listagem de todos
 * os clientes e listagem dos contatos vinculados a um cliente.</p>
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientesService clientesService;

    /**
     * Endpoint para criar um novo cliente.
     *
     * @param dto objeto {@link ClientesDTO} contendo os dados do cliente a ser criado
     * @return um {@link ResponseEntity} com o cliente persistido e o status
     *         {@code 201 CREATED} em caso de sucesso
     */
    @PostMapping
    public ResponseEntity<Clientes> criar(@RequestBody ClientesDTO dto){
        Clientes clienteSalvo = clientesService.salvarCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    /**
     * Endpoint para listar todos os clientes cadastrados.
     *
     * @return um {@link ResponseEntity} com a lista de clientes no formato {@link ClientesResponseDTO}
     *         e o status {@code 200 OK}
     */
    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>> listarTodos(){
        return ResponseEntity.ok(clientesService.listarTodos());
    }

    /**
     * Endpoint para listar todos os contatos vinculados a um cliente específico.
     *
     * @param id identificador único do cliente
     * @return um {@link ResponseEntity} com a lista de contatos no formato {@link ContatosResponseDTO}
     *         e o status {@code 200 OK}
     */
    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContatosResponseDTO>> listarContatos(@PathVariable Long id){
        return ResponseEntity.ok(clientesService.listarContatosPorCliente(id));
    }

}
