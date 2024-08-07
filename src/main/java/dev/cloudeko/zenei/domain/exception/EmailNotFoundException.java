package dev.cloudeko.zenei.domain.exception;

public class EmailNotFoundException extends BusinessException {

    public EmailNotFoundException() {
        super(3, "email not found");
    }
}
