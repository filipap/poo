
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
  /**contrutor da classe Contribuinte*/
  public Contribuinte(){
    this.nif = 0;
    this.email = "n/a";
    this.nome = "n/a";
    this.morada = "n/a";
    this.password = "n/a";
  }
    
  public Contribuinte(int nif, String email, String nome, String morada, String pass){
    setNif(nif);
    setEmail(email);
    setNome(nome);
    setMorada(morada);
    setPassword(pass);
  }
  
  public Contribuinte(Contribuinte c){
     this.nif = c.getNif();
     this.email = c.getEmail();
     this.nome = c.getNome();
     this.morada = c.getMorada();
     this.password = c.getPassword();
  }
    /** metodos da instancia Contribuinte */
  //para o nif
  public int getNif() {
     return this.nif;
  }
    
  public void setNif(int nif){
     this.nif = nif;
  }
  // para o email
  public String getEmail() {
     return this.email;
  }
    
  public void setEmail(String email){
     this.email = email;
  }
    
  // para o nome
  public String getNome() {
     return this.nome;
  }
    
  public void setNome(String nome){
     this.nome = nome;
  }
  // para a morada
  public String getMorada() {
     return this.morada;
  }
    
  public void setMorada(String morada){
     this.morada = morada;
  }
  // para a password
  public String getPassword() {
     return this.password;
  }
    
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
  
  
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("NIF: ").append(this.nif).append("\nEmail: ").append(this.email)
         .append("\nNome: ").append(this.nome).append("\nMorada: ").append(this.morada);   
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
