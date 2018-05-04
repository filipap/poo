package InterfaceAtividades;


/**
 * Animais - classe que implementa a interface AtividadesE
 */
public class Animais implements AtividadesE
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;

    public Animais()
    {
      this.naturezaDespesa = "Cuidados Veterinarios";
      this.deducao = 0.10;
    }

    public Animais(Animais s){
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
     * metodo que devolve o objeto da classe Animais 
     * @return objeto Animais
    */
    public Animais getAtividadesE(){
      Animais res = new Animais();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * metodo que atualiza o objeto da classe Animais 
     * @return nothing
    */
    public void setAtividadesE(Animais a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }

    public Animais clone(){
      return new Animais(this);
    }

}
