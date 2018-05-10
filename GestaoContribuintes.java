
/**
 *classe onde se gerem os Contribuintes 
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
public class GestaoContribuintes {
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
  private Map<Integer, Contribuinte> contribuintes;

  /**
  * Construtor por omissao para objetos da classe GestaoContribuintes
  */
  public GestaoContribuintes(){
    this.contribuintes = new HashMap<>();
  }

  /**
  * Construtor para objetos parametrizado da classe GestaoContribuintes
  */
  public GestaoContribuintes(Map<Integer,Contribuinte> cont) {
    //this.encomendas = encs.values().stream().collect(Collectors.toMap((e) -> e.getNEnc(),(e) -> e.clone(),(e1,e2) -> e1,HashMap::new));
    this.contribuintes = cont.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone()));
  }
  
  /**
  * Construtor de copia para objetos da classe GestaoContribuintes
  */
  public GestaoContribuintes(GestaoContribuintes gc) {
    this.contribuintes = gc.getContribuintes();    
  }
  
  /*metodos de instancia*/

  //devolve o HashMap de Contribuintes
  public Map<Integer,Contribuinte> getContribuintes() {
    return this.contribuintes.values().stream().collect(Collectors.toMap((c) -> c.getNif(),(c) -> c.clone())); 
  }
  
  /** metodos da classe GestaoContribuintes*/
  /**
  * metodo que retorna a representação textual do objeto
  * @return 
  */
  public String toString() {
     StringBuffer sb = new StringBuffer();
     for (Contribuinte c: this.contribuintes.values())
       sb.append(c.toString() + "\n ----- \n");
     return sb.toString(); 
  }
  

  /**
  * Verifica a igualdade de dois objectos
  * @param obj
  * @return true or false
  */
  public boolean equals(Object o) {
    if (this == o) 
      return true;
    if ((o == null) || (this.getClass() != o.getClass()))
      return false;
    GestaoContribuintes gc = (GestaoContribuintes) o;
    return this.contribuintes.equals(gc.getContribuintes());
       
   }    
   
  /**
  * Adiciona um contribuinte
  * @param cont
  * 
  */
  public void addContribuinte(Contribuinte cont) throws ContJaExisteException{
    if (contribuintes.containsKey(cont.getNif()))
    throw
       new ContJaExisteException("O contribuinte " + cont.getNif() + " ja existe!");
    else this.contribuintes.put(cont.getNif(),cont.clone());    
  }
  
  public GestaoContribuintes clone() {
    return new GestaoContribuintes(this); 
   }
  
  /**
  * conta o numero de contribuintes
  * @return
  */
  public int contaContribuintes() {
    return this.contribuintes.size();    
  }
  
  /**
  * remove um contribuinte
  * @param nif
  */
  public void removeContribuinte(Integer nif) throws ContNaoExisteException{
      if(!contribuintes.containsKey(nif))
      throw
         new ContNaoExisteException("O contribuinte " + nif + " nao existe.");
      else this.contribuintes.remove(nif);    
  }
  
  /**
  * escreve o estado em ficheiro de texto
  * @param nomeFicheiro
  */
  public void escreveEmFicheiroTxt(String nomeFicheiro) throws IOException
    {
        PrintWriter fich = new PrintWriter(nomeFicheiro);
        fich.println("---Contribuintes---");
        fich.println(this.toString());
        fich.flush();
        fich.close();
    }
  
  /**
  * metodo que guarda em ficheiro de objetos o objeto que recebe a mensagem
  * @param nomeFicheiro
  */
  public void guardaEstado(String nomeFicheiro) throws FileNotFoundException,IOException{
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this); // 
        oos.flush();
        oos.close();
    }
  
  public static GestaoContribuintes carregaEstado (String nomeFicheiro) throws FileNotFoundException,IOException,ClassNotFoundException{

    FileInputStream fis = new FileInputStream(nomeFicheiro);
    ObjectInputStream ois = new ObjectInputStream(fis);
    GestaoContribuintes h = (GestaoContribuintes) ois.readObject();
    ois.close();
    return h;
    }
}
