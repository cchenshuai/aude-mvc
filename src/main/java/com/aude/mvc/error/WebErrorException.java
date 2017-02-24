package com.aude.mvc.error;


/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/5/9 0009
 * To change this template use File | Settings | File Templates.
 */
public class WebErrorException extends Exception {

    static final long serialVersionUID = -3387516993124229948L;

    public int code;

    public WebErrorException() {
        super();
    }


    public WebErrorException(String message) {
        super(message);
    }


    public WebErrorException(String message, Throwable cause) {
        super(message, cause);
    }


    public WebErrorException(Throwable cause) {
        super(cause);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
