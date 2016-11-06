package com.rainhowchan.shop.product;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rainhowchan.shop.utils.PageHibernateCallback;

public class ProductDao extends HibernateDaoSupport{

	public List<Product> findHot() {
		/*DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Product.class);
		detachedCriteria.add(Restrictions.eq("is_hot", 1));
		return getHibernateTemplate().findByCriteria(detachedCriteria, 0, 10);*/
		
		return getHibernateTemplate().executeFind(new PageHibernateCallback<Product>("from Product where is_hot=?", 0, 10,1));
	}

	public List<Product> findNew() {
		return getHibernateTemplate().executeFind(new PageHibernateCallback<Product>("from Product order by pdate desc", 0, 10, null));
	}
	
	
}
