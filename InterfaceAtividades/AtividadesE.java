package InterfaceAtividades;
/**
 * AtividadesE - classe das Atividades Economicas
 */
public abstract class AtividadesE
{
    public abstract String getNaturezaDespesa();
    public abstract double getDeducao();
    private String atividade;
    private double deducao;
    
    public AtividadesE(){
      this.atividade = getNaturezaDespesa();
      this.deducao = getDeducao();
    }
    
    public double getDeducaoDespesa(){
        return this.deducao;
    }
}
