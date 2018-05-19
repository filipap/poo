package InterfaceAtividades;


/**
 * Habitacao - classe que implementa a interface AtividadesE
 */

import java.io.Serializable;
public class Habitacao implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;

    /**
    * Construtor por omissão para objetos da classe Habitacao
    */
    public Habitacao()
    {
      this.naturezaDespesa = "2 - Habitação";
      this.deducao = 0.14;
      this.cod = 2;
    }

    /**
    * Construtor de copia para objetos da classe Habitacao
    */
    public Habitacao(Habitacao s){
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
     * Método que devolve a deduçao(em percentagem) para ser calculada em Fatura 
     * @return double com a deduçao
    */
    public double getDeducao(){
      return this.deducao;
    }

    /** 
     * Método que devolve o codigo da atividade 
     * @return double com a deduçao
    */

    public int getCod(){
      return this.cod;
    }

    /** 
     * Método que devolve o objeto da classe Habitacao 
     * @return objeto Habitacao
    */
    public Habitacao getAtividadesE(){
      Habitacao res = new Habitacao();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }

    /** 
     * Método que atualiza o objeto da classe Habitacao 
     * @return nothing
    */
    public void setAtividadesE(Habitacao a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    


    /**
     * Cria uma cópia do objecto 
     * @return
    */
    public Habitacao clone() {
      return new Habitacao(this);
    }
    
}
