package InterfaceAtividades;


/**
 * Educacao - classe que implementa a interface AtividadesE
 */
public class Educacao implements AtividadesE
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;

    public Educacao()
    {
      this.naturezaDespesa = "Educação";
      this.deducao = 0.20;
    }

    public Educacao(Educacao s){
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
     * metodo que devolve o objeto da classe Educacao 
     * @return objeto Educacao
    */
    public Educacao getAtividadesE(){
      Educacao res = new Educacao();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }

    /** 
     * metodo que atualiza o objeto da classe Educacao 
     * @return nothing
    */
    public void setAtividadesE(Educacao a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    


    /**
     * Cria uma copia do objecto 
     * @return
    */
    public Educacao clone() {
      return new Educacao(this);
    }
}
