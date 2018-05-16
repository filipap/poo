package Excecoes;

/**
 * classe de exceçao para a password nao correspondente
 */
public class PassNaoCorrespondeException extends Exception{
    public PassNaoCorrespondeException() {super();}
    public PassNaoCorrespondeException(String s) {super(s);}
}
