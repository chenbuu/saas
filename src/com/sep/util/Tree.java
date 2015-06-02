package com.sep.util;

import java.util.List;

/**
 * 树控件工具类
 *
 * @author ChenTao
 * @date 2014年12月15日下午4:51:53
 */
public class Tree {
    /*id：节点ID，对加载远程数据很重要。
     text：显示节点文本。
     state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
     checked：表示该节点是否被选中。
     attributes: 被添加到节点的自定义属性。
     children: 一个节点数组声明了若干节点。*/

    private Long id;
    private String text;
    private Boolean checked;
    private List<Tree> children;

    /**
     * 默认构造函数
     */
    public Tree() {
    }

    //最简单的构造方法
    public Tree(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Tree(Long id, String text, Boolean checked) {
        this.id = id;
        this.text = text;
        this.checked = checked;
    }

    public Tree(Long id, String text, List<Tree> children) {
        this.id = id;
        this.text = text;
        this.children = children;
    }

    public Tree(Long id, String text, Boolean checked, List<Tree> children) {
        this.id = id;
        this.text = text;
        this.checked = checked;
        this.children = children;
    }

    //Get方法
    public Long getId() {
        return id;
    }

    //Set方法
    public void setId(Long id) {
        this.id = id;
    }

    //Get方法
    public String getText() {
        return text;
    }

    //Set方法
    public void setText(String text) {
        this.text = text;
    }

    //Get方法
    public Boolean getChecked() {
        return checked;
    }

    //Set方法
    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    //Get方法
    public List<Tree> getChildren() {
        return children;
    }

    //Set方法
    public void setChildren(List<Tree> children) {
        this.children = children;
    }

}
