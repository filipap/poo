package InterfaceAtividades;


/**
 * Saude - classe que implementa a interface AtividadesE
 */

import java.io.Serializable;
public class Saude implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;
    /**
    * Construtor por omissão para objetos da classe Saude
    */
    public Saude()
    {
      this.naturezaDespesa = "3 - Saúde";
      this.deducao = 0.20;
      this.cod = 3;
    }

    /**
    * Construtor de copia para objetos da classe Saude
    */   
    public Saude(Saude s){
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
     * @return double com a deduçao
    */

    public int getCod(){
      return this.cod;
    }

    /** 
     * Método que devolve o objeto da classe Saude 
     * @return objeto Saude
    */
    public Saude getAtividadesE(){
      Saude res = new Saude();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * Método que atualiza o objeto da classe Saude 
     * @return nothing
    */
    public void setAtividadesE(Saude a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    

    /**
     * Cria uma cópia do objecto 
     * @return
    */
    public Saude clone() {
      return new Saude(this);
    }

}
