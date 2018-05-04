package InterfaceAtividades;


/**
 * Habitacao - subclasse da classe abstrata AtividadesE
 */
public class Habitacao extends AtividadesE
{
    /** natureza da despesa */
    private String naturezaDespesa;
    /** fator de deducao fiscal */
    private double deducao;

  /**
  * COnstrutor por omissao para objetos da classe Habitacao
  */
    public Habitacao()
    {
      this.naturezaDespesa = "Habitaçao";
      this.deducao = 0.14;
    }

  /**
  * COnstrutor de copia para objetos da classe Habitacao
  * @param s
  */
    public Habitacao(Habitacao s){
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
