-- Criação da tabela funcionarios
CREATE TABLE funcionarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    salario DECIMAL(10, 2) NOT NULL
);

-- Inserção de 10 funcionários
INSERT INTO funcionarios (nome, cargo, salario) VALUES
('João Silva', 'Desenvolvedor', 3000.00),
('Maria Oliveira', 'Analista de Sistemas', 3500.00),
('Carlos Pereira', 'Gerente de Projetos', 5000.00),
('Ana Santos', 'Designer', 2800.00),
('Lucas Almeida', 'Product Owner', 4500.00),
('Fernanda Costa', 'QA Tester', 3200.00),
('Pedro Gomes', 'Administrador de Banco de Dados', 4000.00),
('Tatiane Lima', 'Analista de Suporte', 2900.00),
('Rafael Ribeiro', 'Desenvolvedor Frontend', 3100.00),
('Juliana Martins', 'Desenvolvedor Backend', 3600.00);