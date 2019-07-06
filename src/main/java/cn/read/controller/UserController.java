package cn.read.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.read.dao.User;
import cn.read.dto.UserInfo;
import cn.read.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceimpl;
	/* private HttpSession session; */
	//遍历所有用户信息
	@RequestMapping("/findUseList")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView findAllUseList() {
		ModelAndView mv = new ModelAndView();
		List<UserInfo> userList = userServiceimpl.findUserList();
		mv.addObject("userList", userList);
		mv.setViewName("user-list");
		return mv;
	}
	//新建用户信息
	@RequestMapping("/add")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView add(UserInfo user) {
		ModelAndView mv = new ModelAndView();
		if(userServiceimpl.userexit(user)) {
			System.out.println(userServiceimpl.add(user));
			List<UserInfo> userList = userServiceimpl.findUserList();
			mv.addObject("userList", userList);
			mv.setViewName("user-list");
			return mv;
		}
		mv.setViewName("error");
		return mv;
	}
	
	@RequestMapping("/findByname")
	public  ModelAndView FindByname(String username) {
		ModelAndView mv = new ModelAndView();
		UserInfo userInfo = userServiceimpl.findUserByname(username);
		mv.addObject("user", userInfo);
		mv.setViewName("password-edit");
		return mv;
	}
	//编辑用户信息
	@RequestMapping("/editById")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView editBy(int id , UserInfo userInfo) {
		ModelAndView modelAndView = new ModelAndView();
		if(userServiceimpl.edittByidS(id, userInfo)) {
			List<UserInfo> userList = userServiceimpl.findUserList();
			modelAndView.addObject("userList", userList);
			
		}
		else {
			String str = "操作失败";
			modelAndView.addObject("str", str);
		}
		modelAndView.setViewName("user-list");
		return modelAndView;
	}
	//删除用户
	@RequestMapping("/deleteById")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView deleteByid(int id) {
		ModelAndView modelAndView = new ModelAndView();
		if(userServiceimpl.remove(id)) {
			List<UserInfo> userList = userServiceimpl.findUserList();
			modelAndView.addObject("userList", userList);
		}
		else {
			String str = "操作失败";
			modelAndView.addObject("str", str);
		}
		modelAndView.setViewName("user-list");
		return modelAndView;
	}
	
	//更新用户信息
	@RequestMapping("/editUser")
	public ModelAndView EditUserById(Integer id) {
		UserInfo user = userServiceimpl.findUserByid(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user-edit");
		return mv;
	}
	@RequestMapping("/deleteUser")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String DeleteUser(Integer id) {
		UserInfo user = userServiceimpl.deleteUserByid(id);
		return "redirect:/user/findUseList";
	}
	/*
	 * @RequestMapping("/updateUser") public ModelAndView UpdateUser(UserInfo user)
	 * { userServiceimpl.updateUserInfo(user); ModelAndView mv = new ModelAndView();
	 * List<UserInfo> userList = userServiceimpl.findUserList();
	 * mv.addObject("userList", userList); mv.setViewName("user-list"); return mv; }
	 */
}
