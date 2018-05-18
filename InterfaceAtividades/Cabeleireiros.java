package InterfaceAtividades;

/**
 * Cabeleireiros - classe que implementa a interface AtividadesE
 */

import java.io.Serializable;
public class Cabeleireiros implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;

    /**
    * Construtor por omissao para objetos da classe Cabeleireiros
    */
    public Cabeleireiros()
    {
      this.naturezaDespesa = "6 - Cabeleireiros";
      this.deducao = 0.07;
      this.cod = 6;
    }

    /**
    * Construtor de copia para objetos da classe Cabeleireiros
    */
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

    /** 
     * metodo que devolve a deduçao(em percentagem) para ser calculada em Fatura 
     * @return double com a deduçao
    */
    public int getCod(){
      return this.cod;
    }

    /** 
     * metodo que devolve o objeto da classe Cabeleireiros 
     * @return objeto Cabeleireiros
    */
    public Cabeleireiros getAtividadesE(){
      Cabeleireiros res = new Cabeleireiros();
      res.naturezaDespesa = this.getNaturezaDespesa();
      res.deducao = this.getDeducao();
      res.cod = this.getCod();
      return res;
    }

    /** 
     * metodo que atualiza o objeto da classe Cabeleireiros 
     * @return nothing
    */
    public void setAtividadesE(Cabeleireiros a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
      this.cod = a.getCod();
    }    

    /**
     * Cria uma copia do objecto 
     * @return
    */
    public Cabeleireiros clone(){
      return new Cabeleireiros(this);
    }
      
}
