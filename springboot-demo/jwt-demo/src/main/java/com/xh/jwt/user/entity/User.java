package com.xh.jwt.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Xiong Hao
 */
@Data
@ApiModel("用户信息")
public class User {

    @TableId(type = IdType.AUTO)
    @TableField
    @ApiModelProperty(value = "数据主键id", example = "1")
    protected Long id;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    protected LocalDateTime createTime;

    @TableField(fill = FieldFill.UPDATE)
    @ApiModelProperty(value = "修改时间")
    protected LocalDateTime updateTime;
    @ApiModelProperty(value = "备注")
    protected String remark;

    private static final long serialVersionUID = -8323875279772170574L;

    @ApiModelProperty(value = "用户云信帐号", example = "asdfasdfasdfasdfds")
    private String accid;

    @ApiModelProperty(value = "token", example = "adfasdf8asdfa8dfa", hidden = true)
    String token;

    @ApiModelProperty(value = "mobile", example = "+852-88888888")
    private String mobile;

    @ApiModelProperty(value = "icon", example = "http://test.url")
    private String icon;

    @ApiModelProperty(value = "用户昵称", example = "100001")
    private String name;

    @ApiModelProperty(value = "birth", example = "2000-00-00")
    private String birth;
    
    private String extInfo;

    @ApiModelProperty(value = "用户性别", example = "1", notes = "1 男 2 女 0 未知")
    private Integer gender;

    @ApiModelProperty("扩展信息")
    private String ex;

}
