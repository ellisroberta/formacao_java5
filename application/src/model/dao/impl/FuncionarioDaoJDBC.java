package model.dao.impl;

import db.DatabaseConnection;
import db.DbException;
import model.dao.FuncionarioDAO;
import model.entities.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe FuncionarioDaoJDBC - Implementa a interface FuncionarioDAO para realizar operações de CRUD (Create, Read, Update, Delete) no banco de dados.
 */
public class FuncionarioDaoJDBC implements FuncionarioDAO {

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";
        // Tenta estabelecer uma conexão e preparar a consulta SQL
        try (Connection conn = DatabaseConnection.getConnection(); // Obtém a conexão com o banco de dados
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Prepara a consulta e solicita as chaves geradas

            // Define os parâmetros da consulta
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.executeUpdate(); // Executa a inserção

            // Recupera o ID gerado
            ResultSet rs = stmt.getGeneratedKeys(); // Obtém as chaves geradas
            if (rs.next()) {
                funcionario.setId(rs.getInt(1)); // Define o ID do funcionário com o valor gerado pelo banco
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage()); // Lança uma exceção personalizada em caso de erro
        }
    }

    @Override
    public Funcionario buscarFuncionario(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        Funcionario funcionario = null; // Inicializa a variável
        // Tenta estabelecer uma conexão e preparar a consulta SQL
        try (Connection conn = DatabaseConnection.getConnection(); // Obtém a conexão
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a consulta
            stmt.setInt(1, id); // Define o ID como parâmetro da consulta
            ResultSet rs = stmt.executeQuery(); // Executa a consulta

            if (rs.next()) { // Se houver um resultado
                // Cria um novo objeto Funcionario com os dados retornados
                funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cargo"), rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage()); // Lança uma exceção personalizada em caso de erro
        }
        return funcionario; // Retorna o Funcionário encontrado ou null se não encontrado
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>(); // Inicializa a lista de Funcionários
        String sql = "SELECT * FROM funcionarios"; // Consulta para listar todos os funcionários
        // Tenta estabelecer uma conexão e preparar a consulta SQL
        try (Connection conn = DatabaseConnection.getConnection(); // Obtém a conexão
             Statement stmt = conn.createStatement(); // Cria um Statement
             ResultSet rs = stmt.executeQuery(sql)) { // Executa a consulta

            while (rs.next()) { // Itera sobre os resultados
                // Cria um novo objeto Funcionario para cada registro
                Funcionario funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cargo"), rs.getDouble("salario"));
                funcionarios.add(funcionario); // Adiciona à lista
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage()); // Lança uma exceção personalizada em caso de erro
        }
        return funcionarios; // Retorna a lista de Funcionários
    }

    @Override
    public void atualizarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome = ?, cargo = ?, salario = ? WHERE id = ?";
        // Tenta estabelecer uma conexão e preparar a consulta SQL
        try (Connection conn = DatabaseConnection.getConnection(); // Obtém a conexão
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a consulta

            // Define os parâmetros da consulta
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setInt(4, funcionario.getId());
            stmt.executeUpdate(); // Executa a atualização
        } catch (SQLException e) {
            throw new DbException(e.getMessage()); // Lança uma exceção personalizada em caso de erro
        }
    }

    @Override
    public void deletarFuncionario(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        // Tenta estabelecer uma conexão e preparar a consulta SQL
        try (Connection conn = DatabaseConnection.getConnection(); // Obtém a conexão
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a consulta

            stmt.setInt(1, id); // Define o ID como parâmetro da consulta
            stmt.executeUpdate(); // Executa a deleção
        } catch (SQLException e) {
            throw new DbException(e.getMessage()); // Lança uma exceção personalizada em caso de erro
        }
    }
}