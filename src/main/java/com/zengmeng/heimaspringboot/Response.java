package com.zengmeng.heimaspringboot;

public class Response <T> {
    private T data;
    private String msg;
    private boolean success;
    public static <K> Response<K> success(K data) {
        Response<K> response = new Response<K>();
        response.setData(data);
        response.setSuccess(true);
        return response;

    }

    public static Response<Void> fail(String msg) {
        Response<Void> response = new Response<Void>();
        response.setSuccess(false);
        response.setMsg(msg);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
