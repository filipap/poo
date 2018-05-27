
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
        do{
           gc = f.carregaEstado("javaf.obj");
           System.out.println("\n--------- f-faturas -----------\n");
           System.out.println("Registe-se ou faça login: ");
           System.out.println("Tecla 1: Registar");
           System.out.println("Tecla 2: Fazer Login");
           System.out.println("Tecla 0: Sair da aplicação");
           Scanner sc = new Scanner(System.in);
           int i = m.scanButton(1,2);
           if(i == 0){break;}
           else{
           switch(i){
               case 1:{
                   System.out.println("Tecla 1: Contribuinte Coletivo");
                   System.out.println("Tecla 2: Contribuinte Individual");
                   int j = m.scanButton(1,2);
                   switch(j){
                       case 1:{
                           try{
                                Empresarial e = m.scanNewCompany();
                                gc.addContribuinte(e);
                           }
                           catch(ContJaExisteException g){System.out.println("já existe esse contribuinte");}
                           break;     
                       }
                       case 2:{
                           try{
                                Individuais ind = m.scanNewIndividual();
                                gc.addContribuinte(ind);
                           }
                           catch(ContJaExisteException g){System.out.println("já existe esse contribuinte");}
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
                       System.out.println("\n    Administrador do Sistema    ");
                       System.out.println("Tecla 1: verificar 10 contribuintes que mais gastaram");
                       System.out.println("Tecla 2: verificar X empresas que emitiram mais faturas");
                       System.out.println("Tecla 3: verificar X empresas que deduzem maior montante para efeitos de IRS");
                       System.out.println("Tecla 4: Número de contribuintes do sistema");
                       System.out.println("Tecla 5: Número de faturas pendentes no sistema");
                       int k = m.scanButton(1,5);
                       m.execBotaoA(k,gc);
                       break;
                     }
                     case 1:{
                          try{
                              Empresarial emp = m.scanEmpresa(gc);
                            do{
                              System.out.println("Tecla 1: Verificar faturas emitidas por contribuinte");
                              System.out.println("Tecla 2: Emitir fatura");
                              System.out.println("Tecla 3: Verificar total faturado");
                              System.out.println("Tecla 4: Logout");
                              int k = m.scanButton(1,4);
                              if(k==4)break;
                              else m.execBotaoE(k,gc,emp);
                            } while(true);
                            break;
                          }
                          catch(ContNaoEmpresarialException c){
                             System.out.println("\no contribuinte " + c.getMessage() + " não é do tipo empresarial\n");
                             break;
                          }
                          catch(ContNaoExisteException c){
                             System.out.println("\nnão existe contribuinte com NIF" + c.getMessage() + "\n");
                            break;
                          }
                          catch(PassNaoCorrespondeException p){
                             System.out.println("\n" + p.getMessage() + " não é a password correta!\n");
                             break;
                          }
                    }
                     case 2:{
                         try{
                           Individuais ind = m.scanIndividual(gc);
                          do{
                           System.out.println("Tecla 1: Verificar faturas");
                           System.out.println("Tecla 2: Visualizar perfil");
                           System.out.println("Tecla 3: Visualizar montante acumulado pelo agregado familiar");
                           System.out.println("Tecla 4: Faturas pendentes");
                           System.out.println("Tecla 5: Logout");
                           int k = m.scanButton(1,5);
                           if(k==5)break;
                           else m.execBotaoI(k,ind,gc);
                           } while(true);
                         }
                          catch(ContNaoIndividualException c){
                             System.out.println("\no contribuinte " + c.getMessage() + " não é do tipo individual\n");
                             break;
                           }
                          catch(ContNaoExisteException c){
                             System.out.println("\nnão existe contribuinte com NIF " + c.getMessage() + "\n");
                             break;
                           }
                           catch(PassNaoCorrespondeException p){
                             System.out.println("\n" + p.getMessage() + " não é a password correta!\n");
                             break;
                           }  
               
                    }
                     break;
               }
               }
           }
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
           
         }while(true);
       }
       catch(FileNotFoundException g){System.out.println("ficheiro nao encontrado");}
       catch(ClassNotFoundException c){System.out.println("classe nao encontrada");}
       catch(IOException i){System.out.println("erro ao abrir o ficheiro");}
       
       System.exit(0);
    }  
}
