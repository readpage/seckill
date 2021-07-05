package com.example.response;

public class ResultUtils {
    /**
     * 这里是使用链式编程
     */
    public static Result ok() {
        Result result=new Result(ResultCode.SUCCESS);
        return result;
    }

    public static Result error() {
        Result result = new Result(ResultCode.FAIL);
        return result;
    }


    public static Result error(ResultCode resultCode) {
        Result result=new Result(resultCode);
        return result;
    }

}
