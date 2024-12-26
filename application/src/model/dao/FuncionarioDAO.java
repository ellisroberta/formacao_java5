package model.dao;

import model.entities.Funcionario;

import java.util.List;

/**
 * Interface FuncionarioDAO - Define as operações para gerenciar funcionários no banco de dados.
 */
public interface FuncionarioDAO {

    /**
     * Adiciona um novo Funcionário ao banco de dados.
     *
     * @param funcionario O objeto Funcionario a ser adicionado.
     */
    void adicionarFuncionario(Funcionario funcionario);

    /**
     * Busca um Funcionário pelo ID.
     *
     * @param id O ID do Funcionário a ser buscado.
     * @return O objeto Funcionario correspondente ao ID, ou null se não encontrado.
     */
    Funcionario buscarFuncionario(int id);

    /**
     * Lista todos os Funcionários no banco de dados.
     *
     * @return Uma lista de objetos Funcionario.
     */
    List<Funcionario> listarFuncionarios();

    /**
     * Atualiza os dados de um Funcionário existente no banco de dados.
     *
     * @param funcionario O objeto Funcionario com os dados atualizados.
     */
    void atualizarFuncionario(Funcionario funcionario);

    /**
     * Deleta um Funcionário pelo ID do banco de dados.
     *
     * @param id O ID do Funcionário a ser deletado.
     */
    void deletarFuncionario(int id);
}