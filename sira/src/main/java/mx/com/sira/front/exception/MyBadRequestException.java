package mx.com.sira.front.exception;

/**
 * Created by gerry on 10/23/18.
 */
public class MyBadRequestException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
    public MyBadRequestException(String body) {
        super(body);
    }
}
