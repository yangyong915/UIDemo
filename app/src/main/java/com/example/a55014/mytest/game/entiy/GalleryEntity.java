package com.example.a55014.mytest.game.entiy;

import java.io.Serializable;

/**
 * @author yy
 * Create by 2019/12/26 9:42
 * to do
 */
public class GalleryEntity implements Serializable {

    /**
     * 单词id
     */
    public int id;
    /**
     * 单词内容
     */
    public String word;

    //本地字段
    /**
     * 是否开灯
     */
    public boolean isLight = false;
    /**
     * 子项是否点亮
     */
    public boolean isOpen = false;

}
