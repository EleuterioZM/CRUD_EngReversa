/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_persistencia;


import Model.Avaliacao;
import Model.Curso;
import Model.Disciplina;
import Model.Estudante;
import Model.Turma;
import Util.HibernateUtil;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author User
 */
public class CRUD_Persistencia {

 static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
      
        
        while (true) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    menuCursos();
                    break;
                case 2:
                    menuTurmas();
                    break;
                case 3:
                    menuAvaliacoes();
                    break;
                case 4:
                    menuDisciplinas();
                    break;
                case 5:
                    menuEstudantes();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }
    
    public static void exibirMenuPrincipal() {
        System.out.println("======================================= MENU PRINCIPAL ===========================================");
        System.out.println("1. Cursos");
        System.out.println("2. Turmas");
        System.out.println("3. Avaliações");
        System.out.println("4. Disciplinas");
        System.out.println("5. Estudantes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
   public static void menuCursos() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar um novo curso");
        System.out.println("2 - Atualizar um curso existente");
        System.out.println("3 - Listar todos os cursos");
        System.out.println("4 - Apagar um curso");
        System.out.println("5 - Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                adicionarCurso();
                break;
            case 2:
                atualizarCurso();
                break;
            case 3:
                listarCursos();
                break;
            case 4:
                apagarCurso();
                break;
            case 5:
                System.out.println("Encerrando o programa.");
                return;
            default:
                System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
        }
    }
}

public static void adicionarCurso() {
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do curso:");
        String nome = scanner.nextLine();

        Curso curso = new Curso();
        curso.setNome(nome);

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(curso);

        transaction.commit();
        session.close();

        System.out.println("Curso adicionado com sucesso!");
        System.out.println("================================================================");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao adicionar o curso: " + e.getMessage());
        e.printStackTrace();
    }
}

public static void atualizarCurso() {
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do curso que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Curso curso = (Curso) session.get(Curso.class, id);
        if (curso == null) {
            System.out.println("Curso com o ID fornecido não encontrado.");
            return;
        }

        System.out.println("Digite o novo nome do curso:");
        String novoNome = scanner.nextLine();

        curso.setNome(novoNome);

        session.update(curso);

        transaction.commit();
        session.close();

        System.out.println("Curso atualizado com sucesso!");
        System.out.println("================================================================");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao atualizar o curso: " + e.getMessage());
        e.printStackTrace();
    }
}

public static void listarCursos() {
    try {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Query query = session.createQuery("FROM Curso");
        List<Curso> cursos = query.list();

        System.out.println("Lista de cursos:");
        for (Curso curso : cursos) {
            System.out.println("ID: " + curso.getId() + ", Nome: " + curso.getNome());
        }
        System.out.println("================================================================");

        session.close();
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao listar os cursos: " + e.getMessage());
        e.printStackTrace();
    }
}

public static void apagarCurso() {
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID do curso que deseja apagar:");
        int id = scanner.nextInt();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Curso curso = (Curso) session.get(Curso.class, id);
        if (curso == null) {
            System.out.println("Curso com o ID fornecido não encontrado.");
            return;
        }

        session.delete(curso);

        transaction.commit();
        session.close();

        System.out.println("Curso apagado com sucesso!");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao apagar o curso: " + e.getMessage());
        e.printStackTrace();
    }
}

    
   public static void menuTurmas() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Adicionar uma nova turma");
        System.out.println("2 - Atualizar uma turma existente");
        System.out.println("3 - Listar todas as turmas");
        System.out.println("4 - Apagar uma turma");
        System.out.println("5 - Sair");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                adicionarTurma();
                break;
            case 2:
                atualizarTurma();
                break;
            case 3:
                listarTurmas();
                break;
            case 4:
                apagarTurma();
                break;
            case 5:
                System.out.println("Encerrando o programa.");
                return;
            default:
                System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
        }
    }
}

public static void adicionarTurma() {
    try {
        Scanner scanner = new Scanner(System.in);
        
        // Listar todos os cursos disponíveis
        System.out.println("Cursos disponíveis:");
        listarCursos();
        
        System.out.println("Digite o ID do curso para associar à nova turma:");
        int idCurso = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Obter o curso selecionado pelo usuário
        Curso curso = obterCursoPorId(idCurso);
        if (curso == null) {
            System.out.println("Curso com o ID fornecido não encontrado.");
            return;
        }

        System.out.println("Digite o nome da turma:");
        String nome = scanner.nextLine();

        Turma turma = new Turma(curso, nome);

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(turma);

        transaction.commit();
        session.close();

        System.out.println("Turma adicionada com sucesso!");
        System.out.println("================================================================");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao adicionar a turma: " + e.getMessage());
        e.printStackTrace();
    }
}

public static void atualizarTurma() {
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da turma que deseja atualizar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Turma turma = (Turma) session.get(Turma.class, id);
        if (turma == null) {
            System.out.println("Turma com o ID fornecido não encontrada.");
            return;
        }

        System.out.println("Digite o novo nome da turma:");
        String novoNome = scanner.nextLine();

        turma.setNome(novoNome);

        session.update(turma);

        transaction.commit();
        session.close();

        System.out.println("Turma atualizada com sucesso!");
        System.out.println("================================================================");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao atualizar a turma: " + e.getMessage());
        e.printStackTrace();
    }
}

public static void listarTurmas() {
    try {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Query query = session.createQuery("FROM Turma");
        List<Turma> turmas = query.list();

        System.out.println("Lista de turmas:");
        for (Turma turma : turmas) {
            System.out.println("ID: " + turma.getId() + ", Nome: " + turma.getNome() + ", Curso: " + turma.getCurso().getNome());
        }
        System.out.println("================================================================");

        session.close();
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao listar as turmas: " + e.getMessage());
        e.printStackTrace();
    }
}

public static void apagarTurma() {
    try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ID da turma que deseja apagar:");
        int id = scanner.nextInt();

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Turma turma = (Turma) session.get(Turma.class, id);
        if (turma == null) {
            System.out.println("Turma com o ID fornecido não encontrada.");
            return;
        }

        session.delete(turma);

        transaction.commit();
        session.close();

        System.out.println("Turma apagada com sucesso!");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao apagar a turma: " + e.getMessage());
        e.printStackTrace();
    }
}

public static Curso obterCursoPorId(int id) {
    try {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Curso curso = (Curso) session.get(Curso.class, id);

        session.close();

        return curso;
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao obter o curso: " + e.getMessage());
        e.printStackTrace();
        return null;
    }
}
    
    public static void menuAvaliacoes() {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar uma nova avaliação");
            System.out.println("2 - Atualizar uma avaliação existente");
            System.out.println("3 - Listar todas as avaliações");
            System.out.println("4 - Apagar uma avaliação");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarAvaliacao();
                    break;
                case 2:
                    atualizarAvaliacao();
                    break;
                case 3:
                    listarAvaliacoes();
                    break;
                case 4:
                    apagarAvaliacao();
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        }
    }

    public static void adicionarAvaliacao() {
        try {
          
            System.out.println("Digite a descrição da avaliação:");
            String descricao = scanner.nextLine();
            System.out.println("Digite o peso da avaliação:");
            BigDecimal peso = scanner.nextBigDecimal();

            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setDescricao(descricao);
             
            avaliacao.setPeso(peso);

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(avaliacao);

            transaction.commit();
            session.close();

            System.out.println("Avaliação adicionada com sucesso!");
            System.out.println("================================================================");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar a avaliação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void atualizarAvaliacao() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o ID da avaliação que deseja atualizar:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Avaliacao avaliacao = (Avaliacao) session.get(Avaliacao.class, id);
            if (avaliacao == null) {
                System.out.println("Avaliação com o ID fornecido não encontrada.");
                return;
            }

            System.out.println("Digite a nova descrição da avaliação:");
            String novaDescricao = scanner.nextLine();

            
            System.out.println("Digite o novo peso da avaliação:");
            BigDecimal novoPeso = scanner.nextBigDecimal();

               avaliacao.setPeso(novoPeso);

            avaliacao.setDescricao(novaDescricao);
         
            avaliacao.setPeso(BigDecimal.ZERO);

            session.update(avaliacao);

            transaction.commit();
            session.close();

            System.out.println("Avaliação atualizada com sucesso!");
            System.out.println("================================================================");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar a avaliação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void listarAvaliacoes() {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            Query query = session.createQuery("FROM Avaliacao");
            List<Avaliacao> avaliacoes = query.list();

            System.out.println("Lista de avaliações:");
            for (Avaliacao avaliacao : avaliacoes) {
                System.out.println("ID: " + avaliacao.getId() + ", Descrição: " + avaliacao.getDescricao() +
                        ", Peso: " + avaliacao.getPeso());
            }
            System.out.println("================================================================");

            session.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar as avaliações: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void apagarAvaliacao() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o ID da avaliação que deseja apagar:");
            int id = scanner.nextInt();

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Avaliacao avaliacao = (Avaliacao) session.get(Avaliacao.class, id);
            if (avaliacao == null) {
                System.out.println("Avaliação com o ID fornecido não encontrada.");
                return;
            }

            session.delete(avaliacao);

            transaction.commit();
            session.close();

            System.out.println("Avaliação apagada com sucesso!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao apagar a avaliação: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    
    

    
 public static void menuDisciplinas() {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar uma nova disciplina");
            System.out.println("2 - Atualizar uma disciplina existente");
            System.out.println("3 - Listar todas as disciplinas");
            System.out.println("4 - Apagar uma disciplina");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarDisciplina();
                    break;
                case 2:
                    atualizarDisciplina();
                    break;
                case 3:
                    listarDisciplinas();
                    break;
                case 4:
                    apagarDisciplina();
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        }
 }

   public static void adicionarDisciplina() {
    try {
        System.out.println("Digite o nome da disciplina:");
        String nome = scanner.nextLine();
        System.out.println("Digite a carga horária semanal (CHS) da disciplina:");
        int chs = 0;
        boolean inputValido = false;
        while (!inputValido) {
            try {
                chs = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para a CHS:");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
        System.out.println("Digite o número de créditos da disciplina:");
        int credito = 0;
        inputValido = false;
        while (!inputValido) {
            try {
                credito = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para o número de créditos:");
                scanner.next(); // Limpar o buffer do scanner
            }
        }
        scanner.nextLine(); // Consumir a quebra de linha

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        disciplina.setChs(chs);
        disciplina.setCredito(credito);

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(disciplina);

        transaction.commit();
        session.close();

        System.out.println("Disciplina adicionada com sucesso!");
        System.out.println("================================================================");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao adicionar a disciplina: " + e.getMessage());
        e.printStackTrace();
    }
}


    public static void atualizarDisciplina() {
        try {
            System.out.println("Digite o ID da disciplina que deseja atualizar:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Disciplina disciplina = (Disciplina) session.get(Disciplina.class, id);
            if (disciplina == null) {
                System.out.println("Disciplina com o ID fornecido não encontrada.");
                session.close();
                return;
            }

            System.out.println("Digite o novo nome da disciplina:");
            String novoNome = scanner.nextLine();
            System.out.println("Digite a nova carga horária semanal (CHS) da disciplina:");
            int novaChs = scanner.nextInt();
            System.out.println("Digite o novo número de créditos da disciplina:");
            int novoCredito = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            disciplina.setNome(novoNome);
            disciplina.setChs(novaChs);
            disciplina.setCredito(novoCredito);

            session.update(disciplina);

            transaction.commit();
            session.close();

            System.out.println("Disciplina atualizada com sucesso!");
            System.out.println("================================================================");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar a disciplina: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void listarDisciplinas() {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            Query query = session.createQuery("FROM Disciplina");
            List<Disciplina> disciplinas = query.list();

            System.out.println("Lista de disciplinas:");
            for (Disciplina disciplina : disciplinas) {
                System.out.println("ID: " + disciplina.getId() + ", Nome: " + disciplina.getNome() +
                        ", CHS: " + disciplina.getChs() + ", Créditos: " + disciplina.getCredito());
            }
            System.out.println("================================================================");

            session.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar as disciplinas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void apagarDisciplina() {
        try {
            System.out.println("Digite o ID da disciplina que deseja apagar:");
            int id = scanner.nextInt();

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Disciplina disciplina = (Disciplina) session.get(Disciplina.class, id);
            if (disciplina == null) {
                System.out.println("Disciplina com o ID fornecido não encontrada.");
                session.close();
                return;
            }

            session.delete(disciplina);

            transaction.commit();
            session.close();

            System.out.println("Disciplina apagada com sucesso!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao apagar a disciplina: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
 public static void menuEstudantes() {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar um novo estudante");
            System.out.println("2 - Atualizar um estudante existente");
            System.out.println("3 - Listar todos os estudantes");
            System.out.println("4 - Apagar um estudante");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarEstudante();
                    break;
                case 2:
                    atualizarEstudante();
                    break;
                case 3:
                    listarEstudantes();
                    break;
                case 4:
                    apagarEstudante();
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        }
    }
 public static void adicionarEstudante() {
        try {
            System.out.println("Digite o nome do estudante:");
            String nome = scanner.nextLine();
            System.out.println("Digite o apelido do estudante:");
            String apelido = scanner.nextLine();
            System.out.println("Digite o endereço do estudante:");
            String endereco = scanner.nextLine();
            System.out.println("Digite o contacto do estudante:");
            String contacto = scanner.nextLine();

            // Listar todas as turmas disponíveis
            System.out.println("Turmas disponíveis:");
            listarTurmas();

            System.out.println("Digite o ID da turma do estudante:");
            int idTurma = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            // Obtendo a referência para a turma
            Turma turma = obterTurmaPorId(idTurma);

            // Criando o estudante
            Estudante estudante = new Estudante();
            estudante.setNome(nome);
            estudante.setApelido(apelido);
            estudante.setEndereco(endereco);
            estudante.setContacto(contacto);
            estudante.setTurma(turma); // Estabelecendo o relacionamento com a turma

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(estudante);

            transaction.commit();
            session.close();

            System.out.println("Estudante adicionado com sucesso!");
            System.out.println("================================================================");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar o estudante: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Outros métodos aqui



    public static Turma obterTurmaPorId(int id) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            Turma turma = (Turma) session.get(Turma.class, id);

            session.close();

            return turma;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao obter a turma por ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static void atualizarEstudante() {
        try {
            System.out.println("Digite o ID do estudante que deseja atualizar:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Estudante estudante = (Estudante) session.get(Estudante.class, id);
            if (estudante == null) {
                System.out.println("Estudante com o ID fornecido não encontrado.");
                session.close();
                return;
            }

            System.out.println("Digite o novo nome do estudante:");
            String novoNome = scanner.nextLine();
            System.out.println("Digite o novo apelido do estudante:");
            String novoApelido = scanner.nextLine();
            System.out.println("Digite o novo endereço do estudante:");
            String novoEndereco = scanner.nextLine();
            System.out.println("Digite o novo contacto do estudante:");
            String novoContacto = scanner.nextLine();

            estudante.setNome(novoNome);
            estudante.setApelido(novoApelido);
            estudante.setEndereco(novoEndereco);
            estudante.setContacto(novoContacto);

            session.update(estudante);

            transaction.commit();
            session.close();

            System.out.println("Estudante atualizado com sucesso!");
            System.out.println("================================================================");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar o estudante: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void listarEstudantes() {
    try {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Query query = session.createQuery("SELECT e.nrMatricula, e.nome, e.apelido, e.endereco, e.contacto, t.nome FROM Estudante e INNER JOIN e.turma t");
        List<Object[]> resultados = query.list();

        System.out.println("Lista de estudantes:");
        for (Object[] resultado : resultados) {
            Integer nrMatricula = (Integer) resultado[0];
            String nome = (String) resultado[1];
            String apelido = (String) resultado[2];
            String endereco = (String) resultado[3];
            String contacto = (String) resultado[4];
            String nomeTurma = (String) resultado[5];

            System.out.println("Matrícula: " + nrMatricula + ", Nome: " + nome +
                    ", Apelido: " + apelido + ", Endereço: " + endereco +
                    ", Contacto: " + contacto + ", Turma: " + nomeTurma);
        }
        System.out.println("================================================================");

        session.close();
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao listar os estudantes: " + e.getMessage());
        e.printStackTrace();
    }
}


    public static void apagarEstudante() {
        try {
            System.out.println("Digite o ID do estudante que deseja apagar:");
            int id = scanner.nextInt();

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Estudante estudante = (Estudante) session.get(Estudante.class, id);
            if (estudante == null) {
                System.out.println("Estudante com o ID fornecido não encontrado.");
                session.close();
                return;
            }

            session.delete(estudante);

            transaction.commit();
            session.close();

            System.out.println("Estudante apagado com sucesso!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao apagar o estudante: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    

    
   
  
    
    

