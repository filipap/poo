
/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import InterfaceAtividades.*;
import java.util.ArrayList;
import java.util.List;
public class Menu {
    
    public int scanButton(int inicio,int fim){
       Scanner sc = new Scanner(System.in);
          int i = sc.nextInt();
          while (i<=inicio && i>=fim) {
            i = sc.nextInt();
            System.out.println("escolha uma das opções");
          }
          return i;
    }
    
    public List<String> scanAtivities(int n){
       Scanner sc = new Scanner(System.in); 
       System.out.println("Digite agora as atividades nas quais deduz para IRS das seguintes aqui listadas: ");
       System.out.println("Educação,Saúde,Cuidados Veterinários,Reparação Veículos,Cabeleireiros,Transportes,"+
       "Restauração,Habitação,Despesas Familiares");
       ArrayList <String> atE = new ArrayList<> ();
       while(sc.hasNextLine()&& n>0){
           atE.add(sc.nextLine());
           n--;
       }
       return atE;
    }
    
    public List<AtividadesE> insertAtivities(List<String> at){
       ArrayList<AtividadesE> res = new ArrayList<>();
       int i = 0;
       while(i<at.size()){
           if(at.get(i).equals("Educação")){ res.add(new Educacao());}
           if(at.get(i).equals("Saúde")){ res.add(new Saude());}
           if(at.get(i).equals("Cuidados Veterinários")){ res.add(new Animais());}
           if(at.get(i).equals("Reparação Veículos")){ res.add(new ReparacoesV());}
           if(at.get(i).equals("Cabeleireiros")){ res.add(new Cabeleireiros());}
           if(at.get(i).equals("Transportes")){ res.add(new Transportes());}
           if(at.get(i).equals("Restauração")){ res.add(new Restauracao());}
           if(at.get(i).equals("Habitação")){ res.add(new Habitacao());}
           if(at.get(i).equals("Despesas Familiares")){ res.add(new DespesasF());}
           i++;
       }
       return res;
    }

    public List<String> scanNewContribuinte(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu NIF: ");
        String nif = sc.next();
        System.out.println("Digite o seu nome: ");
        String name = sc.next();
        System.out.println("Digite o seu email: ");
        String email = sc.next();
        System.out.println("Digite a sua morada: ");
        String morada = sc.next();
        System.out.println("Digite a sua password de acesso: ");
        String pass = sc.next();
        ArrayList <String> res = new ArrayList<>();
        res.add(nif);
        res.add(name);
        res.add(email);
        res.add(morada);
        res.add(pass);
        return (List)res;

    }
    public Empresarial scanNewCompany(){
        List<String> cont = scanNewContribuinte();
        GestaoFaturas fat = new GestaoFaturas();
        System.out.println("Digite o numero de atividades nas quais deduz: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<String> at = scanAtivities(n);
        List<AtividadesE> res = insertAtivities(at);
        int nif = Integer.parseInt(cont.get(0));
        return new Empresarial(nif,cont.get(0),cont.get(2),cont.get(1),cont.get(3),fat,res);
    }

    public List<Integer> scanAgregado(int n){
        System.out.println("Digite o nif de cada elemento do seu agregado familiar: ");
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<>();
        while(n>0){
          int i = sc.nextInt();
          res.add(i);
        }
        return res;
    }

    public Individual scanNewCompany(){
        List<String> cont = scanNewContribuinte();
        GestaoFaturas fat = new GestaoFaturas();
        System.out.println(": ");
        List<String> at = scanAtivities(n);
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos elementos fazem parte do seu agregado familiar? "); 
        int agregado = Integer.parseInt(sc.next());
        List<Integer> nifAgregado = scanAgregado(agregado);
        return new Empresarial(nif,cont.get(0),cont.get(2),cont.get(1),cont.get(3),fat,res);
    }
}
