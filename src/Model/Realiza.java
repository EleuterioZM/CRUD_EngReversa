package Model;
// Generated 16-May-2024 17:37:08 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Realiza generated by hbm2java
 */
public class Realiza  implements java.io.Serializable {


     private RealizaId id;
     private Avaliacao avaliacao;
     private Estudante estudante;
     private BigDecimal nota;

    public Realiza() {
    }

	
    public Realiza(RealizaId id, Avaliacao avaliacao, Estudante estudante) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.estudante = estudante;
    }
    public Realiza(RealizaId id, Avaliacao avaliacao, Estudante estudante, BigDecimal nota) {
       this.id = id;
       this.avaliacao = avaliacao;
       this.estudante = estudante;
       this.nota = nota;
    }
   
    public RealizaId getId() {
        return this.id;
    }
    
    public void setId(RealizaId id) {
        this.id = id;
    }
    public Avaliacao getAvaliacao() {
        return this.avaliacao;
    }
    
    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    public Estudante getEstudante() {
        return this.estudante;
    }
    
    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
    public BigDecimal getNota() {
        return this.nota;
    }
    
    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }




}


