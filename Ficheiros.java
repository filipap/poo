
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
       Cabeleireiros c1 = new Cabeleireiros();
       Habitacao h1 = new Habitacao();
       Transportes t1 = new Transportes();
       DespesasF df1 = new DespesasF();
       Restauracao res1 = new Restauracao();
       Educacao ed1 = new Educacao();
       ArrayList <AtividadesE> at = new ArrayList<>();
       ArrayList <AtividadesE> at1 = new ArrayList<>();
       ArrayList <AtividadesE> at2 = new ArrayList<>();
       ArrayList <AtividadesE> at3 = new ArrayList<>();
       ArrayList <AtividadesE> at4 = new ArrayList<>();
       ArrayList <AtividadesE> at5 = new ArrayList<>();
       ArrayList <AtividadesE> at6 = new ArrayList<>();
       ArrayList <AtividadesE> at7 = new ArrayList<>();
       ArrayList <AtividadesE> at8 = new ArrayList<>();
       ArrayList <AtividadesE> at9 = new ArrayList<>();
       at.add(s1);
       at1.add(r1);
       at2.add(c1);
       at3.add(ed1);
       at4.add(res1);
       at5.add(df1);
       at6.add(a1);
       at6.add(s1);
       at7.add(t1);
       at7.add(r1);
       at8.add(a1);
       //at9.add(c1);

       Fatura f1 = new Fatura(123,"Hospital Particular das Gambelas",LocalDate.now(),131,5.0,"Consulta Medicina Dentaria",20,at);
       Fatura f2 = new Fatura(123,"Hospital Particular das Gambelas",LocalDate.of(2014,3,4),134,80.0,"Internamento\n Cirurgia de reconstruçao",320,at);
       Fatura f3 = new Fatura(128,"Pingo Doce",LocalDate.of(2010,5,02),131,11.15,"pasta de dentes\n robo cozinha",223,at5);
       Fatura f4 = new Fatura(123,"Hospital Particular das Gambelas",LocalDate.of(2013,8,20),137,5.0,"Consulta Medicina Interna",20,at);
       Fatura f5 = new Fatura(128,"Pingo Doce",LocalDate.of(2016,7,22),140,0.25,"pente",5,at5);
       Fatura f6 = new Fatura(124,"Adriano Martins Ldª",LocalDate.of(2015,4,4),139,1200.0,"compra peugeot 2000",15000,at1);
       Fatura f7 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2013,8,20),137,0.6,"corte cabelo",5,at2);
       Fatura f8 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2012,5,20),137,0.0,"lavagem + aspiração",10,at9);
       Fatura f9 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2017,8,22),136,0.6,"corte cabelo",5,at2);
       Fatura f10 = new Fatura(126,"Universidade do Minho - Campus de Gualtar",LocalDate.of(2005,2,18),131,1.25,"Pedido exame época especial",5,at3);
       Fatura f11= new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2008,8,20),133,0.0,"lavagem + aspiração",10,at9);
       Fatura f12 = new Fatura(124,"Adriano Martins Ldª",LocalDate.of(2009,3,2),132,8.0,"reparação veículo",100,at1);
       Fatura f13 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2014,12,20),132,0.6,"corte cabelo",12,at2);
       Fatura f14 = new Fatura(127,"Restaurante Foz",LocalDate.of(2012,10,20),135,0.750,"Diária",5,at4);
       Fatura f15 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2014,11,10),134,2.40,"coloração",20,at2);
       Fatura f16 = new Fatura(124,"Adriano Martins Ldª",LocalDate.of(2017,7,10),138,960.0,"compra smart fortwo",120000,at1);
       Fatura f17 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2013,8,20),135,0.0,"lavagem + aspiração",10,at9);
       Fatura f18 = new Fatura(126,"Universidade do Minho - Campus de Gualtar",LocalDate.of(2017,4,30),140,6.25,"senhas cantina",25,at3);
       Fatura f19 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2014,5,26),132,0.0,"lavagem",5,at9);
       Fatura f20 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2012,5,27),134,0.6,"corte cabelo",5,at2);
       Fatura f21 = new Fatura(127,"Restaurante Foz",LocalDate.of(2017,4,22),135,4.50,"Rodízio",30,at4);
       Fatura f22 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2018,2,20),136,0.6,"corte cabelo",5,at2);
       Fatura f23 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2013,8,20),131,0.0,"aspiração",5,at9);
       Fatura f24 = new Fatura(126,"Universidade do Minho - Campus de Gualtar",LocalDate.of(2016,7,2),122,12.5,"Pedido transferência",50,at3);
       Fatura f25 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2016,8,19),132,0.0,"lavagem + aspiração",10,at9);
       Fatura f26 = new Fatura(128,"Pingo Doce",LocalDate.of(2018,5,2),122,0.05,"fruta",10,at5);
       Fatura f27 = new Fatura(124,"Adriano Martins Ldª",LocalDate.of(2014,5,18),137,6.4,"reparação veículo",80,at1);
       Fatura f28 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2013,8,20),132,0.0,"lavagem + aspiração",12,at9);
       Fatura f29 = new Fatura(126,"Universidade do Minho - Campus de Gualtar",LocalDate.of(2018,4,20),135,6.25,"senhas cantina",25,at3);
       Fatura f30 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2013,4,2),138,3.6,"coloração + corte cabelo",30,at2);
       Fatura f31 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2015,4,5),137,0.0,"lavagem + aspiração",10,at9);
       Fatura f32 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2016,3,25),136,0.6,"corte cabelo",5,at2);
       Fatura f33 = new Fatura(128,"Pingo Doce",LocalDate.of(2013,7,10),135,0.6,"legumes e peixe",12,at5);
       Fatura f34 = new Fatura(124,"Adriano Martins Ldª",LocalDate.of(2011,9,15),134,8.0,"reparação veículo",100,at1);
       Fatura f35 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2016,8,23),133,0.0,"lavagem + aspiração",10,at9);
       Fatura f36 = new Fatura(127,"Restaurante Foz",LocalDate.of(2012,3,12),135,0.750,"Diária",5,at4);
       Fatura f37 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2013,8,20),134,0.6,"corte cabelo",5,at2);
       Fatura f38 = new Fatura(130,"Lava Tudo Direitinho",LocalDate.of(2015,5,21),133,0.0,"lavagem + aspiração",10,at9);
       Fatura f39 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2018,1,20),134,2.4,"coloração",20,at2);
       Fatura f40 = new Fatura(127,"Restaurante Foz",LocalDate.of(2014,2,10),133,4.50,"Rodízio",30,at4);
       Fatura f41 = new Fatura(128,"Pingo Doce",LocalDate.of(2014,6,20),135,0.60,"secção talho e take-away",20,at5);
       Fatura f42 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2014,10,20),132,0.6,"corte cabelo",5,at2);
       Fatura f43 = new Fatura(127,"Restaurante Foz",LocalDate.of(2015,9,20),136,0.750,"Diária",5,at4);
       Fatura f44 = new Fatura(125,"Cortes de Lisboa",LocalDate.of(2016,4,25),139,0.6,"corte cabelo",5,at2);
       Fatura f45 = new Fatura(124,"Adriano Martins Ldª",LocalDate.of(2013,8,20),138,9.60,"reparação automóvel",120,at1);
       Fatura f46 = new Fatura(128,"Pingo Doce",LocalDate.of(2018,3,22),138,1.80,"take-away",12,at5);
       Fatura f47 = new Fatura(127,"Restaurante Foz",LocalDate.of(2015,9,24),136,4.50,"Rodízio",30,at4);
       Fatura f48 = new Fatura(123,"Hospital Particular das Gambelas",LocalDate.of(2014,8,26),136,5.0,"Consulta Ortopedia",20,at);
       Fatura f49 = new Fatura(124,"Adriano Martins Ldª",LocalDate.of(2018,4,25),134,1360.0,"citroen cactus",17000,at1);
       Fatura f50 = new Fatura(127,"Restaurante Foz",LocalDate.of(2018,2,22),132,0.750,"Diária",5,at4);
       Fatura f51 = new Fatura(129,"Hospital Comum",LocalDate.of(2016,8,20),134,0,"Consulta Medicina Interna",20,at6);
       Fatura f52 = new Fatura(129,"Hospital Comum",LocalDate.of(2016,8,20),135,0,"Consulta Dermatologia",20,at6);
       Fatura f53 = new Fatura(129,"Hospital Comum",LocalDate.of(2015,8,20),134,0,"Tratamento Fisioterapia",20,at6);
       Fatura f54 = new Fatura(129,"Hospital Comum",LocalDate.of(2014,8,20),132,0,"Consulta Medicina Interna",20,at6);
       Fatura f55 = new Fatura(129,"Hospital Comum",LocalDate.of(2013,8,20),132,0,"Consulta Ortopedia",20,at6);
       Fatura f56 = new Fatura(129,"Hospital Comum",LocalDate.of(2012,8,20),135,0,"Consulta Medicina Interna",20,at6);
       Fatura f57 = new Fatura(141,"Hospital dos Patinhas",LocalDate.of(2012,6,10),131,5.0,"desparasitação",50,at8);
       Fatura f58 = new Fatura(141,"Hospital dos Patinhas",LocalDate.of(2016,8,27),135,2.0,"aplicação de vacinas",20,at8);
       Fatura f59 = new Fatura(141,"Hospital dos Patinhas",LocalDate.of(2014,5,24),134,1.2,"consulta medicina veterinária",12,at8);
       Fatura f60 = new Fatura(141,"Hospital dos Patinhas",LocalDate.of(2015,9,22),131,10.0,"esterilização local",100,at8);
       
       GestaoFaturas gfHPG = new GestaoFaturas();
       gfHPG.addFatura(f1);
       gfHPG.addFatura(f2);
       gfHPG.addFatura(f4);
       gfHPG.addFatura(f48);
       GestaoFaturas gfLTD = new GestaoFaturas();
       gfLTD.addFatura(f8);
       gfLTD.addFatura(f11);
       gfLTD.addFatura(f17);
       gfLTD.addFatura(f19);
       gfLTD.addFatura(f23);
       gfLTD.addFatura(f25);
       gfLTD.addFatura(f28);
       gfLTD.addFatura(f31);
       gfLTD.addFatura(f35);
       gfLTD.addFatura(f38);
       GestaoFaturas gfcitroen = new GestaoFaturas();
       gfcitroen.addFatura(f6);
       gfcitroen.addFatura(f12);
       gfcitroen.addFatura(f16);
       gfcitroen.addFatura(f27);
       gfcitroen.addFatura(f34);
       gfcitroen.addFatura(f45);
       gfcitroen.addFatura(f49);
       GestaoFaturas gfCL = new GestaoFaturas();
       gfCL.addFatura(f7);
       gfCL.addFatura(f9);
       gfCL.addFatura(f13);
       gfCL.addFatura(f15);
       gfCL.addFatura(f20);
       gfCL.addFatura(f22);
       gfCL.addFatura(f30);
       gfCL.addFatura(f32);
       gfCL.addFatura(f37);
       gfCL.addFatura(f39);
       gfCL.addFatura(f42);
       gfCL.addFatura(f44);
       GestaoFaturas gfUM = new GestaoFaturas();
       gfUM.addFatura(f10);
       gfUM.addFatura(f18);
       gfUM.addFatura(f24);
       gfUM.addFatura(f29);
       GestaoFaturas gfRF = new GestaoFaturas();
       gfRF.addFatura(f14);
       gfRF.addFatura(f21);
       gfRF.addFatura(f36);
       gfRF.addFatura(f40);
       gfRF.addFatura(f43);
       gfRF.addFatura(f47);
       gfRF.addFatura(f50);
       GestaoFaturas gfPD = new GestaoFaturas();
       gfPD.addFatura(f3);
       gfPD.addFatura(f5);
       gfPD.addFatura(f26);
       gfPD.addFatura(f33);
       gfPD.addFatura(f41);
       gfPD.addFatura(f46);
       GestaoFaturas gfHC = new GestaoFaturas();
       gfHC.addFatura(f51);
       gfHC.addFatura(f52);
       gfHC.addFatura(f53);
       gfHC.addFatura(f54);
       gfHC.addFatura(f55);
       gfHC.addFatura(f56);
       GestaoFaturas gfpatinhas = new GestaoFaturas();
       gfpatinhas.addFatura(f57);
       gfpatinhas.addFatura(f58);
       gfpatinhas.addFatura(f59);
       gfpatinhas.addFatura(f60);
       //
       GestaoFaturas gfFilipa = new GestaoFaturas();
       gfFilipa.addFatura(f1);
       gfFilipa.addFatura(f3);
       gfFilipa.addFatura(f10);
       gfFilipa.addFatura(f23);
       gfFilipa.addFatura(f57);
       gfFilipa.addFatura(f60);
       GestaoFaturas gfEdmundo = new GestaoFaturas();
       gfEdmundo.addFatura(f12);
       gfEdmundo.addFatura(f13);
       gfEdmundo.addFatura(f19);
       gfEdmundo.addFatura(f25);
       gfEdmundo.addFatura(f28);
       gfEdmundo.addFatura(f42);
       gfEdmundo.addFatura(f50);
       gfEdmundo.addFatura(f54);
       gfEdmundo.addFatura(f55);
       GestaoFaturas gfSilvia = new GestaoFaturas();
       gfSilvia.addFatura(f11);
       gfSilvia.addFatura(f35);
       gfSilvia.addFatura(f38);
       gfSilvia.addFatura(f40);
       GestaoFaturas gfGustavo = new GestaoFaturas();
       gfGustavo.addFatura(f2);
       gfGustavo.addFatura(f15);
       gfGustavo.addFatura(f20);
       gfGustavo.addFatura(f34);
       gfGustavo.addFatura(f37);
       gfGustavo.addFatura(f39);
       gfGustavo.addFatura(f49);
       gfGustavo.addFatura(f51);
       gfGustavo.addFatura(f53);
       gfGustavo.addFatura(f59);
       GestaoFaturas gfMarcelo = new GestaoFaturas();
       gfMarcelo.addFatura(f14);
       gfMarcelo.addFatura(f17);
       gfMarcelo.addFatura(f21);
       gfMarcelo.addFatura(f29);
       gfMarcelo.addFatura(f33);
       gfMarcelo.addFatura(f36);
       gfMarcelo.addFatura(f41);
       gfMarcelo.addFatura(f52);
       gfMarcelo.addFatura(f56);
       gfMarcelo.addFatura(f58);
       GestaoFaturas gfGuida = new GestaoFaturas();
       gfGuida.addFatura(f9);
       gfGuida.addFatura(f22);
       gfGuida.addFatura(f32);
       gfGuida.addFatura(f43);
       gfGuida.addFatura(f47);
       gfGuida.addFatura(f48);
       GestaoFaturas gfFilipe = new GestaoFaturas();
       gfFilipe.addFatura(f4);
       gfFilipe.addFatura(f7);
       gfFilipe.addFatura(f8);
       gfFilipe.addFatura(f27);
       gfFilipe.addFatura(f31);
       GestaoFaturas gfRita = new GestaoFaturas();
       gfRita.addFatura(f16);
       gfRita.addFatura(f30);
       gfRita.addFatura(f45);
       gfRita.addFatura(f46);
       GestaoFaturas gfVirg = new GestaoFaturas();
       gfVirg.addFatura(f6);
       gfVirg.addFatura(f44);
       GestaoFaturas gfAna = new GestaoFaturas();
       gfAna.addFatura(f5);
       gfAna.addFatura(f18);

       //alterar as faturas
       //alterar os agregados
       Contribuinte i1 = new Individuais(131,"lipac","Filipa Cunha","rua da mata","12*34",gfFilipa,2,agC1,(float)0.15,atC1,false);
       Contribuinte i2 = new Individuais(132,"edsilva","Edmundo Silva","rua das flores","12*34",gfEdmundo,2,agC1,(float)0.15,atC1,false);
       Contribuinte i3 = new Individuais(133,"silvia_machado","Silvia Machado","rua 25 abril","12*34",gfSilvia,2,agC1,(float)0.15,atC1,false);
       Contribuinte i4 = new Individuais(134,"me_gusta","Gustavo Sousa","rua da represa","12*34",gfGustavo,2,agC1,(float)0.15,atC1,false);
       Contribuinte i5 = new Individuais(135,"miranda85","Marcelo Miranda","avenida dos combatentes","12*34",gfMarcelo,2,agC1,(float)0.15,atC1,false);
       Contribuinte i6 = new Individuais(136,"magui_rib","Margarida Ribeiro","rua da mata da presa","12*34",gfGuida,2,agC1,(float)0.15,atC1,false);
       Contribuinte i7 = new Individuais(137,"so_filipe","Filipe Pereira","avenida da liberdade","12*34",gfFilipe,2,agC1,(float)0.15,atC1,false);
       Contribuinte i8 = new Individuais(138,"ritata","Rita Soares","rua dos combatentes da 1ª grande guerra","12*34",gfRita,2,agC1,(float)0.15,atC1,false);
       Contribuinte i9 = new Individuais(139,"virgilio_ferreira","Virgílio Ferreira","praça da erva","12*34",gfVirg,2,agC1,(float)0.15,atC1,false);
       Contribuinte i10 = new Individuais(140,"anab","Ana Borralho","rua dos santos","12*34",gfAna,2,agC1,(float)0.15,atC1,false);
       
       Contribuinte e1 = new Empresarial(123,"HPG","Hospital Particular das Gambelas","rua do chafariz","12NE456",gfHPG,at,true);
       Contribuinte e2 = new Empresarial(124,"citroen","Adriano Martins Ldª","rua da praia","tYvfBAka",gfcitroen,at1,false);
       Contribuinte e3 = new Empresarial(125,"cortes.lisboa","Cortes de Lisboa","edificio Braga Parque, lote 16","fjPnuauc",gfCL,at2,true);
       Contribuinte e4 = new Empresarial(126,"UM","Universidade do Minho - Campus de Gualtar"
        ,"rua da Universidade","Q2ZYWQMp",gfUM,at3,true);
       Contribuinte e5 = new Empresarial(127,"foz_cafe","Restaurante Foz","praia da Arda","N6mck6zA",gfRF,at4,false);
       Contribuinte e6 = new Empresarial(128,"PD","Pingo Doce","Avenida da Liberdade","Y2VC7cQR",gfPD,at5,false);
       Contribuinte e7 = new Empresarial(129,"HC","Hospital Comum","rua do passo","E6QVjbT7",gfHC,at6,true);
       Contribuinte e8 = new Empresarial(130,"LTD","Lava Tudo Direitinho","rua do passo","GnST4yWu",gfLTD,at7,true);
       Contribuinte e9 = new Empresarial(141,"patinhas","Hospital dos Patinhas","rua da graça","uKezkxvC",gfpatinhas,at8,false);
       GestaoContribuintes gc = new GestaoContribuintes();
       try{
           gc.addContribuinte(i1);
           gc.addContribuinte(i2);
           gc.addContribuinte(i3);
           gc.addContribuinte(i4);
           gc.addContribuinte(i5);
           gc.addContribuinte(i6);
           gc.addContribuinte(i7);
           gc.addContribuinte(i8);
           gc.addContribuinte(i9);
           gc.addContribuinte(i10);
           gc.addContribuinte(e1);
           gc.addContribuinte(e2);
           gc.addContribuinte(e3);
           gc.addContribuinte(e4);
           gc.addContribuinte(e5);
           gc.addContribuinte(e6);
           gc.addContribuinte(e7);
           gc.addContribuinte(e8);
           gc.addContribuinte(e9);
       
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
