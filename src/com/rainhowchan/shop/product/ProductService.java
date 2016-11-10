package com.rainhowchan.shop.product;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.rainhowchan.shop.utils.PageBean;

@Transactional
public class ProductService {
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public List<Product> findHot() {
		return productDao.findHot();
	}

	public List<Product> findNew() {
		return productDao.findNew();
	}

	public PageBean<Product> findByPage(Integer cid, Integer page) {
		int limit=12;
		int totalPage=0;
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPage(page);
		pageBean.setLimit(limit);
		Integer totalCount=productDao.findCount(cid);
		pageBean.setTotalCount(totalCount);
		if(totalCount%limit==0)
			totalPage=totalCount/limit;
		else
			totalPage=totalCount/limit+1;
		pageBean.setTotalPage(totalPage);
		int begin=(page-1)*limit;
		List<Product> products=productDao.findByPage(cid,begin,limit);
		pageBean.setList(products);
		return pageBean;
	}
	
}
