package com.example.a55014.mytest.game.entiy;

import java.io.Serializable;

/**
 * @author yy
 * Create by 2019/12/30 10:03
 * to do
 */
public class RandomLocationEntity implements Serializable {

    //对于父布局的相对位置
    public int locationX = 0;

    public int locationY = 0;

    /**
     * 是否是干扰项
     */
    public boolean isDistractor = false;
}
