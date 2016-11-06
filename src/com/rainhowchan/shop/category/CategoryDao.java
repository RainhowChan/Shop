package com.rainhowchan.shop.category;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CategoryDao extends HibernateDaoSupport{

	public List<Category> findAll() {
		
		return getHibernateTemplate().find("from Category");
	}

}
