package com.sep.util;

import java.util.Map;

import com.sep.util.Consts;

/**
 * 分页信息对象。默认情况下认为需要分页并排序。
 * 如果不需要分页，需要调用setNeedsPaginate()方法。
 * 如果不需要排序，需要调用setNeedsSort()方法。
 * @author ChenTao
 * @date 2014年10月12日下午2:42:10
 */
public class Pagination {
	
	/**
	 * 标记是否分页。
	 */
	private boolean needsPaginate;
	
	/**
	 * 标记是否排序。
	 */
	private boolean needsSort;

	/**
	 * 分页的起始记录序号。
	 */
	private int startPos;
	
	/**
	 * 每页需要取出的记录大小。
	 */
	private int amount;
	
	/**
	 * 需要排序的属性名。
	 */
	private String sortProperty;
	
	/**
	 * 是否正向排序
	 */
	private boolean asc;
	
	/**
	 * 需要排序的属性与是否顺序排序键值对
	 */
	private Map<String, Boolean> sortPropertyMap;
	
	/**
	 * 默认构造函数，默认不分页不排序。
	 */
	public Pagination() {
	    this(false, false);
	}
	
	/**
	 * 不分页只排序
	 * 必须指定排序的属性以及是升序还是降序
	 * 构造函数
	 * @param needsSort
	 * @param sortProperty
	 * @param asc
	 */
	public Pagination(String sortProperty, boolean asc) {
        this(false, Consts.PAGE_START, Consts.PAGE_SIZE, true, sortProperty, asc);
	}
	
	/**
	 * 可以分别指定是否需要分页和需要排序的对象。
	 * 如果指定了需要分页，那么调用者必须保证为其添加分页信息，否则默认从第一条记录开始，每页30条记录。
	 * 如果指定了需要排序，那么调用者必须保证为其添加排序信息，否则默认以id属性顺序排列。
	 * @param needsPaginate 是否需要分页。
	 * @param needsSort 是否需要排序。
	 */
	public Pagination(boolean needsPaginate, boolean needsSort) {
	    this(needsPaginate, Consts.PAGE_START, Consts.PAGE_SIZE, needsSort, Consts.SORT_FIELD_NAME, Consts.SORT_ASC);
	}

	/**
	 * 即分页也排序，并给出相应的参数。
	 * @param startPos 分页的起始记录编号。
	 * @param amount 每页大小。
	 * @param sortProperty 需要排序的属性。
	 * @param asc 是否顺序排序。
	 */
	public Pagination(int startPos, int amount, String sortProperty, boolean asc) {
	    this(true, startPos, amount, true, sortProperty, asc);
	}
	
	/**
	 * 即分页也排序，并给出相应的参数。
	 * @param startPos 分页的起始记录编号。
	 * @param amount 每页大小。
	 * @param sortPropertyMap 需要排序的属性与是否顺序排序键值对。
	 */
	public Pagination(int startPos, int amount, Map<String, Boolean> sortPropertyMap) {
	    this(true, startPos, amount, true, sortPropertyMap);
	}
    
    /**
     * 即分页也排序，并给出相应的参数。
     * @param startPos 分页的起始记录编号。
     * @param amount 每页大小。
     * @param sortPropertyMap 需要排序的属性与是否顺序排序键值对。
     */
    public Pagination(boolean needsPaginaton, int startPos, int amount, boolean needsSort, String sortProperty, boolean asc) {
        this.needsPaginate = needsPaginaton;
        this.needsSort = needsSort;
        this.startPos = startPos;
        this.amount = amount;
        this.sortProperty = sortProperty;
        this.asc = asc;
    }
    
    /**
     * 即分页也排序，并给出相应的参数。
     * @param startPos 分页的起始记录编号。
     * @param amount 每页大小。
     * @param sortPropertyMap 需要排序的属性与是否顺序排序键值对。
     */
    public Pagination(boolean needsPaginaton, int startPos, int amount, boolean needsSort, Map<String, Boolean> sortPropertyMap) {
        this.needsPaginate = needsPaginaton;
        this.needsSort = needsSort;
        this.startPos = startPos;
        this.amount = amount;
        this.sortPropertyMap = sortPropertyMap;
    }

	/**
	 * @return the needsPaginate
	 */
	public boolean isNeedsPaginate() {
		return this.needsPaginate;
	}

	/**
	 * @param needsPaginate the needsPaginate to set
	 */
	public void setNeedsPaginate(boolean needsPaginate) {
		this.needsPaginate = needsPaginate;
	}

	/**
	 * @return the needsSort
	 */
	public boolean isNeedsSort() {
		return this.needsSort;
	}

	/**
	 * @param needsSort the needsSort to set
	 */
	public void setNeedsSort(boolean needsSort) {
		this.needsSort = needsSort;
	}

	/**
	 * @return the startPos
	 */
	public int getStartPos() {
		return this.startPos;
	}

	/**
	 * @param startPos the startPos to set
	 */
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
	
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return this.amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the sortProperty
	 */
	public String getSortProperty() {
		return this.sortProperty;
	}

	/**
	 * @param sortProperty the sortProperty to set
	 */
	public void setSortProperty(String sortProperty) {
		this.sortProperty = sortProperty;
	}

	/**
	 * @return the asc
	 */
	public boolean isAsc() {
		return this.asc;
	}

	/**
	 * @param asc the asc to set
	 */
	public void setAsc(boolean asc) {
		this.asc = asc;
	}

    public Map<String, Boolean> getSortPropertyMap() {
        return this.sortPropertyMap;
    }

    public void setSortPropertyMap(Map<String, Boolean> sortPropertyMap) {
        this.sortPropertyMap = sortPropertyMap;
    }
}
