package web.exceptions;

public class UserNotCreatedException extends Throwable{
    public UserNotCreatedException(String errorMessage){
        super(errorMessage);
    }
}
