import java.util.*;
import InterfaceAtividades.*;
import java.time.LocalDate;
import Excecoes.*;
//tester dos metodos
public class my_tester
{
    public static void main(){
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
       //System.out.println(c1.toString()+"\n");
       Contribuinte c2 = new Empresarial(123,"lipap","Lava Tudo Direitinho","rua do passo","12NE4",gf,at);
       //System.out.println(c2.toString()+"\n");
       //System.out.println(gf.toString()+"\n");
       GestaoContribuintes gc = new GestaoContribuintes();
       try{
           gc.addContribuinte(c1);
           gc.addContribuinte(c2);
           ArrayList<Contribuinte> res = (ArrayList)gc.devolve10MaisGastadores();
           System.out.println(res.toString());
        }
       catch(ContJaExisteException e){System.out.println(e.getMessage());}
    }
}
