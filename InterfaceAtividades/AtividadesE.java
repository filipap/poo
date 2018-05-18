package InterfaceAtividades;
/**
 * AtividadesE - interface das Atividades Economicas
 */
public interface AtividadesE
{
	/**
    * metodos comuns a todas as classes que implementam a interface AtividadesE
    */
    public abstract AtividadesE clone();
    public abstract String getNaturezaDespesa();
    public abstract double getDeducao();
    public abstract AtividadesE getAtividadesE();
    public abstract int getCod();
}
