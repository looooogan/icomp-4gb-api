package com.api.utils;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: Pagination
 * @Description: 分页封装
 * @author: Jivoin
 * @date: 2014年3月27日 上午11:29:31
 */
@Component
@SuppressWarnings("rawtypes")
public class Pagination {
    
    /**
     * @fieldName: pageNum
     * @fieldType: Integer
     * @Description: 当前页号
     */
    public Integer pageNum;
    
    /**
     * @fieldName: pageCount
     * @fieldType: Integer
     * @Description: 每页记录 默认每页10条
     */
    public Integer numPerPage =10;
    
    /**
     * @fieldName: totalNum
     * @fieldType: Integer
     * @Description: 总页数
     */
    public Integer totalNum;
    
    /**
     * @fieldName: pageCount
     * @fieldType: Integer
     * @Description:  根据totalPageNum 和 numPerPage 计算出最大的页数
     */
    public Integer pageCount;
    
    /**
     * @fieldName: results
     * @fieldType: List<Object>
     * @Description: 查询结果
     */
    
	public List results;
    
	public List getResults() {
		return results;
	}

	public void setResults(List results) {
		this.results = results;
	}

	public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

	public Integer getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(Integer numPerPage) {
		this.numPerPage = numPerPage;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
		this.pageCount = this.totalNum/this.numPerPage+(this.totalNum%this.numPerPage!=0?1:0);
		this.pageNum = pageNum>pageCount?pageCount:pageNum;
	}
	

}
