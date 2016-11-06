package com.rainhowchan.shop.index;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.rainhowchan.shop.category.Category;
import com.rainhowchan.shop.category.CategoryService;
import com.rainhowchan.shop.product.Product;
import com.rainhowchan.shop.product.ProductService;

public class IndexAction extends ActionSupport{
	
	private CategoryService categoryService;
	private ProductService productService;
	private List<Product> hotProducts;
	private List<Product> newProducts;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getHotProducts() {
		return hotProducts;
	}

	public List<Product> getNewProducts() {
		return newProducts;
	}

	@Override
	public String execute() throws Exception {
		List<Category> categories=categoryService.findAll();
		ActionContext.getContext().getSession().put("categories", categories);
		
		hotProducts=productService.findHot();
		newProducts=productService.findNew();
		return "indexSuccess";
	}
	
}
