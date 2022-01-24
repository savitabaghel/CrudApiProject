package com.example.crudproject.ExceptionHandle;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class WalletException extends RuntimeException {

    private String errordetail;
    private int code;

    public WalletException(String errordetail, int code) {
        this.errordetail = errordetail;
        this.code = code;
    }

    public WalletException() {
    }
}
