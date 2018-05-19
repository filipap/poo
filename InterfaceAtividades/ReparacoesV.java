package InterfaceAtividades;


/**
 * ReparacoesV - subclasse da classe abstrata AtividadesE
 */
import java.io.Serializable;
public class ReparacoesV implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;

    /**
    * Construtor por omissão para objetos da classe ReparacoesV
    */
    public ReparacoesV()
    {
      this.naturezaDespesa = "7 - Reparação Veículos";
      this.deducao = 0.08;
      this.cod = 7;
    }

    /**
    * Construtor de cópia para objetos da classe ReparacoesV
    */
    public ReparacoesV(ReparacoesV s){
      this.naturezaDespesa = s.getNaturezaDespesa();
      this.deducao = s.getDeducao();
      this.cod = s.getCod();
    }
    
    /** 
     * Método que devolve a natureza da despesa para ser comparada na Fatura 
     * @return String com a natureza da despesa
    */
    public String getNaturezaDespesa(){
      return this.naturezaDespesa;
    }
    
    /** 
     * Método que devolve a deduçao(em percentagem) para ser calculada em Fatura 
     * @return double com a deduçao
    */
    public double getDeducao(){
      return this.deducao;
    }

    /** 
     * Método que devolve o codigo da atividade 
     * @return double com a deduçao
    */

    public int getCod(){
      return this.cod;
    }

    /** 
     * Método que devolve o objeto da classe ReparacoesV 
     * @return objeto ReparacoesV
    */
    public ReparacoesV getAtividadesE(){
      ReparacoesV res = new ReparacoesV();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * Método que atualiza o objeto da classe ReparacoesV 
     * @return nothing
    */
    public void setAtividadesE(ReparacoesV a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    

    /**
     * Cria uma copia do objecto 
     * @return
    */
    public ReparacoesV clone() {
      return new ReparacoesV(this);
    }
    
}
