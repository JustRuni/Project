package cn.read.mapper;

import java.util.List;

import cn.read.dao.User;
import cn.read.dto.UserInfo;

public interface UserMapper {
		
		//删除用户，返回影响行数
		int deleteUserByid(Integer id);

		//根据姓名查找用户
		UserInfo findByUsername(String username);
		
		//遍历所有用户信息
		List<UserInfo> findUserInfo();
		
		//根据姓名查找用户
		List<UserInfo> selectByname(String username);
		
		//根据用户id更新用户信息
		int updatebyId(int id, UserInfo userInfo);
		
		//增添用户
		int addUser(UserInfo user);

		UserInfo findUserId(Integer id);

		void updateUser(UserInfo user);
}
