
/**
 * Contribuintes coletivos (empresas)
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import InterfaceAtividades.AtividadesE;
import java.util.stream.Collectors;

public class Empresarial extends Contribuinte {
  
/** informacao das atividades economicas nas quais atuam */
  private List<AtividadesE> infoAtividades; //fazer get e set e meter nos construtores

  /**
  * Construtor por omissao para objetos da classe Empresarial
  */
  public Empresarial() {
      super();
      this.infoAtividades = new ArrayList<>();
  }
  
  /**
  * Construtor para objetos parametrizado da classe Empresarial
  * @param nif 
  * @param email
  * @param nome
  * @param morada
  * @param password
  */
  public Empresarial(int nif, String email, String nome, String morada, String password,List<AtividadesE> infoAt) {
    super(nif,email,nome,morada,password);
    setInfoAtividades(infoAt);
  }
  
  /**
  * Construtor de copia para objetos da classe Empresarial
  * @param emp Contribuinte Empresarial
  */
  public Empresarial(Empresarial emp) {
    super(emp);
    this.infoAtividades = emp.getInfoAtividades();
  }
 
 /**
  * metodo que da o array das atividades economicas 
  * @return array das atividades economicas
  */
  public List<AtividadesE> getInfoAtividades(){
    return this.infoAtividades.stream().filter(h->h instanceof AtividadesE)
        .map(AtividadesE::clone)
        .collect(Collectors.toList());
  } 

/**
  * metodo que atualiza o array das atividades economicas 
  * @return nothing
  */

  public void setInfoAtividades(List<AtividadesE> at){
    this.infoAtividades = new ArrayList<>();
    for(AtividadesE s: at){
      this.infoAtividades.add(s.clone());
    }
  }

  /**
  * Cria uma copia do objecto 
  * @return copia do objeto
  */
  public Empresarial clone() {
    return new Empresarial(this);
  }
  
  /**
  * Verifica a igualdade de dois objectos
  * @param obj
  * @return boolean
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
  * metodo auxiliar que retorna o array de strings 
  * com as atividades economicas de determinada empresa
  * @return List<String> 
  */
  public List<String> setoresAtividade(){
    ArrayList<String> res = new ArrayList<>();
    for(AtividadesE a:this.infoAtividades){
      res.add(a.getNaturezaDespesa());
    }
    return res;
  }

  /**
  * Retorna uma representao textual do objecto
  * @return string com a representação textual
  */

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nSetores de atividade: \n").append(setoresAtividade());
    return (super.toString())+(sb.toString());
  }

  /**
  * Retorna o hashcode
  * @return result
  */
  public int hashCode() {
    return super.hashCode();
  }
}
