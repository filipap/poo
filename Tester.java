
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
import java.io.*;
import Excecoes.*;
public class Tester
{
    public static void main(String[] args){
       Menu m = new Menu();
       Ficheiros f = new Ficheiros();
       GestaoContribuintes gc = null;
       try{
           gc = f.carregaEstado("javaf.obj");
           System.out.println("--------- f-faturas -----------\n");
           System.out.println("Registe-se ou faça login: ");
           System.out.println("Tecla 1: Registar");
           System.out.println("Tecla 2: Fazer Login");
           int i = m.scanButton(1,2);
           switch(i){
               case 1:{
                   System.out.println("Tecla 1: Contribuinte Coletivo");
                   System.out.println("Tecla 2: Contribuinte Individual");
                   int j = m.scanButton(1,2);
                   switch(j){
                       case 1:{
                           Empresarial e = m.scanNewCompany();
                           try{
                                gc.addContribuinte(e);
                           }
                           catch(ContJaExisteException g){System.out.println("ja existe esse contribuinte");}
                           break;     
                       }
                       case 2:{
                           Individuais ind = m.scanNewIndividual();
                           try{
                                gc.addContribuinte(ind);
                           }
                           catch(ContJaExisteException g){System.out.println("ja existe esse contribuinte");}
                           break;
                       }
                    }
                       break;
               }
               case 2:{
                 System.out.println("Tecla 1: Contribuinte Coletivo");
                 System.out.println("Tecla 2: Contribuinte Individual");
                 int j = m.scanButton(0,2);
                   switch(j){
                     case 0:{
                       System.out.println("    Administrador do Sistema    ");
                       System.out.println("Tecla 1: Verificar faturas");
                       System.out.println("Tecla 2: Faturas pendentes");
                       break;
                     }
                     case 1:{
                       try{
                         Empresarial e = m.scanEmpresa(gc);
                         System.out.println("Tecla 1: Verificar faturas emitidas");
                         System.out.println("Tecla 2: Emitir fatura");
                         int k = m.scanButton(1,2);
                         m.execBotaoE(k,e);
                         break;     
                       }
                       catch(ContNaoExisteException c){
                         System.out.println(c.getMessage());
                         break;
                       }
                       catch(PassNaoCorrespondeException p){
                         System.out.println("password errada!");
                         break;
                       }
                     }
                     case 2:{
                         try{
                           Individuais ind = m.scanIndividual(gc);
                           System.out.println("Tecla 1: Verificar faturas");
                           System.out.println("Tecla 2: Faturas pendentes");
                           System.out.println("Tecla 3: Visualizar perfil");
                           int k = m.scanButton(1,3);
                           m.execBotaoI(k,ind);
                           break;
                         }
                          catch(ContNaoExisteException c){
                            System.out.println(c.getMessage());
                            break;
                          }
                          catch(PassNaoCorrespondeException p){
                            System.out.println("password errada!");
                            break;
                          }
      
                      }  
               
                    }
                  break;
               }
           }
       }
       catch(FileNotFoundException g){System.out.println("ficheiro nao encontrado");}
       catch(ClassNotFoundException c){System.out.println("classe nao encontrada");}
       catch(IOException i){System.out.println("erro ao abrir o ficheiro");}
       try{
           f.guardaEstado("javaf.obj",gc);
       }
       catch(FileNotFoundException fil){System.out.println("ficheiro nao encontrado!");}
       catch(IOException h){System.out.println("erro a aceder ao ficheiro!");}
       
       try{
           f.escreveEmFicheiroTxt("javaf.txt",gc);
       }
       catch(IOException h){System.out.println("erro a aceder ao ficheiro!");}
    }  
}
