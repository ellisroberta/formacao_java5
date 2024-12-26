package db;

import java.io.Serial;

public class DbException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L; // Número de versão serial

    public DbException(String message) {
        super(message); // Chama o construtor da superclasse com a mensagem
    }
}