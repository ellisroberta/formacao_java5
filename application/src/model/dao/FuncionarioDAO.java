package model.dao;

import db.DatabaseConnection;
import db.DbException;
import model.entities.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void adicionarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionarios (nome, cargo, salario) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Funcionario buscarFuncionario(int id) {
        String sql = "SELECT * FROM funcionarios WHERE id = ?";
        Funcionario funcionario = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cargo"), rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return funcionario;
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario(rs.getInt("id"), rs.getString("nome"), rs.getString("cargo"), rs.getDouble("salario"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return funcionarios;
    }

    public void atualizarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionarios SET nome = ?, cargo = ?, salario = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCargo());
            stmt.setDouble(3, funcionario.getSalario());
            stmt.setInt(4, funcionario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public void deletarFuncionario(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
