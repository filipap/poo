package InterfaceAtividades;


/**
 * ReparacoesV - subclasse da classe abstrata AtividadesE
 */
public class ReparacoesV extends AtividadesE
{
    /** natureza da despesa */
    private String naturezaDespesa;
    /** fator de deducao fiscal */
    private double deducao;

/**
* COnstrutor por omissao para objetos da classe ReparacoesV
*/
    public ReparacoesV()
    {
      this.naturezaDespesa = "Reparaçao Veiculos";
      this.deducao = 0.08;
    }

/**
* COnstrutor de copia para objetos da classe ReparacoesV
* @param s
*/
    public ReparacoesV(ReparacoesV s){
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
