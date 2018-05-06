package InterfaceAtividades;


/**
 * Restauracao - classe que implementa a interface AtividadesE
 */
public class Restauracao implements AtividadesE
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;

    /**
    * Construtor por omissao para objetos da classe Restauracao
    */
    public Restauracao()
    {
      this.naturezaDespesa = "Restauração";
      this.deducao = 0.15;
    }

    /**
    * Construtor de copia para objetos da classe Restauracao
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

    /** 
     * metodo que devolve o objeto da classe Restauracao
     * @return objeto Restauracao
    */
    public Restauracao getAtividadesE(){
      Restauracao res = new Restauracao();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * metodo que atualiza o objeto da classe Restauracao 
     * @return nothing
    */
    public void setAtividadesE(Restauracao a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    

    /**
     * Cria uma copia do objecto 
     * @return
    */
    public Restauracao clone() {
      return new Restauracao(this);
    }
    
}
