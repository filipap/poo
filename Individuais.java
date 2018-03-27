
/**
 * Escreva a descrição da classe Individuais aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Individuais {
  /** numero fiscal */
  private int nif;
  /** email de contato */
  private String email;
  /** nome do contribuinte */
  private String nome;
  /** morada do contribuinte */
  private String morada;
  /** password de acesso */
  private String password;
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
    this.nif = 0;
    this.email = "n/a";
    this.nome = "n/a";
    this.morada = "n/a";
    this.password = "n/a";
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
    this.nif = nif;
    this.email = email;
    this.nome = nome;
    this.morada = morada;
    this.password = "";
    this.agregado = agregado;
    setNif_agregado(nif_agregado);
    this.coef_fiscal = coef_fiscal;
    setCodigos(codigos);
  }
  
  /**
  * COnstrutor de copia para objetos da classe Individuais
  * @param umInd Contribuinte Individual
  */
  public Individuais(Individuais umInd) {
  
    this.nif = umInd.getNif();
    this.email = umInd.getEmail();
    this.nome = umInd.getNome();
    this.morada = umInd.getMorada();
    this.password = umInd.getPassword();
    this.agregado = umInd.getAgregado();
    this.nif_agregado = umInd.getNif_agregado();
    this.coef_fiscal = umInd.getCoef_fiscal();
    this.codigos = umInd.getCodigos();
  }
  
  /**
  * Devolve o nif do contribuinte individual
  * @return 
  */
  public int getNif() {
    return this.nif;
  }
  
  /**
  * Devolve o email do contribuinte individual
  * @return 
  */
  public String getEmail() {
    return this.email;
  }

  /**
  * Devolve o nome do contribuinte individual
  * @return 
  */
  public String getNome() {
    return this.nome;
  }
  
  /**
  * Devolve a morada do contribuinte individual
  * @return 
  */
  public String getMorada() {
    return this.morada;
  }
  
  /**
  * Devolve a password do contribuinte individual
  * @return 
  */
  public String getPassword() {
    return this.password;
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
  * Define o nif do contribuinte individual
  * @param nif
  */
  public void setNif(int nif) {
    this.nif = nif;
  }
  
  /**
  * Define o email do contribuinte individual
  * @param email
  */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
  * Define o nome do contribuinte individual
  * @param nome
  */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
  * Define a morada do contribuinte individual
  * @param morada
  */
  public void setMorada(String morada) {
    this.morada = morada;
  }
  
  /**
  * Define a password do contribuinte individual
  * @param password
  */
  public void setPassword(String password) {
    this.password = password;
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
  * @return 
  */
  public boolean equals(Object o) {
    if(this == o) 
      return true;
    
    if((o == null) || (this.getClass() != o.getClass()))
      return false;
    
    Individuais umInd = (Individuais) o;
      return(this.nif == umInd.getNif() && this.email.equals(umInd.getEmail()) &&
             this.nome.equals(umInd.getNome()) && this.morada.equals(umInd.getMorada()) 
             && this.password.equals(umInd.getPassword()) &&
             this.agregado == umInd.getAgregado() && this.nif_agregado.equals(umInd.getNif_agregado()) &&
             this.coef_fiscal == umInd.getCoef_fiscal()) && this.codigos.equals(umInd.getCodigos());
  }
  
  /**
  * Retorna uma representao textual do objecto
  * @return 
  */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("NIF: ").append(nif).append("\nEmail: ").append(email)
                .append("\nNome: ").append(nome).append("\nMorada: ").append(morada)
                .append("\nAgregado Familiar: ").append(agregado)
                .append("\nCoeficiente de deducao fiscal: ").append(coef_fiscal);
    return sb.toString();
  }
  
  /**
  * Retorna o hashcode
  * @return result
  */
  public int hashCode() {
    int result = nif;
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    result = 31 * result + (morada != null ? morada.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + agregado;
    result = 31 * result + (nif_agregado != null ? nif_agregado.hashCode() : 0);
    result = 31 * result + (coef_fiscal != +0.0f ? Float.floatToIntBits(coef_fiscal) : 0);
    result = 31 * result + (codigos != null ? codigos.hashCode() : 0);
    return result;
  }
}
