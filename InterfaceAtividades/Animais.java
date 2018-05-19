package InterfaceAtividades;


/**
 * Animais - classe que implementa a interface AtividadesE
 */
import java.io.Serializable;
public class Animais implements AtividadesE,Serializable{
    // variaveis de instancia
    private String naturezaDespesa ;
    private double deducao;
    private int cod;
    /**
    * Construtor por omissao para objetos da classe Animais
    */
    public Animais()
    {
      this.naturezaDespesa = "9 - Cuidados Veterinarios";
      this.deducao = 0.10;
      this.cod = 9;
    }

    /**
    * Construtor de copia para objetos da classe Animais
    */
    public Animais(Animais s){
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
     * Método que devolve o código da atividade 
     * @return double com a deduçao
    */

    public int getCod(){
      return this.cod;
    }

    /** 
     * Método que devolve o objeto da classe Animais 
     * @return objeto Animais
    */
    public Animais getAtividadesE(){
      Animais res = new Animais();
      res.naturezaDespesa = this.naturezaDespesa;
      res.deducao = this.deducao;
      return res;
    }
    
    /** 
     * Método que atualiza o objeto da classe Animais 
     * @return nothing
    */
    public void setAtividadesE(Animais a){
      this.naturezaDespesa = a.getNaturezaDespesa();
      this.deducao = a.getDeducao();
    }

    public Animais clone(){
      return new Animais(this);
    }

}
