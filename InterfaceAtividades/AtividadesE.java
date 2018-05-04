package InterfaceAtividades;
/**
 * AtividadesE - interface das Atividades Economicas
 */
public interface AtividadesE
{
    public abstract AtividadesE clone();
    public abstract String getNaturezaDespesa();
    public abstract double getDeducao();
    public abstract AtividadesE getAtividadesE();
    //public abstract void setAtividadesE();
}
