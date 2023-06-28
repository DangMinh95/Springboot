package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseSuccess {

    private Integer status;

    private String message;

    private Integer size;

    private Object data;

    public ResponseSuccess(Integer status, String message, Integer size, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.size = size;
    }

    public ResponseSuccess(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
