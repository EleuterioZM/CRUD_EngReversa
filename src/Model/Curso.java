package Model;
// Generated 16-May-2024 17:37:08 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Curso generated by hbm2java
 */
public class Curso  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Set turmas = new HashSet(0);

    public Curso() {
    }

    public Curso(String nome, Set turmas) {
       this.nome = nome;
       this.turmas = turmas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set getTurmas() {
        return this.turmas;
    }
    
    public void setTurmas(Set turmas) {
        this.turmas = turmas;
    }




}


