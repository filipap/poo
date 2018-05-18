package InterfaceAtividades;


/**
 * Restauracao - classe que implementa a interface AtividadesE
 */

import java.io.Serializable;
public class Restauracao implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;

    /**
    * Construtor por omissao para objetos da classe Restauracao
    */
    public Restauracao()
    {
      this.naturezaDespesa = "8 - Restauração";
      this.deducao = 0.15;
      this.cod = 8;
    }

    /**
    * Construtor de copia para objetos da classe Restauracao
    */
    public Restauracao(Restauracao s){
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
