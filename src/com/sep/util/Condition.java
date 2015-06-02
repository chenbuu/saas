package com.sep.util;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;



/**
 * 简单查询条件对象。
 * @author ChenTao
 * @date 2014年10月12日下午2:43:32
 */
public class Condition implements Serializable {

    private static final long serialVersionUID = 9104106721299671325L;

    private String property;
    
    private String signal;
    
    /**
     * 参数名。可以省略
     */
    private String paramName;
    
    private String methodName;
    
    private String dateFormat;
    
    private Object value;
    
    private String type;
    
    private Boolean isDefaultAlias = true;
    
    private  String alias;
    
    /**
     * 默认构造函数
     */
    public Condition() {
    }
    
    /**
     * 构造函数
     */
    public Condition(String propName, String signal, Object value) {
    	this(propName, signal, value, null);
    }
    
    /**
     * 构造函数
     */
    public Condition(String propName, String signal, Object value, String paramName) {
        this.property = propName;
        this.signal = signal;
        this.value = value;
        this.paramName = paramName;
    }
    

    /**
     * 构造函数 根据日期查询
     * @param propName
     * @param signal
     * @param value
     * @param paramName
     * @param methodName 函数名
     * @param dateFormat 日期格式
     */
    public Condition(String propName, String signal, Object value, String paramName, 
            String methodName, String dateFormat) {
        this.property = propName;
        this.signal = signal;
        this.value = value;
        this.paramName = paramName;
        this.methodName = methodName;
        this.dateFormat = dateFormat;
    }

    /**
     * 构造函数 根据日期查询
     * @param propName
     * @param signal
     * @param value
     * @param paramName
     * @param methodName 函数名
     * @param dateFormat 日期格式
     * @param type 类型 是否添加and
     */
    public Condition(String propName, String signal, Object value, String paramName, 
            String methodName, String dateFormat, String type) {
        this.property = propName;
        this.signal = signal;
        this.value = value;
        this.paramName = paramName;
        this.methodName = methodName;
        this.dateFormat = dateFormat;
        this.type = type;
    }
    
    /**
     * 
     * @param propName 属性名称 
     * @param siglanl  比较操作符
     * @param value	       属性对应值
     * @param paramName 对应参数名称
     * @param isDefaultAlias 是否使用默认表别名
     * @param alias (isDefaultAlias 为false时表别不为空)
     * @throws Exception 
     */
    public Condition(String propName,String signal,Object value,String paramName,boolean isDefaultAlias,String alias) throws Exception{
        this.property = propName;
        this.signal = signal;
        this.value = value;
        this.paramName = paramName;
        this.isDefaultAlias = isDefaultAlias;
        this.alias = alias;
        if(!this.isDefaultAlias&&StringUtils.isBlank(this.alias)){
        	throw new Exception("不使用默认别名的情况下,别名不能为空");
        }
    }

	/**
     * @return the property
     */
    public String getProperty() {
        return this.property;
    }

    /**
     * @param property the property to set
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * @return the signal
     */
    public String getSignal() {
        return this.signal;
    }

    /**
     * @param signal the signal to set
     */
    public void setSignal(String signal) {
        this.signal = signal;
    }
    
    /**
     * @return 返回属性 placeHolder
     */
    public String getParamName() {
        return this.paramName;
    }
    
    /**
     * @param placeHolder 设置属性 placeHolder 的值
     */
    public void setParamName(String placeHolder) {
        this.paramName = placeHolder;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return new StringBuilder()
            .append(this.property)
            .append(" ").append(this.signal).append(" ")
            .append(this.value)
            .toString();
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsDefaultAlias() {
		return isDefaultAlias;
	}

	public void setIsDefaultAlias(Boolean isDefaultAlias) {
		this.isDefaultAlias = isDefaultAlias;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
    
    
}
