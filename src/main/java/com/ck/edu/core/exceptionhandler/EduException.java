package com.ck.edu.core.exceptionhandler;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EduException extends RuntimeException{
    private Integer code;//状态码
    private String msg;//异常信息
}
