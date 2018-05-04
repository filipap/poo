package InterfaceAtividades;


/**
 * Restauracao - subclasse da classe abstrata AtividadesE
 */
public class Restauracao extends AtividadesE
{
    /** natureza da despesa */
    private String naturezaDespesa;
    /** fator de deducao fiscal */
    private double deducao;

/**
* COnstrutor por omissao para objetos da classe Restauracao
*/
    public Restauracao()
    {
      this.naturezaDespesa = "Restauraçao";
      this.deducao = 0.15;
    }

/**
* COnstrutor de copia para objetos da classe Restauracao
* @param s
*/
    public Restauracao(Restauracao s){
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
