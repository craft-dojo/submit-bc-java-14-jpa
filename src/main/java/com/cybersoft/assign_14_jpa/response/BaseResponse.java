package com.cybersoft.assign_14_jpa.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private int code;
    private String message;
    private Object data;

    public static BaseResponse success(Object data, String message, HttpStatus code) {
        return BaseResponse.builder()
                .code(code != null ? code.value() : HttpStatus.OK.value())
                .message(message != null ? message : "Success")
                .data(data)
                .build();
    }
}
