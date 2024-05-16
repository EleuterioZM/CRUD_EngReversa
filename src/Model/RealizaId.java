package Model;
// Generated 16-May-2024 17:37:08 by Hibernate Tools 4.3.1



/**
 * RealizaId generated by hbm2java
 */
public class RealizaId  implements java.io.Serializable {


     private int idEstudante;
     private int idAvaliacao;

    public RealizaId() {
    }

    public RealizaId(int idEstudante, int idAvaliacao) {
       this.idEstudante = idEstudante;
       this.idAvaliacao = idAvaliacao;
    }
   
    public int getIdEstudante() {
        return this.idEstudante;
    }
    
    public void setIdEstudante(int idEstudante) {
        this.idEstudante = idEstudante;
    }
    public int getIdAvaliacao() {
        return this.idAvaliacao;
    }
    
    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RealizaId) ) return false;
		 RealizaId castOther = ( RealizaId ) other; 
         
		 return (this.getIdEstudante()==castOther.getIdEstudante())
 && (this.getIdAvaliacao()==castOther.getIdAvaliacao());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdEstudante();
         result = 37 * result + this.getIdAvaliacao();
         return result;
   }   


}


