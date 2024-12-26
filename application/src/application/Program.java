package application;

import model.dao.FuncionarioDAO;
import model.entities.Funcionario;

import java.util.List;

public class Program {

    public static void main(String[] args) {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        // Adicionar Funcionário
        Funcionario funcionario = new Funcionario(0, "Antônio Guedes", "Scrum Master", 7000.0);
        funcionarioDAO.adicionarFuncionario(funcionario);

        // Listar Funcionários
        List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + f.getCargo());
        }

        // Atualizar Funcionário
        funcionario.setNome("Antônio Guedes Atualizado");
        funcionarioDAO.atualizarFuncionario(funcionario);

        // Buscar Funcionário
        Funcionario f = funcionarioDAO.buscarFuncionario(1);
        System.out.println("Funcionário buscado: " + f.getNome());

        // Deletar Funcionário
        funcionarioDAO.deletarFuncionario(1);
    }
}