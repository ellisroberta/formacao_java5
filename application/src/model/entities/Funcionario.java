package model.entities;

public class Funcionario {
    private int id; // Identificador do Funcionário
    private String nome; // Nome do Funcionário
    private String cargo; // Cargo do Funcionário
    private double salario; // Salário do Funcionário

    // Construtor da classe Funcionario
    public Funcionario(int id, String nome, String cargo, double salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    // Getters e Setters para acessar e modificar os atributos

    public int getId() {
        return id; // Retorna o ID do Funcionário
    }

    public void setId(int id) {
        this.id = id; // Define o ID do Funcionário
    }

    public String getNome() {
        return nome; // Retorna o nome do Funcionário
    }

    public void setNome(String nome) {
        this.nome = nome; // Define o nome do Funcionário
    }

    public String getCargo() {
        return cargo; // Retorna o cargo do Funcionário
    }

    public void setCargo(String cargo) {
        this.cargo = cargo; // Define o cargo do Funcionário
    }

    public double getSalario() {
        return salario; // Retorna o salário do Funcionário
    }

    public void setSalario(double salario) {
        this.salario = salario; // Define o salário do Funcionário
    }
}