package InterfaceAtividades;


/**
 * Transportes - subclasse da classe abstrata AtividadesE
 */
public class Transportes extends AtividadesE 
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;

    public Transportes()
    {
      this.naturezaDespesa = "Transportes";
      this.deducao = 0.18;
    }

    public Transportes(Transportes s){
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