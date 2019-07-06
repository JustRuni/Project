package cn.read.util;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.read.dto.UserInfo;
import cn.read.service.impl.UserServiceImpl;


@Controller
@RequestMapping("/reg")
public class Doreg {
	
	@Autowired
	private UserServiceImpl userServiceimpl;
	@RequestMapping("/addUser")
	public String addUser(UserInfo user) {
		if(userServiceimpl.userexit(user)) {
			System.out.println(userServiceimpl.add(user));
			return"redirect:/login.jsp";
		}
		return null;
	}
}
