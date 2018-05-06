package InterfaceAtividades;


/**
 * ReparacoesV - subclasse da classe abstrata AtividadesE
 */
public class ReparacoesV implements AtividadesE
{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;

    /**
    * Construtor por omissao para objetos da classe ReparacoesV
    */
    public ReparacoesV()
    {
      this.naturezaDespesa = "Reparação Veículos";
      this.deducao = 0.08;
    }

    /**
    * Construtor de copia para objetos da classe ReparacoesV
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

    /** 
     * metodo que devolve o objeto da classe ReparacoesV 
     * @return objeto ReparacoesV
    */
    public ReparacoesV getAtividadesE(){
      ReparacoesV res = new ReparacoesV();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * metodo que atualiza o objeto da classe ReparacoesV 
     * @return nothing
    */
    public void setAtividadesE(ReparacoesV a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    

    /**
     * Cria uma copia do objecto 
     * @return
    */
    public ReparacoesV clone() {
      return new ReparacoesV(this);
    }
    
}
