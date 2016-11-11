package com.rainhowchan.shop.product;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.rainhowchan.shop.category.Category;
import com.rainhowchan.shop.category.CategoryService;
import com.rainhowchan.shop.utils.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	private Integer cid;
	private Integer page;
	private ProductService productService;
	private CategoryService categoryService;
	private PageBean<Product> pageBean;
	private Product product=new Product();
	
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCid() {
		return cid;
	}

	public PageBean<Product> getPageBean() {
		return pageBean;
	}

	@Override
	public Product getModel() {
		return product;
	}
	
	public String findByCid(){
		List<Category> categories = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("categories", categories);
		pageBean=productService.findByPage(cid,page);
		return "findByCidSuccess";
	}
	
	public String findByPid(){
		
		List<Category> categories = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("categories", categories);
		System.out.println(product);
		product=productService.findByPid(product.getPid());
		System.out.println(product);
		return "findByPidSuccess";
	}

}
