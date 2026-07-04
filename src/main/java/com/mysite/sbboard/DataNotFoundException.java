package com.mysite.sbboard;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

// HTTP 상태 코드(404) 응답 생성
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
