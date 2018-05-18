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
    * Construtor por omissao para objetos da classe Transportes
    */
    public Transportes()
    {
      this.naturezaDespesa = "5 - Transportes";
      this.deducao = 0.18;
      this.cod = 5;
    }

    /**
    * Construtor de copia para objetos da classe Transportes
    */
    public Transportes(Transportes s){
      this.naturezaDespesa = s.getNaturezaDespesa();
      this.deducao = s.getDeducao();
      this.cod = s.getCod();
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
     * metodo que devolve o codigo da atividade 
     * @return double com a deduçao
    */
    
    public int getCod(){
      return this.cod;
    }

    /** 
     * metodo que devolve o objeto da classe Transportes 
     * @return objeto Transportes
    */
    public Transportes getAtividadesE(){
      Transportes res = new Transportes();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * metodo que atualiza o objeto da classe Transportes 
     * @return nothing
    */
    public void setAtividadesE(Transportes a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    

    /**
     * Cria uma copia do objecto 
     * @return
    */
    public Transportes clone() {
      return new Transportes(this);
    }

}
