
/**
 * Escreva a descrição da classe Empresarial aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Empresarial {
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
  /** informacao das atividades economicas nas quais atuam */
  private List<String> infoAtividades; //fazer get e set e meter nos construtores
  /** informacao sobre o fator que a empresa tem no calculo de deducao fiscal */
  private List<String> infoFatoresDeducao; //fazer get e set e meter nos construtores
  /**
  * COnstrutor por omissao para objetos da classe Empresarial
  */
  public Empresarial() {
    this.nif = 0;
    this.email = "n/a";
    this.nome = "n/a";
    this.morada = "n/a";
    this.password = "n/a";
    
  }
  
  /**
  * COnstrutor para objetos parametrizado da classe Empresarial
  * @param nif 
  * @param email
  * @param nome
  * @param morada
  * @param password
  */
  public Empresarial(int nif, String email, String nome, String morada, String password) {
    this.nif = nif;
    this.email = email;
    this.nome = nome;
    this.morada = morada;
    this.password = "";
    
  }
  
  /**
  * COnstrutor de copia para objetos da classe Empresarial
  * @param emp Contribuinte Empresarial
  */
  public Empresarial(Empresarial emp) {
  
    this.nif = emp.getNif();
    this.email = emp.getEmail();
    this.nome = emp.getNome();
    this.morada = emp.getMorada();
    this.password = emp.getPassword();
    
  }
 
  /**
  * Devolve o nif do contribuinte empresarial
  * @return 
  */
  public int getNif() {
    return this.nif;
  }

  /**
  * Devolve o email do contribuinte empresarial
  * @return 
  */
  public String getEmail() {
    return this.email;
  }

  /**
  * Devolve o nome do contribuinte empresarial
  * @return 
  */
  public String getNome() {
    return this.nome;
  }

  /**
  * Devolve a morada do contribuinte empresarial
  * @return 
  */
  public String getMorada() {
    return this.morada;
  }
  
  /**
  * Devolve a password do contribuinte empresarial
  * @return 
  */
  public String getPassword() {
    return this.password;
  }
  
  /**
  * Define o nif do contribuinte empresarial
  * @param nif
  */
  public void setNif(int nif) {
    this.nif = nif;
  }
  
  /**
  * Define o email do contribuinte empresarial
  * @param email
  */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
  * Define o nome do contribuinte empresarial
  * @param nome
  */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
  * Define morada do contribuinte empresarial
  * @param morada
  */
  public void setMorada(String morada) {
    this.morada = morada;
  }
  
  /**
  * Define a password do contribuinte empresarial
  * @param password
  */
  public void setPassword(String password) {
    this.password = password;
  }
  
  /**
  * Cria uma copia do objecto 
  * @return
  */
  public Empresarial clone() {
    return new Empresarial(this);
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
    
    Empresarial emp = (Empresarial) o;
      return(this.nif == emp.getNif() && this.email.equals(emp.getEmail()) &&
             this.nome.equals(emp.getNome()) && this.morada.equals(emp.getMorada()) 
             && this.password.equals(emp.getPassword()));
             
   }
  
  /**
  * Retorna uma representao textual do objecto
  * @return 
  */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("NIF: ").append(nif).append("\nEmail: ").append(email)
                .append("\nNome: ").append(nome).append("\nMorada: ").append(morada);
                
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
    return result;
  }
}
