
/**
 * classe de teste
 * 
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 */

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.time.LocalDate;
import java.util.Scanner;
import InterfaceAtividades.*;
import java.util.Iterator;

public class Tester
{
    public static void main(String[] args){
       System.out.println("--------- f-faturas -----------\n");
       System.out.println("Registe-se ou faça login: ");
       System.out.println("Tecla 1: Registar");
       System.out.println("Tecla 2: Fazer Login");
       Menu m = new Menu();
       int i = m.scanButton(1,2);
       switch(i){
         case 1:{
           System.out.println("Tecla 1: Contribuinte Coletivo");
           System.out.println("Tecla 2: Contribuinte Individual");
           int j = m.scanButton(1,2);
             switch(j){
               case 1:{
                   Empresarial e = m.scanNewCompany();
                   System.out.println(e.toString());
                 break;     
               }
               case 2:{
                 break;
               }
             }
           break;
         }
         case 2:{
           System.out.println("Tecla 1: Contribuinte Coletivo");
           System.out.println("Tecla 2: Contribuinte Individual");
           int j = m.scanButton(1,2);
             switch(j){
               case 1:{
                 break;     
               }
               case 2:{
                 break;
               }
             }
           break;
         }
       }
    }  
}
