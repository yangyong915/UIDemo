package com.example.a55014.mytest;

import java.io.Serializable;

public class TokenEntity implements Serializable {
    // 使用了加密存储、串码字段值不允许更改
    private static final long serialVersionUID = 183062929542821651L;

    public String access_token;// 验证的token
    public String token_type;//token类型
    public long expires_in;//超时时间
    public String refresh_token;//刷新token
    public String account;//当前账户
}
