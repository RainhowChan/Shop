package com.rainhowchan.shop.user;

import org.springframework.transaction.annotation.Transactional;

import com.rainhowchan.shop.utils.MailUtils;
import com.rainhowchan.shop.utils.UUIDUtils;
@Transactional
public class UserService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void regist(User user) {
		user.setState(0);//Î´¼¤»î
		String code = UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		try {
			MailUtils.sendMail(user.getEmail(), code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("UserService regist success!");
	}

	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public User login(User user) {
		return userDao.login(user);
	}

	public User findByUserName(String userName) {
		
		return userDao.findByUserName(userName);
	}

	
	
}
