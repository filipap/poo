package Excecoes;


/**
 * ContNaoIndividualException - exceçao caso o contribuinte nao seja do tipo Individuais
 *
 */
public class ContNaoIndividualException extends Exception
{
  public ContNaoIndividualException() {super();}
  public ContNaoIndividualException(String s) {super(s);}  
}
