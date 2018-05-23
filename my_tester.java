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
       Fatura f1 = new Fatura(123,"Lava Tudo Direitinho",LocalDate.of(2013,8,20),122,0.0,"lavagem + aspiração",10,at);
       Fatura f2 = new Fatura(123,"Universidade do Minho - Campus de Gualtar",LocalDate.of(2017,4,30),122,6.25,"senhas cantina",25,at);
       
       GestaoFaturas gf = new GestaoFaturas();
       gf.addFatura(f1);
       gf.addFatura(f2);
       //gf.addFatura(f3);

       Contribuinte c1 = new Individuais(122,"lipap","Filipa","rua da mata","12*34",gf,2,agC1,(float)0.15,atC1,false);
       //System.out.println(c1.toString()+"\n");
       Contribuinte c2 = new Empresarial(123,"lipap","Lava Tudo Direitinho","rua do passo","12NE4",gf,at,false);
       //System.out.println(c2.toString()+"\n");
       //System.out.println(gf.toString()+"\n");
       
       try{
         GestaoContribuintes gc = new GestaoContribuintes();
         gc.addContribuinte(c1);
         gc.addContribuinte(c2);
         System.out.println(gf.atualizaFaturasAtCorreta(7,1,gc).toString());
       }
       
       catch(SemAtividadeException j){
                          System.out.println("não existe a atividade " + j.getMessage());
                          //break;
                        }
                        catch(ContNaoIndividualException j){
                          System.out.println("a conta " + j.getMessage() + "não é do tipo individual");
                         // break;
                        }
                        catch(ContNaoEmpresarialException j){
                          System.out.println("a conta " + j.getMessage() + "não é do tipo empresarial");
                         // break;
                        }
                        catch(ContNaoExisteException j){
                          System.out.println("não existe utilizador com NIF " + j.getMessage());
                          //break;
                        }
                        catch(ContJaExisteException j){
                          System.out.println("não existe utilizador com NIF " + j.getMessage());
                          //break;
                        }
       /*    gc.addContribuinte(c1);
           gc.addContribuinte(c2);
           ArrayList<Contribuinte> res = (ArrayList)gc.devolve10MaisGastadores();
           System.out.println(res.toString());
        }
       catch(ContJaExisteException e){System.out.println(e.getMessage());}
      */
    }
}
