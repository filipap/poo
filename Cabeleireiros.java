
/**
 * Cabeleireiros - subclasse da classe abstrata AtividadesE
 */
public class Cabeleireiros extends AtividadesE
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;

    public Cabeleireiros()
    {
      this.naturezaDespesa = "Cabeleireiros";
      this.deducao = 0.07;
    }

    public Cabeleireiros(Cabeleireiros s){
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
