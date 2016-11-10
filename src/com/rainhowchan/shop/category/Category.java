package com.rainhowchan.shop.category;

import java.util.HashSet;
import java.util.Set;

import com.rainhowchan.shop.categorysecond.CategorySecond;

public class Category {
	private Integer cid;
	private String cname;
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname
				+ ", categorySeconds=" + categorySeconds + "]";
	}
	
}
