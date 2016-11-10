package com.rainhowchan.shop.categorysecond;

import java.util.HashSet;
import java.util.Set;

import com.rainhowchan.shop.category.Category;
import com.rainhowchan.shop.product.Product;

public class CategorySecond {
	private Integer csid;
	private String csname;
	private Integer cid;
	private Category category;
	private Set<Product> products=new HashSet<Product>();
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", cid="
				+ cid + "]";
	}
	
	
}
