
/**
 * Menu - classe auxiliar to Teste
 *
 * @author Ana Guimarães(a79987), Filipa Parente (a82145), Francisco Garcia (a54810)
 * 
 */
import java.util.Scanner;
import InterfaceAtividades.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import Excecoes.*;
import java.io.*;
public class Menu {
    
    public int scanButton(int inicio,int fim) throws InputMismatchException{
       Scanner sc = new Scanner(System.in);
          int i = sc.nextInt();
          if (i<inicio || i>fim) {
            throw new InputMismatchException(String.valueOf(i));
          }
          else return i;
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
        System.out.println("Digite o seu NIF: ");
        Scanner sc = new Scanner(System.in);
        String nif = sc.nextLine();
        System.out.println("Digite o seu nome: ");
        String name = sc.nextLine();
        System.out.println("Digite o seu email: ");
        String email = sc.nextLine();
        System.out.println("Digite a sua morada: ");
        String morada = sc.nextLine();
        System.out.println("Digite a sua password de acesso: ");
        String pass = sc.nextLine();
        ArrayList <String> res = new ArrayList<String>();
        res.add(nif);
        res.add(name);
        res.add(email);
        res.add(morada);
        res.add(pass);
        return (List)res;

    }
    public Empresarial scanNewCompany(){
        List<String> cont = scanNewContribuinte();
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
        return new Individuais(nif,cont.get(1),cont.get(3),cont.get(2),cont.get(4),fat,agregado,nifAgregado,codigos,categoria);
    }

    public Fatura scanFatura(Empresarial emp,Individuais ind) throws DateTimeParseException {
        try{
          int nifEmitente = emp.getNif();
          String nomeEmpresa = emp.getNome();
          double mont = 0;
          Scanner s = new Scanner(System.in);
          System.out.println("Digite a data de despesa: \nex: 2011-12-03");
          String dataRecebida = s.nextLine(); 
          LocalDate dt = LocalDate.parse(dataRecebida,DateTimeFormatter.ISO_LOCAL_DATE);
          System.out.println("Digite uma pequena descrição da fatura que vai emitir: ");
          String descr = s.nextLine();
          System.out.println("Digite o valor da despesa: ");
          double valueSpent = Double.parseDouble(s.nextLine());
          List<AtividadesE> at = emp.getInfoAtividades();
          Fatura f = new Fatura(nifEmitente,nomeEmpresa,dt,(ind.getNif()),mont,descr,(int)valueSpent,at);
          f.valorDeduzidoIRS(f,emp,ind);
          return f.clone();
        }
        catch(DateTimeParseException g){
          throw new DateTimeParseException("não escreveu a data no formato correto!",null,g.getErrorIndex());
        }
    }

    public void execBotaoFI(int tecla, Individuais ind){
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
    public void execBotaoI(int tecla,Individuais ind, GestaoContribuintes gc){
        switch(tecla){
          case 1:{
            System.out.println("\nTecla 1 - Ordenada por Data \nTecla 2 - Ordenada por valor de despesa");
           try{
            int k = scanButton(1,2);
            execBotaoFI(k,ind);
            break;
           }
           catch(InputMismatchException j){System.out.println("não digitou nenhum dos botões"); break;}
          }
          case 2:{
            System.out.println("\n \n"+ind.toString());
            break;
          }
          case 3:{
            try{
              int sum = 0;
              for(int i: ind.getNif_agregado()){
                Individuais indiv = gc.getIndividual(i);
                sum+=indiv.getMont_fiscal();
              }
              System.out.println("Montante acumulado pelo agregado familiar: \n" + sum + "€");
              break;
            }
            catch(ContNaoIndividualException j){
              System.out.println("a conta " + j.getMessage() + " não é do tipo individual\n");
              break;
            }
            catch(ContNaoExisteException j){
              System.out.println("não existe utilizador com NIF " + j.getMessage() + "\n");
              break;
            }
          }
          case 4:{
            int f = ind.getListaFaturas().getFaturasPendentes().sizeListaFaturas();
            if(f == 0) {
                System.out.println("\n\n nao existem faturas pendentes \n\n");
                break;
            }
            else{
                System.out.println("    Lista de faturas pendentes     \n");
                System.out.println(ind.getListaFaturas().getFaturasPendentes().toString());
            
                System.out.println("\n\n Deseja: \n Tecla 1 - Definir Atividade \n Tecla 2 - Sair");
               try{ 
                int k = scanButton(1,2);
                switch(k){
                    case 1:{
                        try{
                          Scanner c = new Scanner(System.in);
                          System.out.println("Qual fatura deseja alterar?");
                          int index = c.nextInt();
                          System.out.println("Introduza o codigo da atividade na qual deduz?");
                          int cod = c.nextInt();
                          Fatura fat = ind.getListaFaturas().getFaturasPendentes().getFaturas().get(index);
                          Empresarial emp = gc.getEmpresa(fat.getNifEmitente());
                          ind.getListaFaturas().setFaturas(ind.getListaFaturas().atualizaFaturasAtCorreta(cod,index,gc).getFaturas());
                          Fatura g = fat.clone();
                          //atualizei a lista de faturas do individual
                          ind.getListaFaturas().getFaturasPendentes().atualizaFatura(g, cod,ind,emp);
                          //atualizei a lista de faturas do empresarial
                          emp.getListaFaturas().setFaturas(emp.atualizaFaturasAtCorretaE(fat,g).getFaturas());
                          System.out.println("Operação efetuada com sucesso!\n");
                          break;
                        }
                        catch(ContNaoIndividualException j){
                          System.out.println("a conta " + j.getMessage() + " não é do tipo individual\n");
                          break;
                        }
                        catch(ContNaoEmpresarialException j){
                          System.out.println("a conta " + j.getMessage() + " não é do tipo empresarial\n");
                          break;
                        }
                        catch(ContNaoExisteException j){
                          System.out.println("não existe utilizador com NIF " + j.getMessage() + "\n");
                          break;
                        }
                    }
                    case 2:{
                      break;
                    }
                }
              }
              catch(InputMismatchException j){System.out.println("não digitou nenhum dos botões");break;}
            }
          }
        }
    }

    public void execBotaoFE(int tecla, Empresarial emp){
      switch(tecla){
        case 1:{
          System.out.println("\nEm algum intervalo específico? \n Tecla 1 - Sim \n Tecla 2 - Não \n");
          int k = scanButton(1,2);
          switch(k){
            case 1:{
             try{
              Scanner s = new Scanner(System.in);
              System.out.println("Digite o contribuinte no qual deseja obter a lista de faturas:");
              int nif = Integer.parseInt(s.nextLine());
              System.out.println("Digite a data inicial: \nex: 2011-12-03");
              String dataRecebida1 = s.nextLine();
              LocalDate dt1 = LocalDate.parse(dataRecebida1,DateTimeFormatter.ISO_LOCAL_DATE);
              System.out.println("Digite a data final: \nex: 2011-12-03");
              String dataRecebida2 = s.nextLine();
              LocalDate dt2 = LocalDate.parse(dataRecebida2,DateTimeFormatter.ISO_LOCAL_DATE);
              System.out.println("\n" + emp.fatBetweenDates(nif,dt1,dt2).toString() + "\n");
              break;
             } 
             catch(DateTimeParseException g){
              System.out.println("\nnão escreveu a data no formato correto!\n");
              break;
             }
            }
            case 2:{
             Scanner s = new Scanner(System.in);
             System.out.println("Digite o contribuinte no qual deseja obter a lista de faturas:");
             int nif = Integer.parseInt(s.nextLine());
             GestaoFaturas gf = emp.fatNif(nif);
             gf.ordData();
             System.out.println("\n" + gf.toString() + "\n");
             break;
            }
          }
          break;
        }
        case 2:{
          Scanner s = new Scanner(System.in);
          System.out.println("Digite o contribuinte no qual deseja obter a lista de faturas:");
          int nif = Integer.parseInt(s.nextLine());
          GestaoFaturas gf = emp.fatNif(nif);
          gf.ordValor();
          System.out.println("\n" + gf.toString() + "\n");
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
            System.out.println("\nTecla 1 - Ordenada por Data \nTecla 2 - Ordenada por valor de despesa");
            int k = scanButton(1,2);
            execBotaoFE(k,emp);
            break;
          }
          case 2:{
            try{  
              List<AtividadesE> at = new ArrayList<AtividadesE>();
              System.out.println("Digite o NIF para o qual pretende emitir a sua fatura: ");
              Scanner sc = new Scanner(System.in);
              int ind = Integer.parseInt(sc.next());
              Individuais indiv = gc.getIndividual(ind);
              Fatura f = scanFatura(emp,indiv);
              emp.getListaFaturas().addFatura(f);
              gc.getIndividual(ind).getListaFaturas().addFatura(f);
              System.out.println("Fatura emitida com sucesso!\n");
              break;
            }
            catch(ContNaoIndividualException e){
              System.out.println("o contribuinte " + e.getMessage() + " não é do tipo individual\n");
              break;
            }
            catch(ContNaoExisteException c){
              System.out.println("não existe contribuinte com NIF " + c.getMessage() + "\n");
              break;
            }
            catch(DateTimeParseException g){
              System.out.println("não escreveu a data no formato correto!");
              break;
            }
          }
          case 3:{
             Scanner s = new Scanner(System.in);
             System.out.println("Digite a data inicial: \nex: 2011-12-03");
             String dataRecebida1 = s.nextLine();
             LocalDate dt1 = LocalDate.parse(dataRecebida1,DateTimeFormatter.ISO_LOCAL_DATE);
             System.out.println("Digite a data final: \nex: 2011-12-03");
             String dataRecebida2 = s.nextLine();
             LocalDate dt2 = LocalDate.parse(dataRecebida2,DateTimeFormatter.ISO_LOCAL_DATE);
             System.out.println("Total faturado entre " + dt1.toString() + " e " + dt2.toString() + "\n");
             System.out.println((emp.totalFaturado(dt1,dt2)) + "€");
             break;
          }
        }
    }
    
    public Individuais scanIndividual(GestaoContribuintes gc)throws ContNaoExisteException,PassNaoCorrespondeException,ContNaoIndividualException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu NIF: ");
        int nif = Integer.parseInt(sc.next());
        System.out.println("Digite a sua password de acesso: ");
        String pass = sc.next();
        Individuais c = new Individuais();
        c = gc.getIndividualPass(nif,pass);
        return c;
    }
    
    public Empresarial scanEmpresa(GestaoContribuintes gc)throws ContNaoExisteException,PassNaoCorrespondeException,ContNaoEmpresarialException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu NIF: ");
        int nif = Integer.parseInt(sc.next());
        System.out.println("Digite a sua password de acesso: ");
        String pass = sc.next();
        Empresarial c = new Empresarial();
        c=gc.getEmpresaPass(nif,pass);
        return c;
    }    

    /**  
    * este método apenas imprime o NIF, o nome do Contribuinte e o montante(aplicado a Individuais) 
    */
    public String toStringI (Contribuinte c){
      StringBuilder str = new StringBuilder();
      str.append("NIF: ")
      .append(c.getNif()).append("\nNome: ").append(c.getNome())
      .append("\nMontante Contribuido: ").append(c.getListaFaturas().getTotalListaFaturas());
      return str.toString();
    }

    /**  
    * este método apenas imprime o NIF, o nome do Contribuinte e o montante(aplicado a Empresas) 
    */
    public String toStringE (Contribuinte c){
      StringBuilder str = new StringBuilder();
      str.append("NIF: ")
      .append(c.getNif()).append("\nNome: ").append(c.getNome())
      .append("\nMontante Contribuido: ").append(c.getListaFaturas().getNumberFaturas());
      return str.toString();
    }

    /**
    * metodo toString para imprimir a lista dos contribuintes que contribuiram mais
    */
    public String toStringLI (List<Contribuinte> list){
      StringBuilder st = new StringBuilder();
      st.append("\nLista dos 10 contribuintes que mais contribuiram: \n");
      for(Contribuinte c: list){
        st.append("\n------------------\n").append(toStringI(c) + "€");
      }
      return st.append("\n\n").toString();
    }

    /**
    * metodo toString para imprimir a lista das empresas que emitiram mais faturas
    */
    public String toStringLE (List<Contribuinte> list,int n){
      StringBuilder st = new StringBuilder();
      st.append("\nLista das "+ n + " empresas que mais faturas emitiram: \n");
      for(Contribuinte c: list){
        st.append("\n------------------\n").append(toStringE(c));
      }
      return st.append("\n\n").toString();
    }

    /**  
    * este método apenas imprime o NIF, o nome do Contribuinte e o montante deduzido (aplicado a Empresas) 
    */
    public String toStringEX (Contribuinte c){
      StringBuilder str = new StringBuilder();
      str.append("NIF: ")
      .append(c.getNif()).append("\nNome: ").append(c.getNome())
      .append("\nMontante deduzido: ").append(c.getMont_fiscal() + "€");
      return str.toString();
    }

    /**
    * metodo toString para imprimir a lista das empresas que deduziram mais
    */
    public String toStringLEX (List<Contribuinte> list,int n){
      StringBuilder st = new StringBuilder();
      st.append("\nLista das "+ n + " empresas que mais deduziram: \n");
      for(Contribuinte c: list){
        st.append("\n------------------\n").append(toStringEX(c));
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
        case 3:{
          Scanner sc = new Scanner(System.in);
          System.out.println("Defina X: ");
          int n = sc.nextInt();
          System.out.println(toStringLEX(gc.xEmpresasQueMaisDeduzem(n),n));
          break;
        }
        case 4:{
          System.out.println("\nExistem "  + gc.contaContribuintes() + " contribuintes no sistema dos quais: ");
          System.out.println(" - " + gc.contaEmpresas() + " são do tipo coletivo");
          System.out.println(" - " + gc.contaIndividuais() + " são do tipo individual\n");
          break;
        }
        case 5:{
          System.out.println("\nExistem "  + gc.contaFaturasPendentes() + " faturas pendentes ");
        }
      }
    }


}
