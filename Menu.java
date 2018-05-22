
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Excecoes.*;
import java.io.*;
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
       ArrayList <String> atE = new ArrayList<String> ();
       while(n>0 && sc.hasNextLine()){
           atE.add(sc.nextLine());
           n--;
       }
       return atE;
    }
    
    public List<AtividadesE> insertAtivities(List<String> at){
       ArrayList<AtividadesE> res = new ArrayList<AtividadesE>();
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
        ArrayList <String> res = new ArrayList<String>();
        res.add(nif);
        res.add(name);
        res.add(email);
        res.add(morada);
        res.add(pass);
        return (List)res;

    }
    public Empresarial scanNewCompany(){
        List<String> cont = new ArrayList<String>();
        cont = scanNewContribuinte();
        GestaoFaturas fat = new GestaoFaturas();
        System.out.println("Digite o numero de atividades nas quais deduz: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        List<String> at = new ArrayList<String>();
        at = scanAtivities(n);
        List<AtividadesE> res = new ArrayList<AtividadesE>();
        res = insertAtivities(at);
        System.out.println("A sua empresa localiza-se: ");
        System.out.println("Tecla 0: Interior");
        System.out.println("Tecla 1: Litoral");
        int loc = Integer.parseInt(sc.next());
        boolean local;
        if(loc == 0) local = true; else local = false;
        int nif = Integer.parseInt(cont.get(0));
        return new Empresarial(nif,cont.get(1),cont.get(3),cont.get(2),cont.get(4),fat,res,local);
    }

    public List<Integer> scanAgregado(int n,String s){
        System.out.println(s);
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(n>0){
          int i = sc.nextInt();
          res.add(i);
          n--;
        }
        return res;
    }

    public Individuais scanNewIndividual(){
        List<String> cont = new ArrayList<String>();
        cont = scanNewContribuinte();
        GestaoFaturas fat = new GestaoFaturas();
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos elementos fazem parte do seu agregado familiar? "); 
        int agregado = Integer.parseInt(sc.next());
        List<Integer> nifAgregado = new ArrayList<Integer>();
        nifAgregado = scanAgregado(agregado,"Digite o nif de cada elemento do seu agregado familiar: ");
        List<Integer> codigos = new ArrayList<Integer>();
        codigos = scanAgregado(2,"Codigos");
        boolean categoria;
        if(agregado > 4) categoria = true; else categoria = false; 
        int nif = Integer.parseInt(cont.get(0));
        return new Individuais(nif,cont.get(1),cont.get(3),cont.get(2),cont.get(4),fat,agregado,nifAgregado,0,codigos,categoria);
    }

    public Fatura scanFatura(int nifEmitente, String nomeEmpresa, List<AtividadesE> at,int nifCont){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a data de despesa: ");
        String dataRecebida = s.nextLine(); 
        LocalDate dt = LocalDate.parse(dataRecebida,DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("Digite uma pequena descrição da fatura que vai emitir: ");
        String descr = s.nextLine();
        System.out.println("Digite o valor da despesa: ");
        double valueSpent = Double.parseDouble(s.nextLine());
        return new Fatura(nifEmitente,nomeEmpresa,dt,nifCont,descr,(int)valueSpent,at);
    }

    public void execBotaoF(int tecla, Individuais ind){
      switch(tecla){
        case 1:{
          GestaoFaturas gf = ind.getListaFaturas();
          gf.ordData();
          System.out.println(gf.toString());
          break;
        }
        case 2:{
          GestaoFaturas gf = ind.getListaFaturas();
          gf.ordValor();
          System.out.println(gf.toString());
          break;
        }
      }
    }

    /**
    * metodo que executa os comandos dispostos para o contribuinte individual
    */
    public void execBotaoI(int tecla,Individuais ind){
        switch(tecla){
          case 1:{
            System.out.println("\n \n Tecla 1 - Ordenada por Data \n Tecla 2 - Ordenada por valor de despesa");
            int k = scanButton(1,2);
            execBotaoF(k,ind);
            break;
          }
          case 2:{
            int f = ind.getListaFaturas().getFaturasPendentes().sizeListaFaturas();
            if(f == 0) {
                System.out.println("\n\n nao existem faturas pendentes \n\n");
                break;
            }
            else{
                System.out.println("    Lista de faturas pendentes     \n");
                System.out.println(ind.getListaFaturas().getFaturasPendentes().toString());
            
                System.out.println("\n\n Deseja: \n Tecla 1 - Definir Atividade \n Tecla 2 - Sair");
                int k = scanButton(1,2);
                if(k==2) break;
                switch(k){
                    case 1:{
                        try{
                            Scanner c = new Scanner(System.in);
                            System.out.println("Qual fatura deseja alterar?\n");
                            int index = c.nextInt();
                            System.out.println("Introduza o codigo da atividade na qual deduz?\n");
                            int cod = c.nextInt();
                            ind.getListaFaturas().atualizaFaturas(cod,index);
                            break;
                        }
                        catch(SemAtividadeException j){System.out.println(j.getMessage());}
                    }
                }
            }
          }
          case 3:{
            System.out.println("\n \n"+ind.toString());
            break;
          }
        }
    }

    /**
     * metodo que executa os comandos dispostos para o contribuinte coletivo
    */
    public void execBotaoE(int tecla,GestaoContribuintes gc,Empresarial emp){
        switch(tecla){
          case 1:{
            System.out.println(emp.getListaFaturas().toString());
            break;
          }
          case 2:{
            int nif = emp.getNif();
            String nomeEmpresa = emp.getNome();
            List<AtividadesE> at = new ArrayList<AtividadesE>();
            at = emp.getInfoAtividades();
            System.out.println("Digite o NIF para o qual pretende emitir a sua fatura: ");
            Scanner sc = new Scanner(System.in);
            int ind = sc.nextInt();
            emp.getListaFaturas().addFatura(scanFatura(nif,nomeEmpresa,at,ind));
            gc.getContribuinte(ind).getListaFaturas().addFatura(scanFatura(nif,nomeEmpresa,at,ind));
            System.out.println("Fatura emitida com sucesso!");
            break;
          }
        }
    }
    
    public Individuais scanIndividual(GestaoContribuintes gc)throws ContNaoExisteException,PassNaoCorrespondeException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu NIF: ");
        int nif = Integer.parseInt(sc.next());
        System.out.println("Digite a sua password de acesso: ");
        String pass = sc.next();
        Individuais c = new Individuais();
        c = gc.getIndividual(nif,pass);
        return c;
    }
    
    public Empresarial scanEmpresa(GestaoContribuintes gc)throws ContNaoExisteException,PassNaoCorrespondeException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu NIF: ");
        int nif = Integer.parseInt(sc.next());
        System.out.println("Digite a sua password de acesso: ");
        String pass = sc.next();
        Empresarial c = new Empresarial();
        c=gc.getEmpresa(nif,pass);
        return c;
    }    

    /**  
    * este método apenas imprime o NIF, o nome do Contribuinte e o montante(aplicado a Individuais) 
    */
    public String toStringI (Contribuinte c){
      StringBuilder str = new StringBuilder();
      str.append("NIF: ")
      .append(c.getNif()).append("\nNome: ").append(c.getNome())
      .append("\n Montante Contribuido: ").append(c.getListaFaturas().getTotalListaFaturas());
      return str.toString();
    }

    /**  
    * este método apenas imprime o NIF, o nome do Contribuinte e o montante(aplicado a Empresas) 
    */
    public String toStringE (Contribuinte c){
      StringBuilder str = new StringBuilder();
      str.append("NIF: ")
      .append(c.getNif()).append("\nNome: ").append(c.getNome())
      .append("\n Montante Contribuido: ").append(c.getListaFaturas().getNumberFaturas());
      return str.toString();
    }

    /**
    * metodo toString para imprimir a lista dos contribuintes que contribuiram mais
    */
    public String toStringLI (List<Contribuinte> list){
      StringBuilder st = new StringBuilder();
      st.append(" Lista dos 10 contribuintes que mais contribuiram: \n");
      for(Contribuinte c: list){
        st.append("\n------------------\n").append(toStringI(c));
      }
      return st.append("\n\n").toString();
    }

    /**
    * metodo toString para imprimir a lista das empresas que emitiram mais faturas
    */
    public String toStringLE (List<Contribuinte> list,int n){
      StringBuilder st = new StringBuilder();
      st.append(" Lista dos "+ n + " empresas que mais faturas emitiram: \n");
      for(Contribuinte c: list){
        st.append("\n------------------\n").append(toStringE(c));
      }
      return st.append("\n\n").toString();
    }

    /**
    * metodo que executa os comandos do administrador
    */
    public void execBotaoA(int tecla,GestaoContribuintes gc){
      switch (tecla) {
        case 1:{
          System.out.println(toStringLI(gc.devolve10MaisGastadores()));
          break;
        }
        case 2:{
          Scanner sc = new Scanner(System.in);
          System.out.println("Defina X: ");
          int n = sc.nextInt();
          System.out.println(toStringLE(gc.empresasComMaisFaturas(n),n));
          break;
        }
        case 3:{break;}
      }
    }


}
