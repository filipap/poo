package InterfaceAtividades;


/**
 * Saude - subclasse da classe abstrata AtividadesE
 */
public class Saude extends AtividadesE
{
   /** natureza da despesa */
    private String naturezaDespesa;
    /** fator de deducao fiscal */
    private double deducao;
    
  /**
  * COnstrutor por omissao para objetos da classe Saude
  */
    public Saude()
    {
      this.naturezaDespesa = "Saude";
      this.deducao = 0.20;
    }   
    
  /**
  * COnstrutor de copia para objetos da classe Saude
  * @param s
  */
    public Saude(Saude s){
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
