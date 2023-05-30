package com.jonah.blog_system.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private static final String CODE_SUCCESS = "success";
    private static final String CODE_SYS_ERROR = "fail";

    private String code;
    private String msg;
    private Object data;


    public static Result success() {
        return new Result(CODE_SUCCESS, "操作成功", null);
    }
    public static Result success( String Msg, Object data) {
        Result result = new Result();
        result.setCode(CODE_SUCCESS);
        result.setMsg(Msg);
        result.setData(data);
        return result;
    }

    public static Result success(String code, String Msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(Msg);
        return result;
    }
    public static Result success( String Msg) {
        Result result = new Result();
        result.setCode(CODE_SUCCESS);
        result.setMsg(Msg);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error( String msg) {
        Result result = new Result();
        result.setCode(CODE_SYS_ERROR);
        result.setMsg(msg);
        return result;
    }
    public static Result error2( String msg) {
        Result result = new Result();
        result.setCode(CODE_SYS_ERROR);
        result.setMsg(msg);
        return result;
    }

}
