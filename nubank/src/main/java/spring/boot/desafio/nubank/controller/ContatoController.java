package spring.boot.desafio.nubank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring.boot.desafio.nubank.dto.ContatosDTO;
import spring.boot.desafio.nubank.model.Contatos;
import spring.boot.desafio.nubank.service.ContatoService;

/**
 * Controller responsável por gerenciar as operações relacionadas
 * aos contatos dos clientes.
 *
 * <p>Expõe endpoints para cadastro de novos contatos vinculados
 * a clientes da aplicação.</p>
 */
@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    /**
     * Endpoint para criar um novo contato vinculado a um cliente.
     *
     * <p>Valida os dados recebidos via {@link ContatosDTO}. Em caso de sucesso,
     * retorna o contato criado com status {@code 201 CREATED}. Caso os dados
     * sejam inválidos ou ocorra erro de regra de negócio, retorna uma mensagem
     * de erro com status {@code 400 BAD_REQUEST}.</p>
     *
     * @param dto objeto {@link ContatosDTO} contendo os dados do contato
     * @return um {@link ResponseEntity} com o contato criado ou mensagem de erro
     */
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid ContatosDTO dto){
        try {
            Contatos contato = contatoService.criarContato(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(contato);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
