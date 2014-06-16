package com.lib.action;

import com.lib.domain.User;
import com.lib.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	private String name;
	private String orpass;
	private String password;
	private String email;
	private UserService userService;
	
	public String login() {
		int result = userService.login(Integer.parseInt(name), password); 
		if (result == 2 || result == 3) {
			ActionContext.getContext().put("msg", this.getText("用户名或者密码错误!"));
			return "error";
		} else {
			ActionContext.getContext().getSession()
			.put("user", userService.getByName(Integer.parseInt(name)));
			return "success";
		}
	}
	
	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		return "success";
	}
	
	public String updateEmail() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			return "error";
		} else {
			if (email == null) {
				ActionContext.getContext().put("msg", "<span class='label label-important'>邮箱不能为空!</span>");
				return "email";
			} else {
				User u = new User();
				u.setId(user.getId());
				u.setName(user.getName());
				u.setPassword(user.getPassword());
				u.setPower(user.getPower());
				u.setEmail(email);
				if (userService.updateEmail(u) == 1) {
					user.setEmail(email);
					ActionContext.getContext().put("msg", "<span class='label label-success'>修改成功!</span>");
					return "email";
				} else {
					ActionContext.getContext().put("msg", "<span class='label label-important'>邮箱已被注册,换一个试试!</span>");
					return "email";
				}
			}
		}
	}
	
	public String updatePassword() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user == null) {
			return "error";
		} else {
			if (!orpass.equals(user.getPassword())) {
				ActionContext.getContext().put("msg", "<span class='label label-important'>原密码不正确,请重试!</span>");
				return "pass";
			} else {
				user.setPassword(password);
				userService.update(user);
				ActionContext.getContext().put("msg", "<span class='label label-success'>修改成功!</span>");
				return "pass";
			}
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrpass() {
		return orpass;
	}

	public void setOrpass(String orpass) {
		this.orpass = orpass;
	}
}
