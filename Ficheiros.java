
/**
 * Ficheiros - classe dos ficheiros
 *
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.*;
import InterfaceAtividades.*;
import java.time.LocalDate;
import Excecoes.*;

public class Ficheiros
{
  /**
   * Escreve o estado em ficheiro de texto
   * @param nomeFicheiro
  */
  public static void escreveEmFicheiroTxt(String nomeFicheiro, GestaoContribuintes gc) throws IOException{
      PrintWriter fich = new PrintWriter(nomeFicheiro);
      fich.println("---Contribuintes---");
      fich.println(gc.toString());
      fich.flush();
      fich.close();
  }
  
  /**
  * Método que guarda em ficheiro de objetos o objeto que recebe a mensagem
  * @param nomeFicheiro
  */
  public static void guardaEstado(String nomeFicheiro, GestaoContribuintes gc) throws FileNotFoundException,IOException{
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(gc); // 
        oos.flush();
        oos.close();
  }

  /**
   * Método que carrega os objetos do ficheiro texto
   * @param nomeFicheiro
  */
  public static GestaoContribuintes carregaEstado (String nomeFicheiro) throws FileNotFoundException,IOException,ClassNotFoundException{
        FileInputStream fis = new FileInputStream(nomeFicheiro);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GestaoContribuintes h = new GestaoContribuintes((GestaoContribuintes) ois.readObject());
        ois.close();
        return h;
  }
    
    public static void main(String[] arg) {
       ArrayList<Integer> agC1 = new ArrayList<>();
       agC1.add(124);
       agC1.add(125);
       ArrayList<Integer> atC1 = new ArrayList<>();
       atC1.add(1);
       atC1.add(2);
       Saude s1 = new Saude();
       ReparacoesV r1 = new ReparacoesV();
       Animais a1 = new Animais();
       ArrayList <AtividadesE> at = new ArrayList<>();
       at.add(s1);
       at.add(r1);
       at.add(a1);
       Fatura f1 = new Fatura(123,"Lava Tudo Direitinho",LocalDate.now(),122,"pente",20,at);
       Fatura f2 = new Fatura(123,"Lava Tudo Direitinho",LocalDate.of(2010,5,02),122,"pasta de dentes",23,at);
       Fatura f3 = new Fatura(123,"Lava Tudo Direitinho",LocalDate.of(2013,8,20),122,"pente",12,at);
       GestaoFaturas gf = new GestaoFaturas();
       gf.addFatura(f1);
       gf.addFatura(f2);
       gf.addFatura(f3);
       Contribuinte c1 = new Individuais(122,"lipap","Filipa","rua da mata","12*34",gf,2,agC1,(float)0.15,atC1);
       Contribuinte c2 = new Empresarial(123,"lipap","Lava Tudo Direitinho","rua do passo","12NE4",gf,at);
       GestaoContribuintes gc = new GestaoContribuintes();
       try{
           gc.addContribuinte(c1);
           gc.addContribuinte(c2);
       }
       catch(ContJaExisteException e){System.out.println(e.getMessage());}
       
       try{
           guardaEstado("javaf.obj",gc);
       }
       catch(FileNotFoundException fil){System.out.println("ficheiro nao encontrado!");}
       catch(IOException h){System.out.println("erro a aceder ao ficheiro!");}
       
       try{
           escreveEmFicheiroTxt("javaf.txt",gc);
       }
       catch(IOException h){System.out.println("erro a aceder ao ficheiro!");}
       
       try{
           gc = carregaEstado("javaf.obj");
           System.out.println("done!");
       }
       catch(FileNotFoundException f){System.out.println("ficheiro nao encontrado");}
       catch(ClassNotFoundException c){System.out.println("classe nao encontrada");}
       catch(IOException i){System.out.println("erro ao abrir o ficheiro");}
    }
}
