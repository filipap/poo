
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
public class Tester
{
    public static void main(String[] args){
       ArrayList<Integer> agC1 = new ArrayList<>();
       agC1.add(124);
       agC1.add(125);
       ArrayList<Integer> atC1 = new ArrayList<>();
       atC1.add(1);
       atC1.add(2);
       Contribuinte c1 = new Individuais(123,"lipap","Filipa","rua da mata","12*34",2,agC1,(float)0.15,atC1);
       System.out.println(c1.toString()+"\n");
       Contribuinte c2 = new Empresarial(123,"lipap","Lava Tudo Direitinho","rua do passo","12NE4");
       System.out.println(c2.toString()+"\n");
    }
}
