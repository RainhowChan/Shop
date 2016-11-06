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
			addActionError("��֤������!");
			return "registInput";
		} else {
			addActionMessage("ע��ɹ��� ��ȥ���伤�");
			userService.regist(user);
			return "registSuccess";
		}
	}

	public String active() {
		User exitUser = userService.findByCode(user.getCode());
		if (exitUser != null) {
			exitUser.setState(1);
			userService.update(exitUser);
			addActionMessage("����ɹ�����ȥע�ᣡ");
			return "activeSuccess";
		}
		addActionMessage("����ʧ�ܣ���������");
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
			addActionError("��֤������!");
			return "loginInput";
		} else {
			User existUser = userService.login(user);
			if (existUser == null) {
				addActionError("�û��������������û�δ����!");
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
			response.getWriter().print("<font color='green'> �û�������ʹ��</font>");
		else
			response.getWriter().print("<font color='red'> �û����Ѿ�����!</font>");
		return NONE;
	}

}
