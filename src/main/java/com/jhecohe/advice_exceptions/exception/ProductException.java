package com.jhecohe.advice_exceptions.exception;

public class ProductException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public String code;

    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ProductException(Throwable cause) {
        super(cause);
    }
    
    public String getCode() {
        return code;
    }
}
