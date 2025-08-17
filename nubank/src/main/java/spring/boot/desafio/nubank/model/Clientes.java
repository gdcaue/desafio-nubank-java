package spring.boot.desafio.nubank.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa os clientes no sistema.
 *
 * <p>Essa classe é mapeada para uma tabela no banco de dados através da JPA
 * e mantém o relacionamento de um-para-muitos com a entidade {@link Contatos}.</p>
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {

    /**
     * Identificador único do cliente.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do cliente.
     */
    private String nome;

    /**
     * Lista de contatos associados ao cliente.
     *
     * <p>Relacionamento do tipo um-para-muitos com {@link Contatos}.
     * O cascade {@code ALL} garante que operações realizadas no cliente
     * também sejam propagadas para seus contatos. O {@code orphanRemoval = true}
     * remove contatos que deixarem de estar vinculados ao cliente.</p>
     */
    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Contatos> contatos = new ArrayList<>();

}
