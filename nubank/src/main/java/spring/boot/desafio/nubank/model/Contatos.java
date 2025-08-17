package spring.boot.desafio.nubank.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa os contatos de um cliente no sistema.
 *
 * <p>Cada contato está vinculado a exatamente um cliente
 * através de um relacionamento {@code ManyToOne}.</p>
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contatos {

    /**
     * Identificador único do contato.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Número de telefone do contato.
     * <p>Não pode ser nulo.</p>
     */
    @Column(nullable = false)
    private String telefone;

    /**
     * Endereço de e-mail do contato.
     * <p>Não pode ser nulo.</p>
     */
    @Column(nullable = false)
    private String email;

    /**
     * Cliente ao qual este contato está vinculado.
     *
     * <p>Relacionamento do tipo muitos-para-um com {@link Clientes}.
     * O campo {@code cliente_id} é usado como chave estrangeira
     * na tabela de contatos.</p>
     *
     * <p>A anotação {@link JsonBackReference} evita recursão infinita
     * durante a serialização JSON (quando o cliente já referencia seus contatos).</p>
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference
    private Clientes clientes;

}
