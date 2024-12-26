package db;

import java.io.Serial;

// Classe personalizada para tratamento de exceções relacionadas ao banco de dados
public class DbException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L; // Número de versão serial

    // Construtor que recebe uma mensagem de erro
    public DbException(String message) {
        super(message); // Chama o construtor da superclasse com a mensagem
    }
}