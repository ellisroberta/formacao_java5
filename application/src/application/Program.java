package application;

import model.dao.FuncionarioDAO;
import model.dao.impl.FuncionarioDaoJDBC;
import model.entities.Funcionario;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        // Cria uma instância do DAO (Data Access Object) para gerenciar funcionários
        FuncionarioDAO funcionarioDAO = new FuncionarioDaoJDBC();

        try {
            // Adicionar um novo Funcionário
            Funcionario funcionario = new Funcionario(0, "Antônio Guedes", "Scrum Master", 7000.0);
            funcionarioDAO.adicionarFuncionario(funcionario); // Chama o método para adicionar o funcionário

            // Listar todos os Funcionários
            List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
            for (Funcionario f : funcionarios) {
                // Imprime o nome e o cargo de cada funcionário
                System.out.println(f.getNome() + " - " + f.getCargo());
            }

            // Atualizar os dados do Funcionário
            funcionario.setNome("Antônio Guedes Atualizado");
            funcionarioDAO.atualizarFuncionario(funcionario); // Chama o método para atualizar o funcionário

            // Buscar um Funcionário específico pelo ID
            Funcionario f = funcionarioDAO.buscarFuncionario(1);
            if (f != null) {
                System.out.println("Funcionário buscado: " + f.getNome()); // Exibe o nome do funcionário buscado
            } else {
                System.out.println("Funcionário com ID 1 não encontrado.");
            }

            // Deletar um Funcionário pelo ID
            funcionarioDAO.deletarFuncionario(1); // Chama o método para deletar o funcionário

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage()); // Imprime a mensagem de erro
        }
    }
}