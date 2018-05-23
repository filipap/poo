import java.util.*;
import InterfaceAtividades.*;
import java.time.LocalDate;
import Excecoes.*;
//tester dos metodos
public class my_tester
{
    public static void main(String[] args){
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
       Fatura f1 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2013,8,20),135,0.0,"lavagem + aspiração",10,at);
       Fatura f2 = new Fatura(126,"Universidade do Minho - Campus de Gualtar",LocalDate.of(2017,4,30),140,6.25,"senhas cantina",25,at);
       
       GestaoFaturas gf = new GestaoFaturas();
       gf.addFatura(f1);
       gf.addFatura(f2);
       //gf.addFatura(f3);

       Contribuinte c1 = new Individuais(122,"lipap","Filipa","rua da mata","12*34",gf,2,agC1,(float)0.15,atC1,false);
       //System.out.println(c1.toString()+"\n");
       Contribuinte c2 = new Empresarial(123,"lipap","Lava Tudo Direitinho","rua do passo","12NE4",gf,at,false);
       //System.out.println(c2.toString()+"\n");
       //System.out.println(gf.toString()+"\n");
       GestaoContribuintes gc = new GestaoContribuintes();
       try{
         System.out.println(f1.atualizaFatura(7).toString());
       }
       catch(SemAtividadeException e){System.out.println(e.getMessage());}
       /*    gc.addContribuinte(c1);
           gc.addContribuinte(c2);
           ArrayList<Contribuinte> res = (ArrayList)gc.devolve10MaisGastadores();
           System.out.println(res.toString());
        }
       catch(ContJaExisteException e){System.out.println(e.getMessage());}
      */
    }
}
