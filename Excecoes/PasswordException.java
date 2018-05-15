package Excecoes;
/**
 * Write a description of class PasswordException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PasswordException extends Exception
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class PasswordException
     */
    public PasswordException()
    {
        super("Password já existe!") ;
    }
}