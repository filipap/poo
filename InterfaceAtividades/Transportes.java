package InterfaceAtividades;


/**
 * Transportes - classe que implementa a interface AtividadesE
 */

import java.io.Serializable;
public class Transportes implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;

    /**
    * Construtor por omissão para objetos da classe Transportes
    */
    public Transportes()
    {
      this.naturezaDespesa = "5 - Transportes";
      this.deducao = 0.18;
      this.cod = 5;
    }

    /**
    * Construtor de cópia para objetos da classe Transportes
    */
    public Transportes(Transportes s){
      this.naturezaDespesa = s.getNaturezaDespesa();
      this.deducao = s.getDeducao();
      this.cod = s.getCod();
    }
    
    /** 
     * Método que devolve a natureza da despesa para ser comparada na Fatura 
     * @return String com a natureza da despesa
    */
    public String getNaturezaDespesa(){
      return this.naturezaDespesa;
    }
    
    /** 
     * Método que devolve a dedução(em percentagem) para ser calculada em Fatura 
     * @return double com a dedução
    */
    public double getDeducao(){
      return this.deducao;
    }
    
    /** 
     * Método que devolve o código da atividade 
     * @return double com a dedução
    */
    
    public int getCod(){
      return this.cod;
    }

    /** 
     * Método que devolve o objeto da classe Transportes 
     * @return objeto Transportes
    */
    public Transportes getAtividadesE(){
      Transportes res = new Transportes();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * Método que atualiza o objeto da classe Transportes 
     * @return nothing
    */
    public void setAtividadesE(Transportes a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    

    /**
     * Cria uma cópia do objecto 
     * @return
    */
    public Transportes clone() {
      return new Transportes(this);
    }

}
