package InterfaceAtividades;
/**
 * DespesasF - subclasse da classe abstrata AtividadesE
*/

public class DespesasF extends AtividadesE
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
 
}
