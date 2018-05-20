
/**
 * Classe onde se gerem as faturas
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810) 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Comparable;
import java.util.stream.Collectors;
import java.io.Serializable;
import Excecoes.*;
public class GestaoFaturas implements Comparator<Fatura>,Serializable {
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
   * Método compareTo para datas 
   * Retorna 0 se forem iguais, 1 se this > fat e -1 se o fat > this
  */
  
  public int compareByDate(Fatura f1 , Fatura f2){
    int r = 0;
    if (f1.getDataDespesa().isAfter(f2.getDataDespesa())) r = -1; 
    if (f1.getDataDespesa().isBefore(f2.getDataDespesa())) r = 1;
    return r;
}
  
  /**
  * Método que retorna a lista de faturas ordenada por datas
  * @return 
  */
  public void ordData(){
      Comparator<Fatura> comp = (Fatura a, Fatura b) ->{
        return compareByDate(a,b);
      };
      ArrayList<Fatura> sortedList = this.getFaturas().stream().sorted(comp).collect(Collectors.toCollection(ArrayList::new));
      setFaturas(sortedList);
  }
  
  /**
   * Método compareTo para valor despesa 
   * Retorna 0 se forem iguais, -1 se f1 > f2 e 1 se o f1 > f2
  */
  public int compare(Fatura f1 , Fatura f2){
    int r=0;
    if (f1.getValorDespesa() > f2.getValorDespesa()) r = -1; 
    if (f1.getValorDespesa() < f2.getValorDespesa()) r = 1;
    return r;
  }
  
  /**
  * Método que retorna a lista de faturas ordenada por valor de despesa
  * @return 
  */
  public void ordValor(){
      Comparator<Fatura> comp = (Fatura a, Fatura b) ->{
        return compare(a,b);
      };
      ArrayList<Fatura> sortedList = this.getFaturas().stream().sorted(comp).collect(Collectors.toCollection(ArrayList::new));
      setFaturas(sortedList);
  }
 
  /**
  * Método que retorna a lista de faturas pendentes
  * @return 
  */
  public GestaoFaturas getFaturasPendentes(){
      GestaoFaturas gf = new GestaoFaturas();
      for(Fatura f:this.faturas){
        if(f.getNaturezaD().size() > 1){
            gf.addFatura(f);
        }
      }
      return gf;
  }
  
  
  /**
  * metodo atualiza uma determinada fatura da lista com a atividade correta 
  * @return 
  */

  public GestaoFaturas atualizaFaturas(int cod,int index) throws SemAtividadeException{
      GestaoFaturas res = new GestaoFaturas();
      for(Fatura f:this.faturas){
        if(index-1>0||index-1<0){
            res.addFatura(f);
        }
        if(index-1==0){res.addFatura(f.atualizaFatura(cod));}
      }
      return res;
  }

  /**
  * metodo que devolve o somatório do valor de despesa da lista de faturas 
  * @return 
  */
  
  public double getTotalListaFaturas(){
    return this.faturas.stream().mapToDouble(w -> w.getValorDespesa()).sum();
   }
  
  /**
  * metodo que o numero de faturas emitidas 
  * @return 
  */
  
  public int getNumberFaturas(){
    return this.faturas.size();
  }
}

