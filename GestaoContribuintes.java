
/**
 *classe onde se gerem os Contribuintes 
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.Serializable;
import Excecoes.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Comparable;
import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;

public class GestaoContribuintes implements Serializable{
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
    this.contribuintes = cont.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone()));
  }
  
  /**
  * Construtor de copia para objetos da classe GestaoContribuintes
  */
  public GestaoContribuintes(GestaoContribuintes gc) {
    this.contribuintes = gc.getContribuintes();    
  }
  
  /*Métodos de instância*/

  //devolve o HashMap de Contribuintes
  public Map<Integer,Contribuinte> getContribuintes() {
    return this.contribuintes.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone())); 
  }
  
  /** Métodos da classe GestaoContribuintes*/
  /**
  * Método que retorna a representação textual do objeto
  * @return 
  */
  public String toString() {
     StringBuffer sb = new StringBuffer();
     for (Contribuinte c: this.contribuintes.values())
       sb.append(c.toString() + "\n ----- \n");
     return sb.append("\n\n").toString(); 
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
   
  /**
  * Adiciona um contribuinte
  * @param 
  * 
  */
  public void addContribuinte(Contribuinte cont) throws ContJaExisteException{
    if (this.contribuintes.containsKey(cont.getNif()))
    throw
       new ContJaExisteException("O contribuinte " + cont.getNif() + " ja existe!");
    else this.contribuintes.put(cont.getNif(),cont.clone());    
  }


  /**
  * Método que copia um objeto do tipo GestaoContribuintes
  * @param 
  */
  public GestaoContribuintes clone() {
    return new GestaoContribuintes(this); 
   }
  
  /**
  * Conta o número de contribuintes
  * @return
  */
  public int contaContribuintes() {
    return this.contribuintes.size();    
  }

  /**
  * Conta o número de contribuintes coletivos
  * @return
  */
  public int contaEmpresas() {
    return (int)this.contribuintes.entrySet().stream()
    .filter(e->e.getValue().getClass().getSimpleName().equals("Empresarial")).count();    
  }

  /**
  * Conta o número de contribuintes individuais
  * @return
  */
  public int contaIndividuais() {
    return (int)this.contribuintes.entrySet().stream()
    .filter(e->e.getValue().getClass().getSimpleName().equals("Individuais")).count();    
  }

  /**
  * Conta o número de contribuintes
  * @return
  */
  public int contaFaturasPendentes() {
    return this.contribuintes.entrySet().stream()
    .filter(e->e.getValue().getClass().getSimpleName().equals("Individuais"))
    .mapToInt(e->e.getValue().getListaFaturas().getFaturasPendentes().getNumberFaturas()).sum(); 
  }


  /**
  * Dado uma key e uma password retorna o contribuinte do tipo empresarial 
  * @return
  */  

  public Empresarial getEmpresaPass(int key, String pass) throws ContNaoExisteException,
  ContNaoEmpresarialException,PassNaoCorrespondeException{
    if(this.contribuintes.containsKey(key)){
      if (this.contribuintes.get(key).getPassword().equals(pass)){
        if(this.contribuintes.get(key).getClass().getSimpleName().equals("Empresarial")){
          return (Empresarial)this.contribuintes.get(key).clone();
        }
        else throw new ContNaoEmpresarialException(String.valueOf(key));
      }
      else throw new PassNaoCorrespondeException(pass);
    }
    else throw new ContNaoExisteException(String.valueOf(key));
  }

  /**
  * Dado uma key e uma passe retorna o contribuinte do tipo individuais 
  * @return
  */  

  public Individuais getIndividualPass(int key, String pass) throws ContNaoExisteException,
  ContNaoIndividualException,PassNaoCorrespondeException{
    if(this.contribuintes.containsKey(key)){
      if (this.contribuintes.get(key).getPassword().equals(pass)){
        if(this.contribuintes.get(key).getClass().getSimpleName().equals("Individuais")){
          return (Individuais)this.contribuintes.get(key).clone();
        }
        else throw new ContNaoIndividualException(String.valueOf(key));
      }
      else throw new PassNaoCorrespondeException(pass);
    }
    else throw new ContNaoExisteException(String.valueOf(key));
  }

  /**
  * Dado uma key retorna o contribuinte do tipo individuais 
  * @return
  */
  public Individuais getIndividual(int key) throws ContNaoIndividualException,ContNaoExisteException{
    if(this.contribuintes.containsKey(key)){
      if(this.contribuintes.get(key).getClass().getSimpleName().equals("Individuais")){
        return (Individuais)this.contribuintes.get(key).clone();
      }
      else throw new ContNaoIndividualException(String.valueOf(key));
    }
    else throw new ContNaoExisteException(String.valueOf(key));
  }

  /**
  * Dado uma key retorna o contribuinte do tipo empresarial 
  * @return
  */
  public Empresarial getEmpresa(int key) throws ContNaoEmpresarialException,ContNaoExisteException{
    if(this.contribuintes.containsKey(key)){
      if(this.contribuintes.get(key).getClass().getSimpleName().equals("Empresarial")){
        return (Empresarial)this.contribuintes.get(key).clone();
      }
      else throw new ContNaoEmpresarialException(String.valueOf(key));
    }
    else throw new ContNaoExisteException(String.valueOf(key));
  }

  /**
  * Remove um contribuinte
  * @param 
  */
  public void removeContribuinte(Integer nif) throws ContNaoExisteException{
    if(!contribuintes.containsKey(nif))
     throw
       new ContNaoExisteException("O contribuinte " + nif + " nao existe.");
    else this.contribuintes.remove(nif);    
  }

  /**
   * Converte o hashmap de contribuintes num com o gasto de cada contribuinte
   */

  private Map<Contribuinte, Double> convert(Map<Integer, Contribuinte> hash){
      HashMap<Contribuinte, Double> sol = new HashMap<Contribuinte, Double>();
      for (Map.Entry<Integer, Contribuinte> entry : hash.entrySet()) {
            sol.put(entry.getValue().clone(), entry.getValue().getListaFaturas().getTotalListaFaturas());
      }
      return sol;
  }
  
  /**
   * metodo auxiliar que ordena os contribuintes por gasto
   */

  private static Map<Contribuinte, Double> sortByValue(Map<Contribuinte, Double> unsortMap) {
    List<Map.Entry<Contribuinte, Double>> list =
        new LinkedList<Map.Entry<Contribuinte, Double>>(unsortMap.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Contribuinte, Double>>() {
        public int compare(Map.Entry<Contribuinte, Double> o1,
                           Map.Entry<Contribuinte, Double> o2) {
              int r=0;
              if (o1.getValue() > o2.getValue()) r = -1; 
              if (o1.getValue() < o2.getValue()) r = 1;
              return r;
        }
    });
    Map<Contribuinte, Double> sortedMap = new LinkedHashMap<Contribuinte, Double>();
    for (Map.Entry<Contribuinte, Double> entry : list) {
      sortedMap.put(entry.getKey().clone(), entry.getValue());
    }
    return sortedMap;
  }

  /**
   * decolve a lista dos 10 contribuintes que mais gastaram   
   * private Map<Integer, Contribuinte> contribuintes;
   */
  public List<Contribuinte> devolve10MaisGastadores() {
    Map<Contribuinte, Double> valorFacturas  = new HashMap<>();
    List<Contribuinte> res = new ArrayList<Contribuinte>();
    Double somaValorFaturas = 0.0;
    int j = 0;
    for(Integer i : this.getContribuintes().keySet()){
      somaValorFaturas = this.contribuintes.get(i).getListaFaturas().getTotalListaFaturas();
      valorFacturas.put(this.contribuintes.get(i).clone(), somaValorFaturas);
    }
    Map<Contribuinte, Double> valorFacturasOrdenado  = new HashMap<>();
    valorFacturasOrdenado = sortByValue(valorFacturas);
    for(Contribuinte c : valorFacturasOrdenado.keySet()){
      if(c.getClass().getSimpleName().equals("Individuais") && j < 10){
        res.add(c.clone());
        j++;
      }
    }
    return res;
  }

  /**
   * Ordena os contribuintes pelo número de facturas
  */

  private static Map<Contribuinte, Integer> sortNFaturas(Map<Contribuinte, Integer> unsortMap) {
    List<Map.Entry<Contribuinte, Integer>> list =
          new LinkedList<Map.Entry<Contribuinte, Integer>>(unsortMap.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Contribuinte, Integer>>() {
        public int compare(Map.Entry<Contribuinte, Integer> o1,
                           Map.Entry<Contribuinte, Integer> o2) {
              int r=0;
              if (o1.getValue() > o2.getValue()) r = -1; 
              if (o1.getValue() < o2.getValue()) r = 1;
              return r;
        }
    });
    
    Map<Contribuinte, Integer> sortedMap = new LinkedHashMap<Contribuinte, Integer>();
    for (Map.Entry<Contribuinte, Integer> entry : list) {
      sortedMap.put(entry.getKey().clone(), entry.getValue());
    }
    return sortedMap;
  }


  /**
   * Método que devolve a listagem de empresas com mais facturas
  */
  public List<Contribuinte> empresasComMaisFaturas(int x){
    Map<Contribuinte, Integer> nFaturas  = new HashMap<>();
    Map<Contribuinte, Integer> nFaturasOrdenado  = new HashMap<>();
    List<Contribuinte> res = new ArrayList<Contribuinte>();
    int i = 0;
    for(Contribuinte c : this.getContribuintes().values()){
      if(c.getClass().getSimpleName().equals("Empresarial")){
        nFaturas.put(c.clone(), c.getListaFaturas().getNumberFaturas());
      }
    }
    nFaturasOrdenado = sortNFaturas(nFaturas);
    for(Contribuinte c1 : nFaturasOrdenado.keySet()){
      if(i < x){
        res.add(c1.clone());
        i++;
      }
    }
    return res;
  }


  /**
   * devolve a lista das X empresas que mais deduziram   
   * private Map<Integer, Contribuinte> contribuintes;
   */
  public List<Contribuinte> xEmpresasQueMaisDeduzem(int x) {
    Map<Contribuinte, Double> valorFacturas  = new HashMap<>();
    List<Contribuinte> res = new ArrayList<Contribuinte>();
    Double somaValorFaturas = 0.0;
    int j = 0;
    for(Integer i : this.getContribuintes().keySet()){
        somaValorFaturas = this.contribuintes.get(i).getListaFaturas().reducaoImposto();
        valorFacturas.put(this.contribuintes.get(i).clone(), somaValorFaturas);
    }
    Map<Contribuinte, Double> valorFacturasOrdenado  = new HashMap<>();
    valorFacturasOrdenado = sortByValue(valorFacturas);
    for(Contribuinte c : valorFacturasOrdenado.keySet()) {
      if(c.getClass().getSimpleName().equals("Empresarial") && j < x){
        res.add(c.clone());
        j++;
      }
    }
    return res;
  }


} 
