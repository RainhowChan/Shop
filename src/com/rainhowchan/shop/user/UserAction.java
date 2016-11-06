package com.rainhowchan.shop.user;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String registPage() {
		return "registPageSuccess";
	}

	@InputConfig(resultName = "registInput")
	public String regist() {
		String checkImageCode = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if (checkImageCode == null
				|| !checkImageCode.equalsIgnoreCase(user.getCode())) {
			addActionError("验证码有误!");
			return "registInput";
		} else {
			addActionMessage("注册成功！ 请去邮箱激活！");
			userService.regist(user);
			return "registSuccess";
		}
	}

	public String active() {
		User exitUser = userService.findByCode(user.getCode());
		if (exitUser != null) {
			exitUser.setState(1);
			userService.update(exitUser);
			addActionMessage("激活成功！请去注册！");
			return "activeSuccess";
		}
		addActionMessage("激活失败！激活有误！");
		return "activeFail";
	}

	public String loginPage() {
		return "loginPageSuccess";
	}

	@InputConfig(resultName = "loginInput")
	public String login() {
		String checkImageCode = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if (checkImageCode == null
				|| !checkImageCode.equalsIgnoreCase(user.getCode())) {
			addActionError("验证码有误!");
			return "loginInput";
		} else {
			User existUser = userService.login(user);
			if (existUser == null) {
				addActionError("用户名或密码错误或用户未激活!");
				return "loginInput";
			} else {
				ServletActionContext.getRequest().getSession()
						.setAttribute("existUser", existUser);
				return "loginSuccess";
			}
		}
	}

	public String exit() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object attribute = session.getAttribute("existUser");
		if (attribute != null)
			session.removeAttribute("existUser");
		return "loginSuccess";
	}

	public String checkUserName() throws IOException {

		User existUser = userService.findByUserName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if (existUser == null)
			response.getWriter().print("<font color='green'> 用户名可以使用</font>");
		else
			response.getWriter().print("<font color='red'> 用户名已经存在!</font>");
		return NONE;
	}

}
