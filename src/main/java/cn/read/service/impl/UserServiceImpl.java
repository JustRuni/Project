package cn.read.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import cn.read.dao.User;
import cn.read.dto.UserInfo;
import cn.read.mapper.UserMapper;
import cn.read.service.UserService;
import cn.read.util.CommonUtil;
import cn.read.util.Sercuity;

@Service("userServiceimpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public boolean userexit(UserInfo user) {
		List<UserInfo> list = (List<UserInfo>) userMapper.selectByname(user.getUsername());
		if (list.size() == 0) {
			return true;
		} else
			return false;
	}

	public boolean add(UserInfo user) {
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
		return userMapper.addUser(user) == 1;
	}

	/* 验证用户登入 */
	/*
	 * public boolean validate(User user) { if(user !=
	 * null&&!CommonUtil.isEmpty(user.getUsername())
	 * &&!CommonUtil.isEmpty(user.getPassword())) { List<User> listUser =
	 * userMapper.select(user); if(listUser.size()==1) {
	 * BeanUtils.copyProperties(listUser.get(0),user); return true; } }
	 * 
	 * return false; }
	 */

	/* 修改用户信息 */

	public boolean remove(int id) {
		if (userMapper.deleteUserByid(id) == 1) {
			return true;
		}
		return false;
	}

	public List<UserInfo> findUserList() {
		List<UserInfo> list = userMapper.findUserInfo();
		return list;

	}

	public boolean edittByidS(int id, UserInfo userInfo) {

		return (1 == userMapper.updatebyId(id, userInfo));
	}

	public UserInfo findUserByid(Integer id) {
		return (userMapper.findUserId(id));
	}

	public void updateUserInfo(UserInfo user) {
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
		userMapper.updateUser(user);

	}

	public UserInfo deleteUserByid(Integer id) {
		userMapper.deleteUserByid(id);
		return null;
	}

	public UserInfo findUserByname(String username) {
		UserInfo userinfo = userMapper.findByUsername(username);
		return userinfo;
	}
}
