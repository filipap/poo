
/**
 * classe de teste
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.time.LocalDate;
import InterfaceAtividades.AtividadesE;
import InterfaceAtividades.Saude;
public class Tester
{
    public static void main(String[] args){
       ArrayList<Integer> agC1 = new ArrayList<>();
       agC1.add(124);
       agC1.add(125);
       ArrayList<Integer> atC1 = new ArrayList<>();
       atC1.add(1);
       atC1.add(2);
       Saude s1 = new Saude();
       ArrayList <AtividadesE> at = new ArrayList<>();
       at.add(s1);
       Contribuinte c1 = new Individuais(122,"lipap","Filipa","rua da mata","12*34",2,agC1,(float)0.15,atC1);
       //System.out.println(c1.toString()+"\n");
       Contribuinte c2 = new Empresarial(123,"lipap","Lava Tudo Direitinho","rua do passo","12NE4",at);
       //System.out.println(c2.toString()+"\n");
       Fatura f1 = new Fatura(c2.getNif(),c2.getNome(),LocalDate.now(),c1.getNif(),"pente",20,s1);
       Fatura f2 = new Fatura(c2.getNif(),c2.getNome(),LocalDate.of(2010,5,02),c1.getNif(),"pasta de dentes",23,s1);
       Fatura f3 = new Fatura(c2.getNif(),c2.getNome(),LocalDate.of(2013,8,20),c1.getNif(),"pente",12,s1);
       GestaoFaturas gf = new GestaoFaturas();
       gf.addFatura(f1);
       gf.addFatura(f2);
       gf.addFatura(f3);
       System.out.println(gf.toString()+"\n");

       GestaoContribuintes gc = new GestaoContribuintes();
       gc.addContribuinte(c1);
       gc.addContribuinte(c2);
       
       System.out.println("Sistema de Gestão de Contribuintes:\n");
       System.out.println(gc.toString());
    }
}
