 
/**
 * Escreva a descrição da classe Individuais aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import InterfaceAtividades.AtividadesE;
public class Individuais extends Contribuinte {
  /** numero de dependentes do agregado familiar */
  private int agregado;
  /** numeros fiscais do agregado familiar */
  private List<Integer> nif_agregado;
  /** coeficiente fiscal para efeitos de deducao */
  private float coef_fiscal;
  /** codigos das atividades economicas para deduzir despesas */
  private List<Integer> codigos;

  /**
  * COnstrutor por omissao para objetos da classe Individuais
  */
  public Individuais() {
    super();
    this.agregado = 0;
    this.nif_agregado =  new ArrayList<>();
    this.coef_fiscal = 0;
    this.codigos = new ArrayList<>();
  }
  
  /**
  * COnstrutor para objetos parametrizado da classe Individuais
  * @param nif 
  * @param email
  * @param nome
  * @param morada
  * @param password
  * @param agregado
  * @param nif_agregado
  * @param coef_fiscal
  * @param codigos
  */
  public Individuais(int nif, String email, String nome, String morada, String password, int agregado, List<Integer> nif_agregado,
                     float coef_fiscal, List<Integer> codigos) {
    super(nif,email,nome,morada,password);
    setAgregado(agregado);
    setNif_agregado(nif_agregado);
    setCoef_fiscal(coef_fiscal);
    setCodigos(codigos);
  }
  
  /**
  * COnstrutor de copia para objetos da classe Individuais
  * @param umInd Contribuinte Individual
  */
  public Individuais(Individuais umInd) {
  
    super(umInd);
    this.agregado = umInd.getAgregado();
    this.nif_agregado = umInd.getNif_agregado();
    this.coef_fiscal = umInd.getCoef_fiscal();
    this.codigos = umInd.getCodigos();
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
  * Devolve os codigos das atividades economicas do contribuinte individual
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
  * Devolve o coeficiente de deducao fiscal do contribuinte individual
  * @return 
  */
  public float getCoef_fiscal() {
    return this.coef_fiscal;
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
  * Define o coeficiente fiscal do contribuinte individual
  * @param coef_fiscal
  */
  public void setCoef_fiscal(float coef_fiscal) {
    this.coef_fiscal = coef_fiscal;
  }

  /**
  * Define os codigos de atividades economicas do contribuinte individual
  * @param codigos
  */
  public void setCodigos(List<Integer> codigos) {
    this.codigos = new ArrayList<>();
    codigos.forEach(s -> {this.codigos.add(s);});
  }
  
  /**
  * Cria uma copia do objecto 
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
          this.coef_fiscal == umInd.getCoef_fiscal()) && this.codigos.equals(umInd.getCodigos());
  }
  
  /**
  * Retorna uma representao textual do objecto
  * @return 
  */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\nAgregado Familiar: ").append(this.agregado).append("\nNIF de cada elemento do agregado familiar: ").append(this.nif_agregado)
        .append("\nCoeficiente de deducao fiscal: ").append(this.coef_fiscal).append("\nCodigos: ").append(this.codigos);
    return ((super.toString()) + sb.toString());
  }
  
  /**
  * Retorna o hashcode
  * @return result
  */
 
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + agregado;
    result = 31 * result + (nif_agregado != null ? nif_agregado.hashCode() : 0);
    result = 31 * result + (coef_fiscal != +0.0f ? Float.floatToIntBits(coef_fiscal) : 0);
    result = 31 * result + (codigos != null ? codigos.hashCode() : 0);
    return result;
  }
}
