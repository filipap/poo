
/**
 * classe das faturas
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */
//import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import InterfaceAtividades.AtividadesE;
import java.util.stream.Collectors;
public class Fatura implements Comparable<Fatura>{
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
    this.naturezaD = f.getNaturezaD();
  }
  
  
  /** metodos de instancia da classe Fatura */
  
  /**
  * Devolve o nif do emitente
  * @return 
  */
  public int getNifEmitente() {
    return this.nifEmitente;
  }
  
  /**
  * Devolve a designacao do emitente
  * @return 
  */
  public String getDesignacao() {
    return this.designacao;
  }

  /**
  * Devolve a data da despesa
  * @return 
  */
  public LocalDate getDataDespesa() {
    return this.dataDespesa;
  }

  /**
  * Devolve o nif do cliente
  * @return 
  */
  public int getNifCliente() {
    return this.nifCliente;
  }

  /**
  * Devolve a descricao da despesa
  * @return 
  */
  public String getDescricao() {
    return this.descricao;
  }

  /**
  * Devolve o valor da despesa
  * @return 
  */
  public int getValorDespesa() {
    return this.valorDespesa;
}

  /**
  * metodo que devolve o array das atividades economicas 
  * @return 
  */
  public List<AtividadesE> getNaturezaD(){
    return this.naturezaD.stream().filter(h->h instanceof AtividadesE)
        .map(AtividadesE::clone)
        .collect(Collectors.toList());
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
  * metodo que atualiza o array das atividades economicas 
  * @return 
  */

  public void setNaturezaD(List<AtividadesE> at){
    this.naturezaD = new ArrayList<>();
    for(AtividadesE s: at){
      this.naturezaD.add(s.clone());
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
  * metodo auxiliar que retorna o array de strings 
  * com as atividades economicas de determinada empresa
  * @return List<String> 
  */
  public List<String> setoresAtividade(){
    ArrayList<String> res = new ArrayList<>();
    for(AtividadesE a:this.naturezaD){
      res.add(a.getNaturezaDespesa());
    }
    return res;
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
                .append("\nValor da despesa: ").append(valorDespesa).append("\nNatureza da despesa: ")
                .append(setoresAtividade());
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
    
  
  /**
   * Retorna 0 se forem iguais, 1 se this > fat e -1 se o fat > this
   */
  // return this.getValorDespesa.compareTo(fat.getValorDespesa());
  public int compareTo(Fatura fat){
    return this.getDataDespesa().compareTo(fat.getDataDespesa());
  }






}
