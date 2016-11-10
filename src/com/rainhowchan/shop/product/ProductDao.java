package com.rainhowchan.shop.product;

import java.util.List;

import org.hibernate.classic.Session;
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
//p CategorySecond cs where p.categorySecond=cs and cs.category.cid=?
	public Integer findCount(Integer cid) {
		List<Long> list = getHibernateTemplate().find("select count(*) from Product p , CategorySecond cs where p.categorySecond = cs and cs.category.cid = ?",cid);
		return list.get(0).intValue();
	}

	public List<Product> findByPage(Integer cid, int begin, int limit) {
//		String hql="from Product p,CategorySecond cs where p.categorySecond =cs and cs.category.cid=?";
		String hql="select p from Product p join p.categorySecond cs join cs.category c where c.cid=?";
		List<Product> products = getHibernateTemplate().executeFind(new PageHibernateCallback<Product>(hql, begin, limit, cid));
		if(products.size()>0)
			System.out.println(products.get(0).toString());
		return products;
	}
	
	
}
