
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
import java.io.Serializable;
import Excecoes.SemAtividadeException;
public class Fatura implements Serializable{
  public final boolean INTERIOR = true;
  public final boolean LITORAL = false;

  /** Número fiscal do Emitente */
  private int nifEmitente;
  /** Designação do emitente */
  private String designacao;
  /** Data da despesa*/
  private LocalDate dataDespesa;
  /** Número fiscal do cliente*/
  private int nifCliente;
  /** Descrição da despesa*/
  private String descricao;
  /** Valor da despesa*/
  private double valorDespesa;
  /** Natureza da despesa (atividade económica a que diz respeito)*/
  private List<AtividadesE> naturezaD;


  /**
  * Construtor por omissão para objetos da classe Fatura
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
  * Construtor de cópia para objetos da classe Fatura
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
  
  
  /** Métodos de instância da classe Fatura */
  
  /**
  * Devolve o nif do emitente
  * @return 
  */
  public int getNifEmitente() {
    return this.nifEmitente;
  }
  
  /**
  * Devolve a designação do emitente
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
  * Devolve a descrição da despesa
  * @return 
  */
  public String getDescricao() {
    return this.descricao;
  }

  /**
  * Devolve o valor da despesa
  * @return 
  */
  public double getValorDespesa() {
    return this.valorDespesa;
}

  /**
  * Método que devolve o array das atividades económicas 
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
  * Define a designação d emitente
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
  * Define a descrição da despesa
  * @param descricao
  */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  /**
  * Redefine o valor da despesa
  * @param valorDespesa
  */
  public void setValorDespesa(double valorDespesa) {
    this.valorDespesa = valorDespesa;
  }
  
  /**
  * Método que atualiza o array das atividades económicas 
  * @return 
  */

  public void setNaturezaD(List<AtividadesE> at){
    this.naturezaD = new ArrayList<>();
    for(AtividadesE s: at){
      this.naturezaD.add(s.clone());
    }
  }
  
  /**
  * Cria uma cópia do objecto 
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
  * Método que escolhe uma atividade conforme o código 
  * @return 
  */

  public Fatura atualizaFatura(int cod) throws SemAtividadeException{
    ArrayList<AtividadesE> res = new ArrayList<>();
    for(AtividadesE x:this.naturezaD){
      if(x.getCod()==cod){
        res.add(x.getAtividadesE());
      }
    }
    if(res.isEmpty()) throw new SemAtividadeException("A fatura não deduz para nenhuma atividade!");
    setNaturezaD(res);
    return this.clone();
  }

  /**
  * Método auxiliar que retorna o array de strings 
  * com as atividades económicas de determinada empresa
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
  * Método que retorna o valor deduzido para IRS dado uma deducao 
  * @return 
  */

  public double valorDeduzIRS(Fatura f,double deducao){
      return (f.getValorDespesa())*deducao;
  }

  /**
  * Método que retorna o valor deduzido para IRS
  * tendo em conta a localização da empresa
  * @return 
  */

  public double valorDeduzidoIRS(Fatura f,boolean local){
      return local == INTERIOR ? valorDeduzIRS(f,f.getNaturezaD().get(0).getDeducao()+0.05) : 
      valorDeduzIRS(f,f.getNaturezaD().get(0).getDeducao());
  }

  /**
  * Retorna uma representação textual do objecto
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
    result = 31 * result + (int)valorDespesa;
    result = 31 * result + (naturezaD != null ? naturezaD.hashCode() : 0);
    return result;
  }
    
}
