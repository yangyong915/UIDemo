package com.example.a55014.mytest;

import java.io.Serializable;

/**
 * 消息实体或其他实体跳转时所需的额外字段的穷举实体类
 * <p>
 * Created by EmMper on 2017/7/31
 */

public class JumpOpEntity implements Serializable {
    /**
     * 资源类型
     */
    public int op_type;
    /**
     * 资源名称
     */
    public String op_name;

    /**
     * 类型
     */
    public int type;
    /**
     * 资源id
     */
    public int source_id;
    /**
     * 标签值
     */
    public String remark;
    /**
     * 标签值1
     */
    public String redirect_url;
}
