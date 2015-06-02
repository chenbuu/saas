package com.sep.util;

import org.apache.commons.lang3.StringUtils;


/**
 * 
 * @author ChenTao
 * @date 2014年10月12日下午2:41:45
 */
public class TreeCondition {
    
    private String leftProp;
    
    private String rightProp;
    
    private String startProp;
    
    private Object startValue;
    
    public TreeCondition() {
        
    }
    
    public TreeCondition(String leftProp, String rightProp, String startProp, Object startValue) throws Exception {
        this.leftProp = leftProp;
        this.rightProp = rightProp;
        this.startProp = startProp;
        this.startValue = startValue;
        if (!this.validate()) {
            throw new Exception("参数不完整");
        }
    }
    
    public String getLeftProp() {
        return this.leftProp;
    }

    public void setLeftProp(String leftProp) {
        this.leftProp = leftProp;
    }

    public String getRightProp() {
        return this.rightProp;
    }

    public void setRightProp(String rightProp) {
        this.rightProp = rightProp;
    }

    public String getStartProp() {
        return this.startProp;
    }

    public void setStartProp(String startProp) {
        this.startProp = startProp;
    }

    public Object getStartValue() {
        return this.startValue;
    }

    public void setStartValue(Object startValue) {
        this.startValue = startValue;
    }
    
    public boolean validate() {
        if (StringUtils.isBlank(this.startProp) || StringUtils.isBlank(this.leftProp)
                || StringUtils.isBlank(this.rightProp) || this.startValue == null) {
            return false;
        } else {
            return true;
        }
    }

}
