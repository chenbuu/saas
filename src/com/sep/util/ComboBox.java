package com.sep.util;

/**
 * 下拉框工具类
 *
 * @author ChenTao
 * @date 2014年12月15日下午4:51:53
 */
public class ComboBox {

    private Long id;
    private String text;

    /**
     * 默认构造函数
     */
    public ComboBox() {
    }

    /**
     * 全构造函数
     */
    public ComboBox(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    // Get方法
    public Long getId() {
        return id;
    }

    // Set方法
    public void setId(Long id) {
        this.id = id;
    }

    // Get方法
    public String getText() {
        return text;
    }

    // Set方法
    public void setText(String text) {
        this.text = text;
    }

}
