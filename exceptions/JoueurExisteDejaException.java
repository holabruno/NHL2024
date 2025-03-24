package nhl2024.exceptions;

/**
 *
 * @author Bruno Theoret
 */
public class JoueurExisteDejaException extends Exception {
    public JoueurExisteDejaException(String msg){
        super(msg);
    }
}
