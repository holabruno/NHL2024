package nhl2024.exceptions;

/**
 *
 * @author Bruno Theoret
 */
public class JoueurNonExistantException extends Exception {
    public JoueurNonExistantException(String msg){
        super(msg);
    }
}
