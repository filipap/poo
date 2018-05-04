package InterfaceAtividades;


/**
 * Saude - classe que implementa a interface AtividadesE
 */
public class Saude implements AtividadesE
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    
    public Saude()
    {
      this.naturezaDespesa = "Saúde";
      this.deducao = 0.20;
    }   
    public Saude(Saude s){
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
     * metodo que devolve o objeto da classe Saude 
     * @return objeto Saude
    */
    public Saude getAtividadesE(){
      Saude res = new Saude();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * metodo que atualiza o objeto da classe Saude 
     * @return nothing
    */
    public void setAtividadesE(Saude a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    

    /**
     * Cria uma copia do objecto 
     * @return
    */
    public Saude clone() {
      return new Saude(this);
    }

}
