package Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Turma generated by hbm2java
 */
public class Turma implements java.io.Serializable {

    private Integer id;
    private Curso curso;
    private String nome;
    private Set estudantes = new HashSet(0);

    public Turma() {
    }

    public Turma(Curso curso, String nome) {
        this.curso = curso;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set getEstudantes() {
        return this.estudantes;
    }

    public void setEstudantes(Set estudantes) {
        this.estudantes = estudantes;
    }

}
