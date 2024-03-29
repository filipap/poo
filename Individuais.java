 
/**
 * Classe dos contribuintes individuais
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import InterfaceAtividades.AtividadesE;
import java.io.Serializable;
public class Individuais extends Contribuinte implements Serializable {
  public final boolean NUMEROSA = true;
  public final boolean NORMAL = false;
  
  /** Número de dependentes do agregado familiar */
  private int agregado;
  /** Números fiscais do agregado familiar */
  private List<Integer> nif_agregado;
   /** montante fiscal acumulado */
  private double mont_fiscal;
  /** Codigos das atividades economicas para deduzir despesas */
  private List<Integer> codigos;
  /** categoria da familia */
  private boolean categoria;

  /**
  * Construtor por omissão para objetos da classe Individuais
  */
  public Individuais() {
    super();
    
    this.agregado = 0;
    this.nif_agregado =  new ArrayList<>();
    this.codigos = new ArrayList<>(); 
    this.categoria = NORMAL;
  }
  
  /**
  * Construtor para objetos parametrizado da classe Individuais
  * @param nif 
  * @param email
  * @param nome
  * @param morada
  * @param password
  * @param agregado
  * @param nif_agregado
  * @param mont_fiscal
  * @param codigos
  */
  public Individuais(int nif, String email, String nome, String morada, String password,
   GestaoFaturas faturas, int agregado, List<Integer> nif_agregado,
    List<Integer> codigos,boolean cat) {
    super(nif,email,nome,morada,password,faturas);
    setAgregado(agregado);
    setNif_agregado(nif_agregado);
    setCodigos(codigos);
    setCategoria(cat);
  }
  
  /**
  * Construtor de cópia para objetos da classe Individuais
  * @param umInd Contribuinte Individual
  */
  public Individuais(Individuais umInd) {
  
    super(umInd);
    this.agregado = umInd.getAgregado();
    this.nif_agregado = umInd.getNif_agregado();
    this.mont_fiscal = umInd.getMont_fiscal();
    this.codigos = umInd.getCodigos();
    this.categoria = umInd.getCategoria();
  }
  
  /**
  * Devolve o agregado familiar do contribuinte individual
  * @return 
  */
  public int getAgregado() {
    return this.agregado;
  }
  
  /**
  * Devolve os nifs do agregado familiar do contribuinte individual
  * @return 
  */
  public List<Integer> getNif_agregado() {
    List<Integer> res = new ArrayList<>();
    for(Integer s : nif_agregado) {
      res.add(s);
    }
    return res;
  }
  
  /**
  * Devolve os códigos das atividades económicas do contribuinte individual
  * @return 
  */
  public List<Integer> getCodigos() {
    List<Integer> res = new ArrayList<>();
    for(Integer s : codigos) {
      res.add(s);
    }
    return res;
  }
  
  /**
  * Devolve o categoria de agregado familiar
  * @return 
  */
  public boolean getCategoria(){
    return this.categoria;
  }

  /**
  * Define o agregado familiar do contribuinte individual
  * @param agregado
  */
  public void setAgregado(int agregado) {
    this.agregado = agregado;
  }

  /**
  * Define o nif do agregado familiar do contribuinte individual
  * @param nif_agregado
  */
  public void setNif_agregado(List<Integer> nif_agregado) {
    this.nif_agregado = new ArrayList<>();
    nif_agregado.forEach(s -> {this.nif_agregado.add(s);});
  }

  /**
  * Define os códigos de atividades económicas do contribuinte individual
  * @param codigos
  */
  public void setCodigos(List<Integer> codigos) {
    this.codigos = new ArrayList<>();
    codigos.forEach(s -> {this.codigos.add(s);});
  }
  
  /**
  * Define o tipo de família
  * @param codigos
  */
  public void setCategoria(boolean cat){
      this.categoria = cat;
  }
  
  /**
  * Cria uma cópia do objecto 
  * @return
  */
  public Individuais clone() {
    return new Individuais(this);
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
    
    Individuais umInd = (Individuais) o;
      return(super.equals(umInd) && this.agregado == umInd.getAgregado() && this.nif_agregado.equals(umInd.getNif_agregado()) &&
          this.mont_fiscal == umInd.getMont_fiscal()) && this.codigos.equals(umInd.getCodigos());
  }

  /**
  * Método auxiliar que retorna a categoria de uma familia
  * @return
  */
  public String categ(){
    StringBuilder sb = new StringBuilder();
    if(this.categoria == NUMEROSA){
      sb.append("família NUMEROSA");
    }
    else sb.append("família NORMAL");
    return sb.toString();
  }
  
  /**
  * Retorna uma representação textual do objecto
  * @return 
  */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nAgregado Familiar: ").append(this.agregado).append("\nNIF de cada elemento do agregado familiar: ").append(this.nif_agregado)
        .append("\nCodigos: ").append(this.codigos).append("\n").append(categ());
    return ((super.toString()) + sb.append("\n").toString());
  }
  
  /**
  * Retorna o hashcode
  * @return result
  */
 
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + agregado;
    result = 31 * result + (nif_agregado != null ? nif_agregado.hashCode() : 0);
    result = 31 * result + (mont_fiscal != 0 ? Double.hashCode(mont_fiscal) : 0);
    result = 31 * result + (codigos != null ? codigos.hashCode() : 0);
    result = 31 * result + Boolean.hashCode(categoria);
    return result;
  }


  
}
