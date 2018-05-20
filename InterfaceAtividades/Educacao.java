package InterfaceAtividades;


/**
 * Educacao - classe que implementa a interface AtividadesE
 */
import java.io.Serializable;
public class Educacao implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;
    /**
    * Construtor por omissao para objetos da classe Educacao
    */
    public Educacao()
    {
      this.naturezaDespesa = "4 - Educação";
      this.deducao = 0.20;
      this.cod = 4;
    }

    /**
    * Construtor de copia para objetos da classe Educacao
    */
    public Educacao(Educacao s){
      this.naturezaDespesa = s.getNaturezaDespesa();
      this.deducao = s.getDeducao();
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
     * Método que devolve o objeto da classe Educacao 
     * @return objeto Educacao
    */
    public Educacao getAtividadesE(){
      Educacao res = new Educacao();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }

    /** 
     * Método que atualiza o objeto da classe Educacao 
     * @return nothing
    */
    public void setAtividadesE(Educacao a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }    


    /**
     * Cria uma cópia do objecto 
     * @return
    */
    public Educacao clone() {
      return new Educacao(this);
    }
}
