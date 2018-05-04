package InterfaceAtividades;
/**
 * DespesasF - subclasse da classe abstrata AtividadesE
*/

public class DespesasF extends AtividadesE
{
    /** natureza da despesa */
    private String naturezaDespesa;
    /** fator de deducao fiscal */
    private double deducao;
  /**
  * COnstrutor por omissao para objetos da classe DespesasF
  */
    public DespesasF()
    {
      this.naturezaDespesa = "Despesas Familiares";
      this.deducao = 0.05;
    }

  /**
  * COnstrutor de copia para objetos da classe Despesas
  * @param c Contribuinte
  */
    public DespesasF(DespesasF s){
      this.naturezaDespesa = s.getNaturezaDespesa();
      this.deducao = s.getDeducao();
    }

    /** 
     * metodo que devolve a natureza da despesa para ser comparada na Fatura 
     * @return 
    */
    public String getNaturezaDespesa(){
      return this.naturezaDespesa;
    }
    
    /** 
     * metodo que devolve a deduçao(em percentagem) para ser calculada em Fatura 
     * @return 
    */
    public double getDeducao(){
      return this.deducao;
    }
 
}
