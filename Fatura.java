
/**
 * Escreva a descrição da classe Fatura aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
//import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import InterfaceAtividades.AtividadesE;
public class Fatura {
  /** numero fiscal do Emitente */
  private int nifEmitente;
  /** designacao do emitente */
  private String designacao;
  /** data da despesa*/
  private LocalDate dataDespesa;
  /** numero fiscal do cliente*/
  private int nifCliente;
  /** descricao da despesa*/
  private String descricao;
  /** valor da despesa*/
  private int valorDespesa;
  /** natureza da despesa (atividade economica a que diz respeito)*/
  private List<AtividadesE> naturezaD;
    

  /**
  * Construtor por omissao para objetos da classe Fatura
  */
  public Fatura() {
    this.nifEmitente = 0;
    this.designacao = "n/a";
    this.dataDespesa = LocalDate.now();
    this.nifCliente = 0;
    this.descricao = "n/a";
    this.valorDespesa = 0;
    this.naturezaD = new ArrayList<>();
  }

  /**
  * Construtor para objetos parametrizado da classe Fatura
  * @param nif
  * @param nifEmitente
  * @param designacao
  * @param dataDespesa
  * @param nifCliente
  * @param descricao
  * @param valorDespesa 
  * @param naturezaD
  */
  public Fatura(int nifEmitente, String designacao, LocalDate dataDespesa, int nifCliente, 
  String descricao, int valorDespesa, List<AtividadesE> naturezaD){
    setNifEmitente(nifEmitente);
    setDesignacao(designacao);
    setDataDespesa(dataDespesa);
    setNifCliente(nifCliente);
    setDescricao(descricao);
    setValorDespesa(valorDespesa);
    setNaturezaD(naturezaD);
  }
  
  /**
  * Construtor de copia para objetos da classe Fatura
  * @param f Fatura
  */
  public Fatura(Fatura f) {
    this.nifEmitente = f.getNifEmitente();
    this.designacao = f.getDesignacao();
    this.dataDespesa = f.getDataDespesa();
    this.nifCliente = f.getNifCliente();
    this.descricao = f.getDescricao();
    this.valorDespesa = f.getValorDespesa();
  }
  
  
  /** metodos de instancia da classe Fatura */
  
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
  public LocalDate getDataDespesa() {
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
  public void setDataDespesa(LocalDate dataDespesa) {
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
  * Redefine o valor da despesa
  * @param valorDespesa
  */
  public void setValorDespesa(int valorDespesa) {
    this.valorDespesa = valorDespesa;
  }
  
  /**
  * Devolve a string que indica natureza da despesa
  * @param valorDespesa
  */
  public List<AtividadesE> getNaturezaD() {
    ArrayList res = new ArrayList<>();
    for(AtividadesE x: this.naturezaD){
      res.add(x);
    }
    return res;
  }
  
  /**
  * Redefine o valor da natureza da despesa
  * @param natureza da despesa
  */
  public void setNaturezaD(List<AtividadesE> naturezaD) {
    this.naturezaD = new ArrayList<>();
    for(AtividadesE x: naturezaD){
      this.naturezaD.add(x);
    }
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
  * Retorna uma representaçao textual do objecto
  * @return String com o texto
  */
  public String toString() {
    String texto = dataDespesa.format(DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate d = LocalDate.parse(texto,DateTimeFormatter.ISO_LOCAL_DATE);
    StringBuilder sb = new StringBuilder();
    sb.append("NIF do emitente: ").append(nifEmitente).append("\nDesignacao do emitente: ").append(designacao)
                .append("\nData da despesa: ").append(d).append("\nNIF do Cliente: ").append(nifCliente)
                .append("\nDescricao da despesa: ").append(descricao)
                .append("\nValor da despesa: ").append(valorDespesa).append("\nNatureza da despesa: "); 
                // ainda falta fazer o toString das atividades;
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
    result = 31 * result + (naturezaD != null ? naturezaD.hashCode() : 0);
    return result;
  }
  
  /** metodos da classe Fatura */
  /* // metodo que calcula o valor qu vai ser deduzido para IRS
  public double valorDeduzidoIRS(){
      double coef_deducao = c.getDeducaoDespesa(); 
      
  }*/
    






}
