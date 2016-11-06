package com.rainhowchan.shop.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport{

	public void save(User user) {
		System.out.println("UserDao regist success!");
		getHibernateTemplate().save(user);
	}

	public User findByCode(String code) {
		List<User> users = getHibernateTemplate().find("from User where code=?",code);
		if(users.size()==0)
			return null;
		else
			return users.get(0);
	}

	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	public User login(User user) {
		List<User> users = getHibernateTemplate().find("from User where username=? and password=? and state=?",user.getUsername(),user.getPassword(),1);
		if(users.size()==0)
			return null;
		else
			return users.get(0);
	}

	public User findByUserName(String userName) {
		List<User> users=getHibernateTemplate().find("from User where username=?",userName);
		if(users.size()==0)
			return null;
		else
			return users.get(0);
	}

	

}
