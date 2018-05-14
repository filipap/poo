
/**
 * classe onde se gerem as faturas
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810) 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class GestaoFaturas {
  private List<Fatura> faturas;
  /**
  * Construtor para objetos da classe GestaoFaturas
  */
  public GestaoFaturas() {
    this.faturas =  new ArrayList<>();
  }

  /**
  * Construtor para objetos parametrizado da classe GestaoFaturas
  * @param faturas
  * */
  public GestaoFaturas(List<Fatura> faturas) {
    setFaturas(faturas);
  }
  
  /**
  * Construtor de copia para objetos da classe GestaoFaturas
  * @param fat Fatura
  */
  public GestaoFaturas(GestaoFaturas fat) {
    this.faturas = fat.getFaturas();
  }
  
  /**
  * Devolve as faturas da classe GestaoFaturas
  * @return 
  */
  public List<Fatura> getFaturas() {
    List<Fatura> res = new ArrayList<>();
    for(Fatura s : faturas) {
      res.add(s);
    }
    return res;
  }
  
  /**
  * Define as faturas da classe GestaoFaturas
  * @param faturas
  */
  public void setFaturas(List<Fatura> faturas) {
    this.faturas = new ArrayList<>();
    faturas.forEach(s -> {this.faturas.add(s);});
  }
  
  /**
  * Cria uma copia do objecto 
  * @return
  */
  public GestaoFaturas clone() {
    return new GestaoFaturas(this);
  }
  
  /**
  * Verifica a igualdade de dois objectos
  * @param obj
  * @return true or false
  */
  public boolean equals(Object o) {
    if(this == o) 
      return true;
    
    if((o == null) || (this.getClass() != o.getClass()))
      return false;
    
    GestaoFaturas fat = (GestaoFaturas) o;
      return(this.faturas.equals(fat.getFaturas()));
  }
  
  /**
  * Retorna uma representao textual do objecto
  * @return 
  */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Fatura c: this.faturas)
       sb.append(c.toString() + "\n ----- \n");
    return sb.toString();
  }
  /**
  * Verifica a igualdade de dois objectos
  * @param fat
  * */
  public void addFatura(Fatura fat) {
    this.faturas.add(fat);    
  }
  
  /**
  * Retorna o hashcode
  * @return result
  */
 
  public int hashCode() {
    return faturas !=null ? faturas.hashCode() : 0;
  }
  
  /**
   * 
   */
  public void ordData(){
      Comparator<Fatura> comp = (Fatura a, Fatura b) ->{
        return b.compareTo(a);
      };
      Collections.sort(this.getFaturas(), comp );
  }

  
}
