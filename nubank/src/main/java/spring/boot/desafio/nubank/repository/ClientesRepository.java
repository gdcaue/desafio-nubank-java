package spring.boot.desafio.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.desafio.nubank.model.Clientes;

/**
 * Repositório responsável pelo acesso e manipulação
 * da entidade {@link Clientes} no banco de dados.
 *
 * <p>Estende {@link JpaRepository}, herdando operações
 * básicas de CRUD, paginação e consultas.</p>
 */
public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
