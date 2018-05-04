
/**
 * Write a description of class Contribuinte here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Contribuinte
{
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
  
  /**
  * COnstrutor por omissao para objetos da classe Empresarial
  */
  public Contribuinte(){
    this.nif = 0;
    this.email = "n/a";
    this.nome = "n/a";
    this.morada = "n/a";
    this.password = "n/a";
  }
  
  /**
  * COnstrutor para objetos parametrizado da classe Contribuinte
  * @param nif 
  * @param email
  * @param nome
  * @param morada
  * @param password
  */
  public Contribuinte(int nif, String email, String nome, String morada, String pass){
    setNif(nif);
    setEmail(email);
    setNome(nome);
    setMorada(morada);
    setPassword(pass);
  }
  
  /**
  * COnstrutor de copia para objetos da classe Contribuinte
  * @param c Contribuinte
  */
  public Contribuinte(Contribuinte c){
     this.nif = c.getNif();
     this.email = c.getEmail();
     this.nome = c.getNome();
     this.morada = c.getMorada();
     this.password = c.getPassword();
  }
    /** metodos da instancia Contribuinte */
  /**
  * Devolve o NIF do Contribuinte
  * @return 
  */
  public int getNif() {
     return this.nif;
  }
  
  /**
  * Define o nif do Contribuinte
  * @param nif 
  */
  public void setNif(int nif){
     this.nif = nif;
  }
  
  /**
  * Devolve o email do Contribuinte
  * @return 
  */
  public String getEmail() {
     return this.email;
  }
   
  /**
  * Define o email do Contribuinte
  * @param email 
  */
  public void setEmail(String email){
     this.email = email;
  }
    
  /**
  * Devolve o nome do Contribuinte
  * @return 
  */
  public String getNome() {
     return this.nome;
  }
  
  /**
  * Define o nome do Contribuinte
  * @param nome 
  */
  public void setNome(String nome){
     this.nome = nome;
  }
  
  /**
  * Devolve a morada do Contribuinte
  * @return 
  */
  public String getMorada() {
     return this.morada;
  }
  
  /**
  * Define a morada do Contribuinte
  * @param morada 
  */
  public void setMorada(String morada){
     this.morada = morada;
  }
  
  /**
  * Devolve a password do Contribuinte
  * @return 
  */
  public String getPassword() {
     return this.password;
  }
  
  /**
  * Define a password do Contribuinte
  * @param pass 
  */
  public void setPassword(String pass){
     this.password = pass;
  }
    
  /** metodos da classe contribuinte*/
  /**
  * Verifica a igualdade de dois objectos
  * @param obj
  * @return true or false
  */
  public boolean equals(Object o){
    if(this == o) 
      return true;
    
    if((o == null) || (this.getClass() != o.getClass()))
      return false;
      
    Contribuinte c = (Contribuinte) o;
    return(this.nif == c.getNif() && this.email.equals(c.getEmail()) &&
             this.nome.equals(c.getNome()) && this.morada.equals(c.getMorada()) 
             && this.password.equals(c.getPassword()));
  }
  
  /**
  * Cria uma copia do objecto 
  * @return
  */
  public Contribuinte clone() {
     return new Contribuinte(this); 
   }
  
  /**
  * Retorna uma representacao textual do objecto
  * @return 
  */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("NIF: ").append(this.nif).append("\nEmail: ").append(this.email)
         .append("\nNome: ").append(this.nome)
         .append("\nMorada: ").append(this.morada)
         .append("\nPass: ").append(this.password);   
    return sb.toString();
  } 
  
  /**
  * Retorna o hashcode
  * @return result
  */
 
  public int hashCode() {
    int result = this.nif;
    result = 31 * result + (this.email != null ? this.email.hashCode() : 0);
    result = 31 * result + (this.nome != null ? this.nome.hashCode() : 0);
    result = 31 * result + (this.morada != null ? this.morada.hashCode() : 0);
    result = 31 * result + (this.password != null ? this.password.hashCode() : 0);
    return result;
  }
  
}
