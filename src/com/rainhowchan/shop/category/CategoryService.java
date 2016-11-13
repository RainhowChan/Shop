package com.rainhowchan.shop.category;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.rainhowchan.shop.product.Product;
import com.rainhowchan.shop.utils.PageBean;

@Transactional
public class CategoryService {
	
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}
}
