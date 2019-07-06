package cn.read.service;


import java.util.List;

import cn.read.dao.User;
import cn.read.dto.UserInfo;
/*
 * 		验证登入
 * 		注册
 * */
public interface UserService {
	
		boolean add(UserInfo user);

		 boolean remove(int id);
		 
		 boolean edittByidS(int id, UserInfo userInfo);
		
		List<UserInfo> findUserList();
}
