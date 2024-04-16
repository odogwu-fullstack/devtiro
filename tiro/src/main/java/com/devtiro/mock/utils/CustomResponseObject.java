package com.devtiro.mock.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponseObject {
    private String message;
    private int code;

    private Object data;

    private String error;

    private Boolean isSuccess;
}
