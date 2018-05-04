package InterfaceAtividades;
/**
 * DespesasF - classe que implementa a interface AtividadesE
*/

public class DespesasF implements AtividadesE
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;

    public DespesasF()
    {
      this.naturezaDespesa = "Despesas Familiares";
      this.deducao = 0.05;
    }

    public DespesasF(DespesasF s){
      this.naturezaDespesa = s.getNaturezaDespesa();
      this.deducao = s.getDeducao();
    }

    /** 
     * metodo que devolve a natureza da despesa para ser comparada na Fatura 
     * @return String com a natureza da despesa
    */
    public String getNaturezaDespesa(){
      return this.naturezaDespesa;
    }
    
    /** 
     * metodo que devolve a deduçao(em percentagem) para ser calculada em Fatura 
     * @return double com a deduçao
    */
    public double getDeducao(){
      return this.deducao;
    }

    /** 
     * metodo que devolve o objeto da classe DespesasF 
     * @return objeto DespesasF
    */
    public DespesasF getAtividadesE(){
      DespesasF res = new DespesasF();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }

    /** 
     * metodo que atualiza o objeto da classe DespesasF 
     * @return nothing
    */
    public void setAtividadesE(DespesasF a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    


    /**
     * Cria uma copia do objecto 
     * @return
    */

    public DespesasF clone(){
      return new DespesasF(this);
    }
 
}
