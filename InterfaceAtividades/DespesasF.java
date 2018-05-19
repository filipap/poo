package InterfaceAtividades;
/**
 * DespesasF - classe que implementa a interface AtividadesE
*/
import java.io.Serializable;
public class DespesasF implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    //codigo da atividade
    private int cod;
    /**
    * Construtor por omissao para objetos da classe DespesasF
    */
    public DespesasF()
    {
      this.naturezaDespesa = "1 - Despesas Familiares";
      this.deducao = 0.05;
      this.cod = 1;
    }

    /**
    * Construtor de copia para objetos da classe DespesasF
    */
    public DespesasF(DespesasF s){
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
     * Método que devolve o objeto da classe DespesasF 
     * @return objeto DespesasF
    */
    public DespesasF getAtividadesE(){
      DespesasF res = new DespesasF();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }

    /** 
     * Método que atualiza o objeto da classe DespesasF 
     * @return nothing
    */
    public void setAtividadesE(DespesasF a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    


    /**
     * Cria uma cópia do objecto 
     * @return
    */

    public DespesasF clone(){
      return new DespesasF(this);
    }
 
}
