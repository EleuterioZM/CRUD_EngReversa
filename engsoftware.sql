-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 16-Maio-2024 às 22:56
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `engsoftware`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `avaliacao`
--

CREATE TABLE `avaliacao` (
  `id` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `avaliacao`
--

INSERT INTO `avaliacao` (`id`, `descricao`, `peso`) VALUES
(1, 'adasds', 0.00),
(2, '1', 1.00),
(3, '11', 11.00),
(4, 'lolas', 1.00),
(5, 'qq', 1.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id`, `nome`) VALUES
(2, 'sssss'),
(3, 'wwwwwww'),
(4, '1'),
(5, 'dsdds'),
(6, 'informatica'),
(7, 'informatica'),
(8, '5');

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `chs` int(11) DEFAULT NULL,
  `credito` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`id`, `nome`, `chs`, `credito`) VALUES
(1, '1', 1, 1),
(2, 'q', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina_avaliacao`
--

CREATE TABLE `disciplina_avaliacao` (
  `id_disciplina` int(11) NOT NULL,
  `id_avaliacao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estudante`
--

CREATE TABLE `estudante` (
  `nr_matricula` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `apelido` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL,
  `id_turma` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `estudante`
--

INSERT INTO `estudante` (`nr_matricula`, `nome`, `apelido`, `endereco`, `contacto`, `id_turma`) VALUES
(1, '1', '1', '1', '1', NULL),
(2, '1', '1', '1', '1', 1),
(3, 'pinto', 'chichava', '123', '666', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `realiza`
--

CREATE TABLE `realiza` (
  `id_estudante` int(11) NOT NULL,
  `id_avaliacao` int(11) NOT NULL,
  `nota` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `turma`
--

CREATE TABLE `turma` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `id_curso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `turma`
--

INSERT INTO `turma` (`id`, `nome`, `id_curso`) VALUES
(1, 'w', 4),
(2, 'isd2a', 2);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `disciplina_avaliacao`
--
ALTER TABLE `disciplina_avaliacao`
  ADD PRIMARY KEY (`id_disciplina`,`id_avaliacao`),
  ADD KEY `id_avaliacao` (`id_avaliacao`);

--
-- Índices para tabela `estudante`
--
ALTER TABLE `estudante`
  ADD PRIMARY KEY (`nr_matricula`),
  ADD KEY `id_turma` (`id_turma`);

--
-- Índices para tabela `realiza`
--
ALTER TABLE `realiza`
  ADD PRIMARY KEY (`id_estudante`,`id_avaliacao`),
  ADD KEY `id_avaliacao` (`id_avaliacao`);

--
-- Índices para tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_curso` (`id_curso`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `estudante`
--
ALTER TABLE `estudante`
  MODIFY `nr_matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `disciplina_avaliacao`
--
ALTER TABLE `disciplina_avaliacao`
  ADD CONSTRAINT `disciplina_avaliacao_ibfk_1` FOREIGN KEY (`id_disciplina`) REFERENCES `disciplina` (`id`),
  ADD CONSTRAINT `disciplina_avaliacao_ibfk_2` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`id`);

--
-- Limitadores para a tabela `estudante`
--
ALTER TABLE `estudante`
  ADD CONSTRAINT `estudante_ibfk_1` FOREIGN KEY (`id_turma`) REFERENCES `turma` (`id`);

--
-- Limitadores para a tabela `realiza`
--
ALTER TABLE `realiza`
  ADD CONSTRAINT `realiza_ibfk_1` FOREIGN KEY (`id_estudante`) REFERENCES `estudante` (`nr_matricula`),
  ADD CONSTRAINT `realiza_ibfk_2` FOREIGN KEY (`id_avaliacao`) REFERENCES `avaliacao` (`id`);

--
-- Limitadores para a tabela `turma`
--
ALTER TABLE `turma`
  ADD CONSTRAINT `fk_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
