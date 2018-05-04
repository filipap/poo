
/**
 * Escreva a descrição da classe GestaoContribuintes aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class GestaoContribuintes {
  /** HashMap de Contribuintes cuja key e o nif */
  private Map<Integer, Contribuinte> contribuintes;

  /**
  * COnstrutor para objetos da classe GestaoContribuintes
  */
  public GestaoContribuintes(){
    this.contribuintes = new HashMap<>();
  }

  /**
  * COnstrutor para objetos parametrizado da classe GestaoContribuintes
  * @param cont 
  */
  public GestaoContribuintes(Map<Integer,Contribuinte> cont) {
    //this.encomendas = encs.values().stream().collect(Collectors.toMap((e) -> e.getNEnc(),(e) -> e.clone(),(e1,e2) -> e1,HashMap::new));
    this.contribuintes = cont.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone()));
  }
  
  /**
  * COnstrutor de copia para objetos da classe GestaoContribuinte
  * @param gc GestaoContribuintes
  */
  public GestaoContribuintes(GestaoContribuintes gc) {
    this.contribuintes = gc.getContribuintes();    
  }
  
  /**
  * Devolve o um Map com os Contribuintes
  * @return 
  */
  public Map<Integer,Contribuinte> getContribuintes() {
    return this.contribuintes.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone())); 
  }
  
  /**
  * Retorna uma representacao textual do objecto
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
  * @param o
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
   
  /**
  * Adiciona um objecto Contribuinte a Colecao de Contribuintes
  * @param cont
  */
  public void addContribuinte(Contribuinte cont) {
    this.contribuintes.put(cont.getNif(),cont.clone());    
  }
  
  /**
  * Cria uma copia da Colecao
  * @return
  */
  public GestaoContribuintes clone() {
    return new GestaoContribuintes(this); 
   }
  
  /**
  * Conta o numero de Contribuintes na Colecao de Contribuintes
  * @return
  */
  public int contaContribuintes() {
    return this.contribuintes.size();    
  }
  
  /**
  * Remove objetos Contribuintes da Colecao de Contribuintes dado o seu nif
  * @param nif
  */
  public void removeContribuinte(Integer nif) {
    this.contribuintes.remove(nif);    
  }
}
