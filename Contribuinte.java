
/**
 * classe Contribuinte 
 *
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import InterfaceAtividades.AtividadesE;
import java.io.Serializable;
public class Contribuinte implements Serializable{
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
  /** montante fiscal acumulado */
  private double mont_fiscal;
  /** lista de faturas */
  private GestaoFaturas listaFaturas;


  /**
  * Construtor por omissao para objetos da classe Contribuinte
  */
  public Contribuinte(){
    this.nif = 0;
    this.email = "n/a";
    this.nome = "n/a";
    this.morada = "n/a";
    this.password = "n/a";
    this.mont_fiscal = 0;
    this.listaFaturas = new GestaoFaturas();
  }
   
  /**
  * Construtor para objetos parametrizado da classe Contribuinte
  */  
  public Contribuinte(int nif, String email, String nome, String morada, 
    String pass,GestaoFaturas faturas){
    setNif(nif);
    setEmail(email);
    setNome(nome);
    setMorada(morada);
    setPassword(pass);
    setMont_fiscal(faturas.reducaoImposto());
    setListaFaturas(faturas);
  }
  
  /**
  * Construtor de copia para objetos da classe Contribuinte
  */
  public Contribuinte(Contribuinte c){
     this.nif = c.getNif();
     this.email = c.getEmail();
     this.nome = c.getNome();
     this.morada = c.getMorada();
     this.password = c.getPassword();
     this.mont_fiscal = c.getMont_fiscal();
     this.listaFaturas = c.getListaFaturas();
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

  //para o montante fiscal
  public double getMont_fiscal() {
    return this.mont_fiscal;
  }

  public void setMont_fiscal(double mont_fiscal) {
    this.mont_fiscal = mont_fiscal;
  }

  // para a lista de faturas de cada contribuinte
  public GestaoFaturas getListaFaturas() {
    return this.listaFaturas;
  }

  public void setListaFaturas(GestaoFaturas listaFaturas) {
    this.listaFaturas=listaFaturas;
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
  * metodo que copia o objeto
  * @return 
  */
  public Contribuinte clone() {
     return new Contribuinte(this); 
   }
  
  /**
  * metodo que retorna a representação textual do objeto
  * @return 
  */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("NIF: ").append(this.nif).append("\nEmail: ").append(this.email)
         .append("\nNome: ").append(this.nome)
         .append("\nMorada: ").append(this.morada)
         .append("\nMontante total deduzido: ").append(this.mont_fiscal  + "€");  
    return sb.toString();
  } 
  
  /**
  * Retorna o hashcode
  * @return 
  */
 
  public int hashCode() {
    int result = this.nif;
    result = 31 * result + (this.email != null ? this.email.hashCode() : 0);
    result = 31 * result + (this.nome != null ? this.nome.hashCode() : 0);
    result = 31 * result + (this.morada != null ? this.morada.hashCode() : 0);
    result = 31 * result + (this.password != null ? this.password.hashCode() : 0);
    return result;
  }

  /**
   * Metodo que atualiza a fatura antiga com o montante fiscal
   */
  public GestaoFaturas atualizaFaturasAtCorretaE (Fatura antiga, Fatura nova){
    GestaoFaturas res = new GestaoFaturas();
    for(Fatura d : this.listaFaturas.getFaturas()){
        if (d.equals(antiga)){
          res.addFatura(nova);
        }
        else res.addFatura(d);
    }
    return res;
  }

  
}
