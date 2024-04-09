package br.com.voting.vote.exceptions;

public class ResourceValidationException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public ResourceValidationException(String message) {

        super("Associate validation error! " + message);
    }
}
