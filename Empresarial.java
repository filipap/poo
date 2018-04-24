
/**
 * Escreva a descrição da classe Empresarial aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Empresarial extends Contribuinte {
  
  /** informacao das atividades economicas nas quais atuam */
  private List<AtividadesE> infoAtividades; //fazer get e set e meter nos construtores
  /**
  * COnstrutor por omissao para objetos da classe Empresarial
  */
  public Empresarial() {
      super();
      //this.infoAtividades = new ArrayList<>();
  }
  
  /**
  * COnstrutor para objetos parametrizado da classe Empresarial
  * @param nif 
  * @param email
  * @param nome
  * @param morada
  * @param password
  */
  public Empresarial(int nif, String email, String nome, String morada, String password/*List<AtividadesE> infoAt*/) {
    super(nif,email,nome,morada,password);
  }
  
  /**
  * COnstrutor de copia para objetos da classe Empresarial
  * @param emp Contribuinte Empresarial
  */
  public Empresarial(Empresarial emp) {
    super(emp);
  }
 
  /**
  * Cria uma copia do objecto 
  * @return
  */
  public Empresarial clone() {
    return new Empresarial(this);
  }
  
  /**
  * Verifica a igualdade de dois objectos
  * @param obj
  * @return 
  */
  public boolean equals(Object o) {
    if(this == o) 
      return true;
    
    if((o == null) || (this.getClass() != o.getClass()))
      return false;
    
    Empresarial emp = (Empresarial) o;
      return(super.equals(emp));
             
   }
  
  /**
  * Retorna uma representao textual do objecto
  * @return 
  */
  public String toString() {
    return super.toString();
  }

  /**
  * Retorna o hashcode
  * @return result
  */
  public int hashCode() {
    return super.hashCode();
  }
}
