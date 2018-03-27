
/**
 * Escreva a descrição da classe Fatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
import java.time.LocalDateTime;
public class Fatura {
  /** numero fiscal do Emitente */
  private int nifEmitente;
  /** designacao do emitente */
  private String designacao;
  /** data da despesa*/
  private LocalDateTime dataDespesa;
  /** numero fiscal do cliente*/
  private int nifCliente;
  /** descricao da despesa*/
  private String descricao;
  /** valor da despesa*/
  private int valorDespesa;
  /** natureza da despesa (atividade economica a que diz respeito)*/
  //....//
    

  /**
  * COnstrutor por omissao para objetos da classe Fatura
  */
  public Fatura() {
    this.nifEmitente = 0;
    this.designacao = "n/a";
    this.dataDespesa = LocalDateTime.now();
    this.nifCliente = 0;
    this.descricao = "n/a";
    this.valorDespesa = 0;
  }

  /**
  * COnstrutor para objetos parametrizado da classe Fatura
  * @param nif
  * @param nifEmitente
  * @param designacao
  * @param dataDespesa
  * @param nifCliente
  * @param descricao
  * @param valorDespesa 
  */
  public Fatura(int nifEmitente, String designacao, LocalDateTime dataDespesa, int nifCliente, 
  String descricao, int valorDespesa){
    this.nifEmitente = nifEmitente;
    this.designacao = designacao;
    this.dataDespesa = dataDespesa;
    this.nifCliente = nifCliente;
    this.descricao = descricao;
    this.valorDespesa = valorDespesa;
  }
  
  /**
  * COnstrutor de copia para objetos da classe Fatura
  * @param f Fatura
  */
  public Fatura(Fatura f) {
    this.nifEmitente = getNifEmitente();
    this.designacao = getDesignacao();
    this.dataDespesa = getDataDespesa();
    this.nifCliente = getNifCliente();
    this.descricao = getDescricao();
    this.valorDespesa = getValorDespesa();
  }
  
  /**
  * Devolve o nif do emitente
  * @return 
  */
  public int getNifEmitente() {
    return nifEmitente;
  }
  
  /**
  * Devolve a designacao do emitente
  * @return 
  */
  public String getDesignacao() {
    return designacao;
  }

  /**
  * Devolve a data da despesa
  * @return 
  */
  public LocalDateTime getDataDespesa() {
    return dataDespesa;
  }

  /**
  * Devolve o nif do cliente
  * @return 
  */
  public int getNifCliente() {
    return nifCliente;
  }

  /**
  * Devolve a descricao da despesa
  * @return 
  */
  public String getDescricao() {
    return descricao;
  }

  /**
  * Devolve o valor da despesa
  * @return 
  */
  public int getValorDespesa() {
    return valorDespesa;
  }
  
  /**
  * Define o nif do emitente
  * @param nifEmitente
  */
  public void setNifEmitente(int nifEmitente) {
    this.nifEmitente = nifEmitente;
  }

  /**
  * Define a designacao d emitente
  * @param designacao
  */
  public void setDesignacao(String designacao) {
    this.designacao = designacao;
  }

  /**
  * Define a data da despesa
  * @param dataDespesa
  */
  public void setDataDespesa(LocalDateTime dataDespesa) {
    this.dataDespesa = dataDespesa;
  }

  /**
  * Define o nif do cliente
  * @param nifCliente
  */
  public void setNifCliente(int nifCliente) {
    this.nifCliente = nifCliente;
  }
  
  /**
  * Define a descricao da despesa
  * @param descricao
  */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  /**
  * Define o valor da despesa
  * @param valorDespesa
  */
  public void setValorDespesa(int valorDespesa) {
    this.valorDespesa = valorDespesa;
  }

  /**
  * Cria uma copia do objecto 
  * @return
  */
  public Fatura clone() {
    return new Fatura(this);
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
    
    Fatura f = (Fatura) o;
      return(this.nifEmitente == f.getNifEmitente() && this.designacao.equals(f.getDesignacao()) &&
             this.dataDespesa.equals(f.getDataDespesa()) && this.nifCliente == f.getNifCliente() 
             && this.descricao.equals(f.getDescricao()) &&
             this.valorDespesa == f.getValorDespesa());
  }
  
  /**
  * Retorna uma representaÃ§Ã£o textual do objecto
  * @return 
  */
  public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("NIF do emitente: ").append(nifEmitente).append("\nDesignacao do emitente: ").append(designacao)
                .append("\nData da despesa: ").append(dataDespesa).append("\nNIF do Cliente: ").append(nifCliente)
                .append("\nDescricao da despesa: ").append(descricao)
                .append("\nValor da despesa: ").append(valorDespesa);
  return sb.toString();
  }
  
  /**
  * Retorna o hashcode
  * @return result
  */
  public int hashCode() {
    int result = nifEmitente;
    result = 31 * result + (designacao != null ? designacao.hashCode() : 0);
    result = 31 * result + (dataDespesa != null ? dataDespesa.hashCode() : 0);
    result = 31 * result + nifCliente;
    result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
    result = 31 * result + valorDespesa;
    return result;
  }

    






}
