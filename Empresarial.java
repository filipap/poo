
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
import java.time.LocalDate;
import java.io.Serializable;
public class Empresarial extends Contribuinte implements Serializable {
  public final boolean INTERIOR = true;
  public final boolean LITORAL = false;
  /** informacao das atividades economicas nas quais atuam */
  private List<AtividadesE> infoAtividades; //fazer get e set e meter nos construtores
  /** localização da empresa */
  private boolean local;
  /**
  * Construtor por omissao para objetos da classe Empresarial
  */
  public Empresarial() {
      super();
      this.infoAtividades = new ArrayList<>();
      this.local = LITORAL;
  }
  
  /**
  * Construtor para objetos parametrizado da classe Empresarial
  * @param nif 
  * @param email
  * @param nome
  * @param morada
  * @param password
  * @param
  * @param
  */
  public Empresarial(int nif, String email, String nome, String morada, 
  String password,GestaoFaturas faturas, List<AtividadesE> infoAt, boolean loc) {
    super(nif,email,nome,morada,password,faturas);
    setInfoAtividades(infoAt);
    setLocal(loc);
  }
  
  /**
  * Construtor de copia para objetos da classe Empresarial
  * @param emp Contribuinte Empresarial
  */
  public Empresarial(Empresarial emp) {
    super(emp);
    this.infoAtividades = emp.getInfoAtividades();
    this.local = emp.getLocal();
  }
 
  /**
  * Método que devolve o array das atividades económicas 
  * @return 
  */
  public List<AtividadesE> getInfoAtividades(){
    return this.infoAtividades.stream().filter(h->h instanceof AtividadesE)
        .map(AtividadesE::clone)
        .collect(Collectors.toList());
  } 

  /**
  * Método que devolve a localização da empresa (Litoral ou Interior) 
  * @return 
  */

  public boolean getLocal(){
    return this.local;
  }

  /**
  * Método que atualiza o array das atividades económicas 
  * @return 
  */

  public void setInfoAtividades(List<AtividadesE> at){
    this.infoAtividades = new ArrayList<>();
    for(AtividadesE s: at){
      this.infoAtividades.add(s.clone());
    }
  }

  /**
  * Método que atualiza a localização da empresa 
  * @return 
  */

  public void setLocal(boolean loc){
    this.local = loc;
  }

  /**
  * Cria uma cópia do objecto 
  * @return cópia do objeto
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
  * Método auxiliar que retorna o array de strings 
  * com as atividades económicas de uma determinada empresa
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
  * Método auxiliar que retorna a localização de uma empresa
  * @return
  */
  public String localizacao(){
    StringBuilder sb = new StringBuilder();
    if(this.local == INTERIOR){
      sb.append("Empresa do Interior");
    }
    else sb.append("Empresa do Interior");
    return sb.toString();
  }

  /**
  * Retorna uma representação textual do objecto
  * @return string com a representação textual
  */

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nSetores de atividade: \n").append(setoresAtividade()).append(localizacao()).append("\n");
    return (super.toString())+(sb.toString());
  }

  /**
  * Retorna o hashcode
  * @return result
  */
  public int hashCode() {
    return super.hashCode();
  }
  
  /**
   * Retorna listagens das facturas por contribuinte num determinado intervalo de datas
   */
  public GestaoFaturas fatBetweenDates(LocalDate date1, LocalDate date2){
      GestaoFaturas res = new GestaoFaturas();
      for(int i = 0; i < this.getListaFaturas().getFaturas().size() ; i++){
          if(this.getListaFaturas().getFaturas().get(i).getDataDespesa().isAfter(date1) && 
          this.getListaFaturas().getFaturas().get(i).getDataDespesa().isBefore(date2)){
              res.addFatura(this.getListaFaturas().getFaturas().get(i));
          }
      }
      return res.clone();
  }
  
  /**
   * Retorna total faturado num determinado intervalo de tempo
   */
  
  public double totalFaturado(LocalDate date1, LocalDate date2){
      double res = 0.0;
      for(int i = 0; i < this.getListaFaturas().getFaturas().size() ; i++){
          if(this.getListaFaturas().getFaturas().get(i).getDataDespesa().isAfter(date1) && 
          this.getListaFaturas().getFaturas().get(i).getDataDespesa().isBefore(date2)){
              res = res + this.getListaFaturas().getFaturas().get(i).getValorDespesa();
          }
      }
      return res;
  }
}
