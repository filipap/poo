
/**
 *classe onde se gerem os Contribuintes 
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class GestaoContribuintes {
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
  private Map<Integer, Contribuinte> contribuintes;

  /**
  * Construtor por omissao para objetos da classe GestaoContribuintes
  */
  public GestaoContribuintes(){
    this.contribuintes = new HashMap<>();
  }

  /**
  * Construtor para objetos parametrizado da classe GestaoContribuintes
  */
  public GestaoContribuintes(Map<Integer,Contribuinte> cont) {
    //this.encomendas = encs.values().stream().collect(Collectors.toMap((e) -> e.getNEnc(),(e) -> e.clone(),(e1,e2) -> e1,HashMap::new));
    this.contribuintes = cont.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone()));
  }
  
  /**
  * Construtor de copia para objetos da classe GestaoContribuintes
  */
  public GestaoContribuintes(GestaoContribuintes gc) {
    this.contribuintes = gc.getContribuintes();    
  }
  
  /*metodos de instancia*/

  //devolve o HashMap de Contribuintes
  public Map<Integer,Contribuinte> getContribuintes() {
    return this.contribuintes.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone())); 
  }
  
  /** metodos da classe GestaoContribuintes*/
  /**
  * metodo que retorna a representação textual do objeto
  * @return 
  */
  public String toString() {
     StringBuffer sb = new StringBuffer();
     for (Contribuinte c: this.contribuintes.values())
       sb.append(c.toString() + "\n ----- \n");
     return sb.toString(); 
  }
  

  /**
  * Verifica a igualdade de dois objectos
  * @param obj
  * @return true or false
  */
  public boolean equals(Object o) {
    if (this == o) 
      return true;
    if ((o == null) || (this.getClass() != o.getClass()))
      return false;
    GestaoContribuintes gc = (GestaoContribuintes) o;
    return this.contribuintes.equals(gc.getContribuintes());
       
   }    
   
   // public void addContribuinte(Contribuinte cont)
  public void addContribuinte(Contribuinte cont) {
    this.contribuintes.put(cont.getNif(),cont.clone());    
  }
  
  public GestaoContribuintes clone() {
    return new GestaoContribuintes(this); 
   }
  
  // conta contribuintes
  public int contaContribuintes() {
    return this.contribuintes.size();    
  }
  
  // public void removeContribuinte(Integer nif)
  public void removeContribuinte(Integer nif) {
    this.contribuintes.remove(nif);    
  }
}
