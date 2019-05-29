package com.xh.jwt.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Xiong Hao
 */
@Data
@AllArgsConstructor
@ApiModel("基础响应实体")
public class ResponseResult<T> {

    @ApiModelProperty(value = "响应码", example = "200", required = true)
    private Integer code;

    @ApiModelProperty(value = "响应消息", example = "success")
    private String msg;

    @ApiModelProperty(value = "响应数据")
    private T data;


    public ResponseResult(){
        this.code = Constants.SUCCESS_CODE;
        this.msg = "success";
    }

    public ResponseResult(T data) {
        this.data = data;
        this.code = Constants.SUCCESS_CODE;
        this.msg = "success";
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResponseResult<T> getInstance(T data) {
        return new ResponseResult<>(data);
    }

    public static <T> ResponseResult<T> getInstance() {
        return new ResponseResult<>();
    }

    public static ResponseResult error(String msg){
        return new ResponseResult(400,msg);
    }
}
