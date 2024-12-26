package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static String url; // URL de conexão com o banco de dados
    private static String user; // Nome de usuário para autenticação
    private static String password; // Senha para autenticação

    // Bloco estático para carregar as propriedades do banco de dados assim que a classe é carregada
    static {
        loadProperties(); // Carrega as propriedades do arquivo de configuração
    }

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password); // Retorna a conexão usando as propriedades carregadas
    }

    // Método para carregar as propriedades do banco de dados a partir de um arquivo
    private static void loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties(); // Cria um objeto Properties para armazenar as configurações
            props.load(fs); // Carrega as propriedades a partir do fluxo de entrada

            // Obtém as propriedades do arquivo
            url = props.getProperty("dburl");
            user = props.getProperty("user");
            password = props.getProperty("password");
        } catch (IOException e) {
            // Lança uma exceção em caso de falha ao carregar as propriedades
            throw new RuntimeException("Erro ao carregar as propriedades do banco de dados.", e);
        }
    }
}