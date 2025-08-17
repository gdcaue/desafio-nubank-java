package spring.boot.desafio.nubank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal responsável por inicializar a aplicação Spring Boot.
 *
 * <p>A anotação {@link SpringBootApplication} habilita a configuração automática,
 * o escaneamento de componentes e outras funcionalidades essenciais do framework.</p>
 *
 * <p>O método {@code main} serve como ponto de entrada para a execução da aplicação.</p>
 */
@SpringBootApplication
public class NubankApplication {

    /**
     * Método principal que inicializa a aplicação Spring Boot.
     *
     * @param args argumentos de linha de comando (opcionais)
     */
    public static void main(String[] args) {
        SpringApplication.run(NubankApplication.class, args);
    }

}
